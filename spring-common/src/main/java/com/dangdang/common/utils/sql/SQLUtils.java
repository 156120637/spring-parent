package com.dangdang.common.utils.sql;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * SQl语句工具类
 */
public class SQLUtils {

    /**
     * 给手写sql自动加上别名(别名:把下划线风格转成驼峰)
     *
     * @param sqlColumns
     * @return
     */
    public static String addColumnAlias(String sqlColumns) {

        if (StringUtils.isEmpty(sqlColumns)) {
            return "";
        }
        String[] columns = sqlColumns.split(",");
        StringBuffer sql = new StringBuffer();

        for (int i = 0, length = columns.length; i < length; i++) {
            String column = columns[i];
            sql.append(column);
            if (column.indexOf("*") < 0) {//这里的目的是屏蔽掉不能产生别名的情况,比如a.*
                //取别名的时候,去掉前缀(a.store_id中的a.)
                String columnName = column.replaceAll(".*\\.", "");
                String alias = underlineTohump(columnName);
                sql.append(" ").append(alias);
            }

            if (i < length - 1) {
                sql.append(",");
            }
        }

        return sql.toString();
    }

    /**
     * 下划线转驼峰
     *
     * @return
     */
    public static String underlineTohump(String underlineString) {

        if (StringUtils.isEmpty(underlineString)) return "";
        String prefix = "";
        if (underlineString.charAt(0) == '_') {
            underlineString = underlineString.substring(1, underlineString.length());
            prefix = "_";
        }
        String regexStr = "_[0-9a-z]";
        Matcher matcher = Pattern.compile(regexStr).matcher(underlineString);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String g = matcher.group();
            g = String.valueOf(g.charAt(1));
            matcher.appendReplacement(sb, g.toUpperCase());
        }

        matcher.appendTail(sb);
        sb.insert(0, prefix);
        return sb.toString();
    }

    /**
     * 驼峰转下划线
     *
     * @param humpString created by hbd 20160722
     * @return
     */
    public static String humpToUnderline(String humpString) {

        if (StringUtils.isEmpty(humpString)) return "";
        String prefix = "";
        if (humpString.charAt(0) == '_') {
            humpString = humpString.substring(1, humpString.length());
            prefix = "_";
        }
        String regexStr = "[A-Z]";
        Matcher matcher = Pattern.compile(regexStr).matcher(humpString);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String g = matcher.group();
            matcher.appendReplacement(sb, "_" + g.toLowerCase());
        }
        matcher.appendTail(sb);
        if (sb.charAt(0) == '_') {
            sb.delete(0, 1);
        }
        sb.insert(0, prefix);
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(underlineTohump("jd_province_id"));
        System.out.println(underlineTohump("_afdsu_aoifudi"));
        System.out.println(underlineTohump("afdsu_aoi_fudi"));
        System.out.println(humpToUnderline(underlineTohump("_afdsuaoifudi")));
        System.out.println(humpToUnderline(underlineTohump("_afdsu_aoifudi")));
        System.out.println(humpToUnderline(underlineTohump("afdsu_aoi_fudi")));
        String src = "b.*_abd, user_id,store_id,store_name,owner_name,"
                + "telephone,region_name,type,status,create_time ";
        System.out.println(addColumnAlias(src));
        System.out.println(src.indexOf(".*") > 0);
    }
}
