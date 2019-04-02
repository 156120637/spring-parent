package com.dangdang.common.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class EncryptUtils {

    public static byte[] encrypt(String strKey, String strIn) throws Exception {
        SecretKeySpec skeySpec = getKey(strKey);
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        String ivs = "F0E1D2C3B4A5968778695A4B3C2D1E0F";
        byte[] ivb = hexStr2Bytes(ivs);
        IvParameterSpec iv = new IvParameterSpec(ivb);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] strInBytes = strIn.getBytes();
        int size = (strInBytes.length + 15) / 16 * 16;
        byte[] newIn = new byte[size];
        for (int i = 0; i < size; i++) {
            if (i < strInBytes.length)
                newIn[i] = strInBytes[i];
            else
                newIn[i] = 0;
        }
        return cipher.doFinal(newIn);
    }

    public static byte[] decrypt(String strKey, String strIn) throws Exception {
        byte[] strInBytes = parseStr(strIn);
        SecretKeySpec skeySpec = getKey(strKey);
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        String ivs = "F0E1D2C3B4A5968778695A4B3C2D1E0F";
        byte[] ivb = hexStr2Bytes(ivs);
        IvParameterSpec iv = new IvParameterSpec(ivb);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(strInBytes);
        int alen = encrypted.length;
        System.out.println("encrypted len:" + alen);
        for (int i = 0; i < encrypted.length; i++) {
            if (encrypted[i] == 0) {
                alen = i;
                System.out.println("catch 0, stop copy:" + (encrypted.length - i));
                break;
            }
        }
        if (alen == encrypted.length) {
            return encrypted;
        }
        System.out.println("reqdata len:" + alen);
        return Arrays.copyOf(encrypted, alen);
    }

    public static String getStr(byte[] md) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int j = md.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }

    public static byte[] parseStr(String hexString) {
        String hex = "0123456789ABCDEF";
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (hex.indexOf((hexChars[pos])) << 4 | hex.indexOf((hexChars[pos + 1])));
        }
        return d;
    }

    private static byte uniteBytes(String src0, String src1) {
        byte b0 = Byte.decode("0x" + src0).byteValue();
        b0 = (byte) (b0 << 4);
        byte b1 = Byte.decode("0x" + src1).byteValue();
        byte ret = (byte) (b0 | b1);
        return ret;
    }

    /**
     * bytes转换成十六进制字符串
     */
    public static byte[] hexStr2Bytes(String src) {
        int m = 0, n = 0;
        int l = src.length() / 2;
        byte[] ret = new byte[l];
        for (int i = 0; i < l; i++) {
            m = i * 2 + 1;
            n = m + 1;
            ret[i] = uniteBytes(src.substring(i * 2, m), src.substring(m, n));
        }
        return ret;
    }

    private static SecretKeySpec getKey(String strKey) throws Exception {
        byte[] arrBTmp = strKey.getBytes();
        byte[] arrB = new byte[16]; // 创建一个空的16位字节数组（默认值为0）

        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }

        SecretKeySpec skeySpec = new SecretKeySpec(arrB, "AES");

        return skeySpec;
    }

}
