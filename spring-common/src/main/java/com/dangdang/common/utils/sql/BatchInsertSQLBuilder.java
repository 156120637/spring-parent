package com.dangdang.common.utils.sql;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.*;

/**
 * 拼接批量插入语句工具类
 * 只支持javaBean, 不支持其他任何java类, 否则报错
 */
public class BatchInsertSQLBuilder<T> {

    /**
     * 表名
     */
    private String tableName;

    /**
     * 是否为全量更新
     */
    private boolean selective = true;

    /**
     * 要插入的属性的get方法名称
     */
    private TreeSet<String> fields = new TreeSet<>();

    /**
     * 待插入的数据
     */
    private List<T> dataList = new LinkedList<>();

    /**
     * 最终拼接的SQL语句
     */
    private StringBuffer sql = new StringBuffer();

    private static final String open = " (";

    private static final String close = ") ";

    private static final String conjunction = ", ";

    /**
     * 设置表名
     */
    public BatchInsertSQLBuilder setInsertTable(String tableName) {

        Assert.notNull(tableName, "insert table is empty");
        this.tableName = tableName;
        return this;
    }

    /**
     * 设置是否为全量更新
     *
     * @param selective
     * @return
     */
    public BatchInsertSQLBuilder setSelective(boolean selective) {

        this.selective = selective;
        return this;
    }

    /**
     * 插入数据
     * @param obj
     * @return
     */
    @SuppressWarnings("all")
    public BatchInsertSQLBuilder setData(T obj) {

        Class<?> clazz = obj.getClass();
        // 反射获取javaBean的方法
        Method[] methods = clazz.getMethods();
        boolean flag = false;
        for (Method method : methods) {
            // 如果是get开头, 就是javaBean的get方法
            if (method.getName().startsWith("get") && !method.getName().equalsIgnoreCase("getClass")) {
                if (selective) {
                    try {
                        // 如果方法值不为空, 则将该字段加入到最终映射字段中
                        if (!Objects.isNull(method.invoke(obj))) {
                            if (!flag) {
                                flag = true;
                            }
                            fields.add(method.getName());
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (!flag) {
                        flag = true;
                    }
                    fields.add(method.getName());
                }
            }
        }
        if (flag) {
            // 如果字段不全为空, 则将数据加入到数据集中
            dataList.add(obj);
        }
        return this;
    }

    /**
     * 获取Bean 字段的名称, 以get方法为准
     * @param getMethodName
     * @return
     */
    @SuppressWarnings("all")
    private String getBeanFieldName(String getMethodName) {

        String substring = getMethodName.substring(3);
        // 将get字符截取去除之后, 将剩余字符的首字母转换为小写字母
        String substring1 = substring.substring(0, 1);
        String s = substring1.toLowerCase();
        String substring2 = substring.substring(1);
        return s + substring2;
    }

    /**
     * 获取批量插入SQL
     * @return
     */
    @Override
    public String toString() {

        if (!sql.toString().isEmpty()) {
            return sql.toString();
        }
        if (StringUtils.isBlank(tableName)) {
            throw new IllegalArgumentException("insert table name is null");
        }
        if (CollectionUtils.isEmpty(fields)) {
            throw new IllegalArgumentException("fields is null");
        }
        sql.append("INSERT INTO " + tableName);
        sql.append(open);
        Iterator<String> iterator = fields.iterator();
        while (iterator.hasNext()) {
            String field = iterator.next();
            sql.append(SQLUtils.humpToUnderline(getBeanFieldName(field)));
            if (iterator.hasNext()) {
                sql.append(conjunction);
            }
        }
        sql.append(close);
        sql.append("VALUES ");
        Iterator<T> iterator1 = dataList.iterator();
        // 遍历对象集合
        while (iterator1.hasNext()) {
            T t = iterator1.next();
            sql.append(open);
            iterator = fields.iterator();
            // 遍历对象中的每个属性
            while (iterator.hasNext()) {
                String field = iterator.next();
                try {
                    Method method = t.getClass().getMethod(field);
                    try {
                        Object invoke = method.invoke(t);
                        if (invoke != null && (invoke instanceof Date)){// 数据库中使用dateTime类型
                            Date date = (Date) invoke;
                            invoke = "'" + new Timestamp(date.getTime()) + "'";
                        }else if (invoke != null && invoke instanceof String) {
                            String s = invoke.toString();
                            invoke = "'" + s.replace("'", "\\'") + "'";
                        }
                        sql.append(invoke == null ? "null" : invoke);
                        if (iterator.hasNext()) {
                            sql.append(conjunction);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
            sql.append(close);
            if (iterator1.hasNext()) {
                sql.append(conjunction);
            }
        }
        return sql.toString();
    }
}
