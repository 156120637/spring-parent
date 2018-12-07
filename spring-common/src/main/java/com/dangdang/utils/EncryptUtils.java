package com.dangdang.utils;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;

/**
 * 加密工具类
 */
public class EncryptUtils {

    private static final String MD5 = "MD5";

    private static final String CHARSET = "UTF-8";

    /**
     * MD5加密方法
     *
     * @param text 明文
     * @param key  密钥
     * @return 密文
     * @throws Exception
     */
    public static String encryptMD5(String text, String key) throws Exception {

        if (StringUtils.isNotBlank(key)) {
            text = text + key;
        }
        byte[] bytes = text.getBytes(CHARSET);

        MessageDigest messageDigest = MessageDigest.getInstance(MD5);
        messageDigest.update(bytes);
        bytes = messageDigest.digest();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if ((bytes[i] & 0xff) < 0x10) {
                sb.append("0");
            }

            sb.append(Long.toString(bytes[i] & 0xff, 16));
        }

        return sb.toString().toLowerCase();
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param key  密钥
     * @param md5  密文
     * @return true/false
     * @throws Exception
     */
    public static boolean verifyMd5(String text, String key, String md5) throws Exception {
        String md5Text = encryptMD5(text, key);
        if (md5Text.equalsIgnoreCase(md5)) {
            return true;
        } else {
            return false;
        }
    }

}
