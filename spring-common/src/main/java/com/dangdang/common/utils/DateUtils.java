package com.dangdang.common.utils;

import com.dangdang.common.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 */
@Slf4j
public class DateUtils {

    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.sss";

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String YYYY_MM = "yyyy-MM";

    public static final String YYYY_WW = "yyyy-ww";

    public static final String HH_MM_SS = "HH:mm:ss";

    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    private static final long ONE_DAY_MILLISECOND = 24 * 60 * 60 * 1000;

    public static void main(String[] args) {
        System.out.println(DateUtils.parseDate("2000-01-01 00:00:00",DateUtils.YYYY_MM_DD_HH_MM_SS).getTime());
    }

    /**
     * 格式化时间为yyyy-MM-dd HH:mm:ss
     *
     * @param date 日期
     * @return 时间字符串
     */
    public static String formatDate(Date date) {

        String returnValue = null;
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
            returnValue = df.format(date);
        }
        return returnValue;
    }

    /**
     * 格式化时间为fmt形式
     *
     * @param date 日期
     * @param fmt  转换格式
     * @return 时间字符串
     */
    public static String formatDate(Date date, String fmt) {
        if (StringUtils.isBlank(fmt)) {
            fmt = YYYY_MM_DD_HH_MM_SS;
        }
        String returnValue = null;
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(fmt);
            returnValue = df.format(date);
        }
        return returnValue;
    }

    /**
     * 解析形式为fmt的时间
     *
     * @param date 日期
     * @param fmt  转换格式
     * @return
     */
    public static Date parseDate(String date, String fmt) {
        try {
            return new SimpleDateFormat(fmt).parse(date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期1是否在日期2之前(只比较日期)
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean beforeDate(Date date1, Date date2) {
        return before(date1, date2, YYYY_MM_DD);
    }

    /**
     * 日期1是否在日期2之前
     *
     * @param date1 比较日期1
     * @param date2 比较日期2
     * @param fmt   日期格式
     * @return
     */
    public static boolean before(Date date1, Date date2, String fmt) {
        date1 = truncateDate(date1, fmt);
        date2 = truncateDate(date2, fmt);
        return date1.before(date2);
    }

    /**
     * 截取日期，失败抛出异常
     *
     * @param date
     * @param fmt  日期格式
     * @return
     */
    public static Date truncateDate(Date date, String fmt) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(fmt);
            return sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 返回两个日期相差的天数,有一个时间为null返回-1
     *
     * @param d1 长的时间
     * @param d2 短的时间
     * @return int
     */
    public static long diffInMills(Date d1, Date d2) {

        if (null == d1 || null == d2) {
            return -1;
        }
        return d1.getTime() - d2.getTime();
    }

    /**
     * 返回两个日期相差的天数,有一个时间为null返回-1
     *
     * @param d1 长的时间
     * @param d2 短的时间
     * @return int
     */
    public static long diffInSeconds(Date d1, Date d2) {

        if (null == d1 || null == d2) {
            return -1;
        }
        return (d1.getTime() - d2.getTime()) / 1000;
    }

    /**
     * 返回两个日期相差的天数,有一个时间为null返回-1
     *
     * @param d1 长的时间
     * @param d2 短的时间
     * @return int
     */
    public static int diffInDay(Date d1, Date d2) {

        if (null == d1 || null == d2) {
            return -1;
        }
        return (int) ((d1.getTime() - d2.getTime()) / ONE_DAY_MILLISECOND);
    }

    /**
     * 返回两个日期相差的月份,有一个时间为null返回-1 结果为自然月差距,不是绝对的时间差值
     *
     * @param d1 短的时间
     * @param d2 长的时间
     * @return int
     */
    public static int diffInMonth(Date d1, Date d2) {
        if (null == d1 || null == d2) {
            return -1;
        }

        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);
        int c1year = c1.get(Calendar.YEAR);
        int c1month = c1.get(Calendar.MONTH);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);
        int c2year = c2.get(Calendar.YEAR);
        int c2month = c2.get(Calendar.MONTH);
        return (c2year - c1year) * 12 + (c2month - c1month);
    }

    /**
     * 返回两个日期相差的周,有一个时间为null返回-1 结果为自然周差距,不是绝对的时间差值
     *
     * @param d1 短的时间
     * @param d2 长的时间
     * @return int
     */
    public static int diffInWeek(Date d1, Date d2) {
        if (null == d1 || null == d2) {
            return -1;
        }

        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);
        int c1year = c1.get(Calendar.YEAR);
        int c1week = c1.get(Calendar.WEEK_OF_YEAR);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);
        int c2year = c2.get(Calendar.YEAR);
        int c2week = c2.get(Calendar.WEEK_OF_YEAR);
        return (c2year - c1year) * 52 + (c2week - c1week);
    }

    /**
     * 给日期加天数
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return c.getTime();
    }

    /**
     * 给日期加月份
     *
     * @param date
     * @param months
     * @return
     */
    public static Date addMonths(Date date, int months) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, months);
        return c.getTime();
    }

    /**
     * 给日期加周
     *
     * @param date
     * @param weeks
     * @return
     */
    public static Date addWeeks(Date date, int weeks) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.WEEK_OF_YEAR, weeks);
        return c.getTime();
    }

    /**
     * 获取指定日期之前指定天,包含传入的那一天
     *
     * @param date 指定的日期
     * @param days 指定的天数
     * @return
     */
    public static String getDaysBefore(Date date, int days) {
        Date td = addDays(date, -days);
        return formatDate(td, YYYY_MM_DD);
    }

    /**
     * 获取指定日期之前指定天,包含传入的那一天
     *
     * @param dateStr 指定的日期的字符串格式
     * @param days    指定的天数
     * @return
     */
    public static String getDaysBefore(String dateStr, int days) {
        Date date = parseDate(dateStr, YYYY_MM_DD);
        return getDaysBefore(date, days);
    }

    /**
     * 获取指定日期之后指定天,包含传入的那一天
     *
     * @param date 指定的日期
     * @param days 指定的天数
     * @return
     */
    public static String getDaysAfter(Date date, int days) {
        Date td = addDays(date, days);
        return formatDate(td, YYYY_MM_DD);
    }

    /**
     * 获取指定日期之后指定天,包含传入的那一天
     *
     * @param dateStr 指定的日期的字符串格式
     * @param days    指定的天数
     * @return
     */
    public static String getDaysAfter(String dateStr, int days) {
        Date date = parseDate(dateStr, YYYY_MM_DD);
        return getDaysAfter(date, days);
    }

    /**
     * 获取指定日期之前指定月
     *
     * @param date
     * @param months
     * @return
     */
    public static String getMonthsBefore(Date date, int months) {
        Date td = addMonths(date, -months);
        return formatDate(td, YYYY_MM);
    }

    /**
     * 获取指定日期之前指定月
     *
     * @param dateStr
     * @param months
     * @return
     */
    public static String getMonthsBefore(String dateStr, int months) {
        Date date = parseDate(dateStr, YYYY_MM_DD);
        return getMonthsBefore(date, months);
    }

    /**
     * 获取指定日期之前指定周
     *
     * @param date
     * @param weeks
     * @return
     */
    public static String getWeeksBefore(Date date, int weeks) {
        Date td = addWeeks(date, -weeks);
        return formatDate(td, YYYY_WW);
    }

    /**
     * 获取指定日期之前指定周
     *
     * @param dateStr
     * @param weeks
     * @return
     */
    public static String getWeeksBefore(String dateStr, int weeks) {
        Date date = parseDate(dateStr, YYYY_MM_DD);
        return getWeeksBefore(date, weeks);
    }

    /**
     * 获取当前时间-精确到毫秒
     *
     * @return
     */
    public static Long getCurrentTimeMillSecond() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当前时间-精确到秒
     *
     * @return
     */
    public static Long getCurrentTimeSecond() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 获取时间-精确到秒
     *
     * @return
     */
    public static Integer getDateSecond(Date date) {
        return Math.toIntExact(date.getTime() / 1000);
    }

    /**
     * 获取当前本周周一时间
     *
     * @return
     * @throws ParseException
     */
    public static String getMondayOfThisWeek() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek == 0) {
            dayOfWeek = 7;
        }
        calendar.add(Calendar.DATE, -dayOfWeek + 1);

        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        String day = sdf.format(calendar.getTime());
        return day;
    }

    /**
     * 获取指定时间所在周周一时间
     *
     * @param today
     * @return
     * @throws ParseException
     */
    public static String getMondayOfThisWeek(String today) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        Date date = sdf.parse(today);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek == 0) {
            dayOfWeek = 7;
        }
        calendar.add(Calendar.DATE, -dayOfWeek + 1);
        String day = sdf.format(calendar.getTime());
        return day;
    }

    /**
     * 获取当前本周周日时间
     *
     * @return
     * @throws ParseException
     */
    public static String getSundayOfThisWeek() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek == 0) {
            dayOfWeek = 7;
        }
        calendar.add(Calendar.DATE, -dayOfWeek + 7);

        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        String day = sdf.format(calendar.getTime());
        return day;
    }

    /**
     * 获取本月第一天
     *
     * @return
     * @throws ParseException
     */
    public static String getFirstDayOfThisMonth() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天

        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        String day = sdf.format(calendar.getTime());
        return day;
    }

    /**
     * 获得本月最后一天
     *
     * @return
     * @throws ParseException
     */
    public static String getLastDayOfThisMonth() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        String day = sdf.format(calendar.getTime());
        return day;
    }

    /**
     * 获取指定月份的起始时间戳
     *
     * @param yearStr
     * @param monthStr
     * @return
     */
    public static long getStartSecondOfTargetMonth(String yearStr, String monthStr) {
        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return getDateStartTimeSecond(cal.getTime());
    }

    /**
     * 获取指定月份的终止时间戳
     *
     * @param yearStr
     * @param monthStr
     * @return
     */
    public static long getEndSecondOfTargetMonth(String yearStr, String monthStr) {
        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, -1);
        return getDateEndTimeSecond(cal.getTime());
    }

    /**
     * 今天 00:00:00 的时间-秒
     *
     * @return
     */
    public static long getTodayBeginTimesSecond() {
        long time = DateUtils.parseDate(DateUtils.formatDate(new Date(), YYYY_MM_DD), YYYY_MM_DD).getTime() / 1000;
        return time;
    }

    /**
     * 今天 23:59:59 的时间-秒
     *
     * @return
     */
    public static long getTodayEndTimesSecond() {
        long time = addDays(DateUtils.parseDate(DateUtils.formatDate(new Date(), YYYY_MM_DD), YYYY_MM_DD), 1).getTime();
        return (time / 1000) - 1;
    }

    /**
     * 今天 00:00:00 的时间-毫秒
     *
     * @return
     */
    public static long getTodayBeginTimesMillSecond() {
        long time = DateUtils.parseDate(DateUtils.formatDate(new Date(), YYYY_MM_DD), YYYY_MM_DD).getTime();
        return time;
    }

    /**
     * 今天 23:59:59:999 的时间-毫秒
     *
     * @return
     */
    public static long getTodayEndTimesMillSecond() {
        long time = addDays(DateUtils.parseDate(DateUtils.formatDate(new Date(), YYYY_MM_DD), YYYY_MM_DD), 1).getTime();
        return time - 1;
    }

    /**
     * 指定日期当前 00:00:00 的时间-秒
     *
     * @param date
     * @return
     */
    public static long getDateStartTimeSecond(Date date) {
        long time = DateUtils.parseDate(DateUtils.formatDate(date, YYYY_MM_DD), YYYY_MM_DD).getTime();
        return time / 1000;
    }

    /**
     * 指定日期当前 23:59:59 的时间-秒
     *
     * @param date
     * @return
     */
    public static long getDateEndTimeSecond(Date date) {
        long time = addDays(DateUtils.parseDate(DateUtils.formatDate(date, YYYY_MM_DD), YYYY_MM_DD), 1).getTime();
        return (time / 1000) - 1;
    }


    /**
     * 指定日期当前 00:00:00 的时间-毫秒
     *
     * @param date
     * @return
     */
    public static long getDateStartTimeMillSecond(Date date) {
        long time = DateUtils.parseDate(DateUtils.formatDate(date, YYYY_MM_DD), YYYY_MM_DD).getTime();
        return time;
    }

    /**
     * 指定日期当前 23:59:59:999 的时间-毫秒
     *
     * @param date
     * @return
     */
    public static long getDateEndTimeMillSecond(Date date) {
        long time = addDays(DateUtils.parseDate(DateUtils.formatDate(date, YYYY_MM_DD), YYYY_MM_DD), 1).getTime();
        return time - 1;
    }

    /**
     * 获取某天是周几 0:周日
     *
     * @param date
     * @return
     */
    public static int getDayOFWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        return i - 1;
    }

    /**
     * * 获取指定日期是星期几 参数为null时表示获取当前日期是星期几
     *
     * @param date
     * @return
     */
    public static String getWeekOfDate(Date date) {
        String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekOfDays[w];
    }

    /**
     * 计算用户的年龄 粗略计算
     */
    public static String getAge(Long birthDay) throws BaseException {
        Date date = new Date(birthDay);
        //获取当前系统时间
        Calendar cal = Calendar.getInstance();
        //如果出生日期大于当前时间，则抛出异常
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
        }
        //取出系统当前时间的年、月、日部分
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        //将日期设置为出生日期
        cal.setTime(date);
        //取出出生日期的年、月、日部分
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        //当前年份与出生年份相减，初步计算年龄
        int age = yearNow - yearBirth;
        int month = monthNow - monthBirth;
        if (month == 0) {
            if (dayOfMonthNow < dayOfMonthBirth) {
                month--;
            }
        }
        //当前月份与出生日期的月份相比，如果月份小于出生月份，则年龄上减1，表示不满多少周岁
        if (month < 0) {
            //如果月份相等，在比较日期，如果当前日，小于出生日，也减1，表示不满多少周岁
            age--;
            month += 12;
        }

        return age + "周岁" + month + "个月";
    }

}
