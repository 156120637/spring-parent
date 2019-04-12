package com.dangdang.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by tianjiaqin 2018/11/12
 */
public class StringToolUtils {
    private static final String reZh = "[\\u4e00-\\u9fa5]+";
    private static final String reEn = "[a-zA-Z]+";
    private static final String reNotDigital = "[^0-9]";
    private static final String reWhitespace = "\\s+";
    private static final String rePunctuation = "[\\pP\\p{Punct}]";
    private static final String reMobile = "1\\d{10}";
    private static final String reTel = "(?:(?:0[1-9][0-9]{1,2}|85[23])-?)?\\d{7,8}";
    public static Pattern reMobileFullMatch = Pattern.compile("^1\\d{10}$");
    public static String[] numSc = new String[]{"一", "二", "三", "四", "五", "六", "七", "八", "九", "零", "十",
            "百", "千", "万", "亿"};
    public static Pattern reNumSc = Pattern.compile("([一|二|三|四|五|六|七|八|九|零|十|百|千|万|亿]+)");
    private static final Map<String, String> mapC2d = new HashMap<String, String>() {{
        put("o", "0");
        put("O", "0");
        put("i", "1");
        put("I", "1");
        put("z", "2");
        put("Z", "2");
        put("b", "6");
        put("B", "8");
        put("g", "9");
    }};
    private static final Map<String, String> mapWd2d = new HashMap<String, String>() {{
        put("１", "1");
        put("２", "2");
        put("３", "3");
        put("４", "4");
        put("５", "5");
        put("６", "6");
        put("７", "7");
        put("８", "8");
        put("９", "9");
        put("０", "0");
    }};
    private static final Map<String, String> mapTcc2scc = new HashMap<String, String>() {{
        put("陸", "陆");
        put("貳", "贰");
        put("萬", "万");
        put("億", "亿");
    }};
    private static final Map<String, String> mapScc2sc = new HashMap<String, String>() {{
        put("陆", "六");
        put("肆", "四");
        put("伍", "五");
        put("捌", "八");
        put("贰", "二");
        put("柒", "七");
        put("佰", "百");
        put("玖", "九");
        put("壹", "一");
        put("仟", "千");
        put("拾", "十");
    }};

    private static final Map<String, Integer> mapSc2d = new HashMap<String, Integer>() {{
        put("十", 10);
        put("一", 1);
        put("七", 7);
        put("万", 10000);
        put("千", 1000);
        put("三", 3);
        put("八", 8);
        put("六", 6);
        put("二", 2);
        put("五", 5);
        put("零", 0);
        put("四", 4);
        put("九", 9);
        put("亿", 100000000);
        put("百", 100);
    }};


    public static List<String> findZh(String targetStr) {
        List<String> zhs = new ArrayList<>();
        Pattern re = Pattern.compile(reZh);
        Matcher ma = re.matcher(targetStr);
        while (ma.find()) {
            zhs.add(ma.group().toString());
        }
        return zhs;
    }

    //TODO
    public static List<String> findEn(String targetStr) {
        List<String> ens = new ArrayList<>();
        Pattern re = Pattern.compile(reEn);
        Matcher ma = re.matcher(targetStr);
        while (ma.find()) {
            ens.add(ma.group().toString());
        }
        return ens;
    }

    public static String extractZhStr(String targetStr) {
        String str = "";
        for (String str_ : findZh(targetStr)) {
            str += str_;
        }
        return str;
    }

    public static String extractEnStr(String targetStr) {
        StringBuffer str = new StringBuffer();
        for (String str_ : findEn(targetStr)) {
            str.append(str_);
        }
        return str.toString();
    }

    public static String extractDigitalStr(String targetStr) {
        Pattern p = Pattern.compile(reNotDigital);
        Matcher m = p.matcher(targetStr);
        return m.replaceAll("").trim();
    }

    public static String replacePunctuation(String replStr, String targetStr) {
        return targetStr.replaceAll(rePunctuation, replStr);
    }

    public static String replaceWhitespace(String replStr, String targetStr) {
        return targetStr.replaceAll(reWhitespace, replStr);
    }


    public static List<String> findMobile(String targetStr) {
        List<String> mobiles = new ArrayList<>();
        Pattern pattern = Pattern.compile(reMobile);
        Matcher ma = pattern.matcher(targetStr);
        while (ma.find()) {
            mobiles.add(ma.group().toString());
        }
        return mobiles;
    }

    public static List<String> findTelephone(String targetStr) {
        List<String> mobiles = new ArrayList<>();
        Pattern pattern = Pattern.compile(reTel);
        Matcher ma = pattern.matcher(targetStr);
        while (ma.find()) {
            mobiles.add(ma.group().toString());
        }
        return mobiles;
    }

    public static String replaceNumWd2d(String targetStr) {
        return replaceByMap(targetStr, mapWd2d);
    }


    public static String replaceNumC2d(String targetStr) {
        return replaceByMap(targetStr, mapC2d);
    }

    public static String replaceByMap(String targetStr, Map<String, String> numMap) {
        for (Map.Entry<String, String> entry : numMap.entrySet()) {
            targetStr = targetStr.replace(entry.getKey(), entry.getValue());
        }
        return targetStr;
    }

    public static String convertNum2Sc2d(String numStr) {
        if (StringUtils.isBlank(numStr)) {
            return "";
        }
        for (int i = 8; i >= 0; i -= 1) {
            if (numStr.contains(numSc[i])) {
                String[] numStrs = numStr.split(numSc[i], 0);
                if (numStrs.length == 0) {
                    continue;
                }
                String left = numStrs[0];
                String leftRes = convertNum2Sc2d(left);
                if (leftRes.equals("")) {
                    leftRes = "1";
                }
                String midRes = mapSc2d.get(numSc[i]) + "";
                if (midRes.equals("")) {
                    midRes = "0";
                }
                String rightRes = "0";
                if (numStrs.length > 1) {
                    String right = numStrs[1];
                    rightRes = convertNum2Sc2d(right);
                    if (rightRes.equals("")) {
                        rightRes = "0";
                    }
                }
                return Integer.parseInt(leftRes) * Integer.parseInt(midRes) + Integer.parseInt(rightRes) + "";
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numStr.length(); i++) {
            sb.append(mapSc2d.get(numStr.subSequence(i, i + 1)));
        }
        return sb.toString();
    }

    public static String replaceNumSc2d(String targetStr) {
        Matcher ma = reNumSc.matcher(targetStr);
        if (ma.find()) {
            return convertNum2Sc2d(ma.group(1));
        }
        return "";
    }

    public static String replaceNumScc2sc(String target) {
        return replaceByMap(target, mapTcc2scc);
    }

    public static String replaceNumTcc2scc(String targetStr) {
        return replaceByMap(targetStr, mapTcc2scc);
    }

    /**
     * Extract all mobiles in string.
     *
     * @param targetStr
     * @return
     */
    public static List<String> extractMobile(String targetStr) {
        List<String> res = null;
        String tStr = replaceWhitespace("", targetStr);
        tStr = replacePunctuation("", tStr);
        String tStr1 = null;
        String tStr2 = null;
        if (StringUtils.isNotBlank(tStr)) {
            res = findMobile(tStr);
        }
        if (CollectionUtils.isEmpty(res)) {
            tStr1 = replaceNumWd2d(tStr);
            res = findMobile(tStr1);
        }
        if (CollectionUtils.isEmpty(res)) {
            tStr2 = replaceNumC2d(tStr1);
            res = findMobile(tStr2);
        }
        if (CollectionUtils.isEmpty(res)) {
            String tStr3 = replaceNumTcc2scc(tStr2);
            tStr3 = replaceNumScc2sc(tStr3);
            tStr3 = replaceNumSc2d(tStr3);  // 可能有错误
            res = findMobile(tStr3);
        }
        return res;
    }

    public static List<String> extraceTelephone(String targetStr) {
        List<String> res = null;
        String tStr = replaceWhitespace("", targetStr);
        tStr = replacePunctuation("", tStr);
        String tStr1 = null;
        String tStr2 = null;
        if (StringUtils.isNotBlank(tStr)) {
            res = findTelephone(tStr);
        }
        if (CollectionUtils.isEmpty(res)) {
            tStr1 = replaceNumWd2d(tStr);
            res = findTelephone(tStr1);
        }
        if (CollectionUtils.isEmpty(res)) {
            tStr2 = replaceNumC2d(tStr1);
            res = findTelephone(tStr2);
        }
        if (CollectionUtils.isEmpty(res)) {
            String tStr3 = replaceNumTcc2scc(tStr2);
            tStr3 = replaceNumScc2sc(tStr3);
            tStr3 = replaceNumSc2d(tStr3);  // 可能有错误
            res = findTelephone(tStr3);
        }
        return res;
    }

    public static void main(String[] args) {
        // System.out.println(replacePunctuation("", "1301105#(^*%*%%)^%$&$$&^%&!~!{}:|4648"));
        // Set<String> test = new HashSet<>();
        // test.add(null);
        // test.add(null);
        // System.out.println(test.size());
        // System.out.println(replaceWhitespace("", "lsdjfdsajfl;dajf323   234  23423   "));
        // System.out.println(findMobile("dd13011067842ss13011067842"));
        // Matcher ma = reMobileFullMatch.matcher("dsfaf13011067842");
        // while (ma.find()) {
        //     System.out.println(ma.group().toString());
        // }
        // System.out.println(StringToolUtils.replacePunctuation("", "010-45454"));

//        List<String> test = Arrays.asList("yang", "peng", "js");
//        System.out.println(test.stream().collect(joining("|")));

        String list = replaceNumSc2d("在家了我是一二个样的人在我");
        System.out.println(JSONObject.toJSONString(list));
    }
}
