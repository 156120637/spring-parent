package com.dangdang.common.utils.sql;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.*;

/**
 * 拼接批量更新语句工具类
 * 只支持javaBean, 不支持其他任何java类, 否则报错
 */
public class BatchUpdateSQLBuilder<T> {

    /**
     * 表名
     */
    private String tableName;

    /**
     * 主键名称
     */
    private String primaryKey;

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

    private Set primaryValueList= new HashSet();

    /**
     * 最终拼接的SQL语句
     */
    private StringBuffer sql = new StringBuffer();

    private static final String OPEN = " (";

    private static final String CLOSE = ") ";

    private static final String CONJUNCTION = ", ";

    private static final String SET = " SET ";

    private static final String EQUAL = " = ";

    private static final String WHEN = " WHEN ";

    private static final String CASE = " CASE ";

    private static final String THEN = " THEN ";

    private static final String END = " END ";

    private static final String WHERE = " WHERE ";

    private static final String IN = " IN ";

    /**
     * 设置表名
     */
    public BatchUpdateSQLBuilder setUpdateTable(String tableName, String primaryKey) {

        Assert.notNull(tableName, "update table name is empty");
        Assert.notNull(primaryKey, "primaryKey is empty");
        this.tableName = tableName;
        this.primaryKey = primaryKey;
        return this;
    }

    /**
     * 设置是否为全量更新
     *
     * @param selective
     * @return
     */
    public BatchUpdateSQLBuilder setSelective(boolean selective) {

        this.selective = selective;
        return this;
    }

    /**
     * 插入数据
     * @param obj
     * @return
     */
    @SuppressWarnings("all")
    public BatchUpdateSQLBuilder setData(T obj) {

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
        sql.append("UPDATE ").append(tableName).append(SET);

        Iterator<String> it = fields.iterator();
        while (it.hasNext()) {
            String field = it.next();
            sql.append(SQLUtils.humpToUnderline(getBeanFieldName(field))).append(EQUAL);
            sql.append(CASE).append(primaryKey);
            Iterator<T> iterator = dataList.iterator();
            while (iterator.hasNext()) {
                sql.append(WHEN);
                T next = iterator.next();
                Class<?> clazz = next.getClass();
                try {
                    Field primary = clazz.getDeclaredField(SQLUtils.underlineTohump(primaryKey));
                    primary.setAccessible(true);
                    try {
                        Object value = primary.get(next);
                        if(value != null && value instanceof String){
                            String s = value.toString();
                            value = s.replace("'","\\'");
                        }
                        Assert.notNull(value, "primary key value is null");
                        primaryValueList.add(value);
                        try {
                            Method method = clazz.getMethod(field);
                            Object invoke = method.invoke(next);
                            if (invoke != null && (invoke instanceof Date)){// 数据库中使用dateTime类型
                                Date date = (Date) invoke;
                                invoke = "'" + new Timestamp(date.getTime()) + "'";
                            }else if (invoke != null && invoke instanceof String) {
                                String s = invoke.toString();
                                invoke = "'" + s.replace("'", "\\'") + "'";
                            }

                            sql.append("'").append(value).append("'").append(THEN).append(invoke == null ? "null" : invoke);
                            sql.append("");
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
            sql.append(END);
            if (it.hasNext()) {
                sql.append(CONJUNCTION);
            }
        }

        sql.append(WHERE).append(primaryKey).append(IN).append(OPEN);
        Iterator iterator = primaryValueList.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            sql.append("'").append(next).append("'");
            if (iterator.hasNext()) {
                sql.append(CONJUNCTION);
            }
        }
        sql.append(CLOSE);

        return sql.toString();
    }
}
