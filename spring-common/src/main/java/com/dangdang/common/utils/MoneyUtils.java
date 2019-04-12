package com.dangdang.common.utils;

import com.dangdang.common.exception.BaseException;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Create by tianjiaqin 2018/11/12
 */
public class MoneyUtils {

    /**
     * 金额为分的格式
     */
    public static final String CURRENCY_FEN_REGEX = "-?[0-9]+";

    public static void main(String[] args) throws Exception {
        System.out.println(changeF2Y(123456789L, false));
        System.out.println(changeY2F("1234567.89"));
    }

    /**
     * 将分为单位的转换为元，并返回金额格式(3位有逗号)的字符串 （除100）
     *
     * @param amount  金额
     * @param isComma 转化后，是否添加逗号 true-添加；false-不添加
     * @return
     * @throws Exception
     */
    public static String changeF2Y(Long amount, boolean isComma) throws BaseException {
        if (Objects.isNull(amount)) {
            return null;
        }
        if (!amount.toString().matches(CURRENCY_FEN_REGEX)) {
            throw new BaseException(9001, "金额格式有误");
        }

        int flag = 0;
        String amString = amount.toString();
        if (amString.charAt(0) == '-') {
            flag = 1;
            amString = amString.substring(1);
        }
        StringBuffer result = new StringBuffer();
        if (amString.length() == 1) {
            result.append("0.0").append(amString);
        } else if (amString.length() == 2) {
            result.append("0.").append(amString);
        } else {
            String intString = amString.substring(0, amString.length() - 2);
            // 是否添加逗号
            if (isComma) {
                for (int i = 1; i <= intString.length(); i++) {
                    if ((i - 1) % 3 == 0 && i != 1) {
                        result.append(",");
                    }
                    result.append(intString.substring(intString.length() - i, intString.length() - i + 1));
                }
                result.reverse().append(".").append(amString.substring(amString.length() - 2));
            } else {
                result.append(intString).append(".").append(amString.substring(amString.length() - 2));
            }
        }
        if (flag == 1) {
            return "-" + result.toString();
        } else {
            return result.toString();
        }
    }

    /**
     * 将分为单位的转换为元 （除100）
     *
     * @param amount
     * @return
     * @throws Exception
     */
    public static String changeF2Y(String amount) throws Exception {
        if (!amount.matches(CURRENCY_FEN_REGEX)) {
            throw new BaseException(9001, "金额格式有误");
        }
        return BigDecimal.valueOf(Long.valueOf(amount)).divide(new BigDecimal(100)).toString();
    }

    /**
     * 将元为单位的转换为分 （乘100）
     *
     * @param amount
     * @return
     */
    public static String changeY2F(Long amount) {
        return BigDecimal.valueOf(amount).multiply(new BigDecimal(100)).toString();
    }

    /**
     * 将元为单位的转换为分 替换小数点，支持以逗号区分的金额
     *
     * @param amount
     * @return
     */
    public static String changeY2F(String amount) {
        String currency = amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额
        int index = currency.indexOf(".");
        int length = currency.length();
        Long amLong = 0L;
        if (index == -1) {
            amLong = Long.valueOf(currency + "00");
        } else if (length - index >= 3) {
            amLong = Long.valueOf((currency.substring(0, index + 3)).replace(".", ""));
        } else if (length - index == 2) {
            amLong = Long.valueOf((currency.substring(0, index + 2)).replace(".", "") + 0);
        } else {
            amLong = Long.valueOf((currency.substring(0, index + 1)).replace(".", "") + "00");
        }
        return amLong.toString();
    }

}