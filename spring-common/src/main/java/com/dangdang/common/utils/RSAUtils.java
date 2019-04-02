package com.dangdang.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * RSA公钥/私钥/签名工具包
 * </p>
 * <p>
 * 罗纳德·李维斯特（Ron [R]ivest）、阿迪·萨莫尔（Adi [S]hamir）和伦纳德·阿德曼（Leonard [A]dleman）
 * </p>
 * <p>
 * 字符串格式的密钥在未在特殊说明情况下都为BASE64编码格式<br/>
 * 由于非对称加密速度极其缓慢，一般文件不使用它来加密而是使用对称加密，<br/>
 * 非对称加密算法可以用来对对称加密的密钥加密，这样保证密钥的安全也就保证了数据的安全
 *
 * 说明：私钥加密、公钥解密，每次加密结果相同
 *      公钥加密、私钥解密，每次加密结果不同
 * </p>
 */
@Slf4j
public class RSAUtils {

    /**
     * 加密算法RSA
     */
    private static final String RSA_KEY_ALGORITHM = "RSA";

    /**
     * 签名算法
     */
    private static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    /**
     * 获取公钥的key
     */
    private static final String PUBLIC_KEY = "RSAPublicKey";

    /**
     * 获取私钥的key
     */
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    /**
     * RSA密钥长度
     */
    private static final int KEY_SIZE = 1024;

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * 生成密钥对(公钥和私钥)
     * @return RSA密钥对
     * @throws Exception 抛出异常
     */
    public static Map<String, Object> genKeyPair() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(RSA_KEY_ALGORITHM);
        keyPairGen.initialize(KEY_SIZE);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<>();
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    /**
     * 获取公钥
     * @param keyMap RSA密钥对
     * @return 公钥
     * @throws Exception 抛出异常
     */
    public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
        if (null == keyMap || keyMap.size() == 0) {
            return null;
        }
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        String publicKey = Base64.encodeBase64String(key.getEncoded());
        log.info("公钥：" + publicKey);
        return publicKey;
    }

    /**
     * 获取私钥
     * @param keyMap RSA密钥对
     * @return 私钥
     * @throws Exception 抛出异常
     */
    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        String privateKey = Base64.encodeBase64String(key.getEncoded());
        log.info("私钥：" + privateKey);
        return privateKey;
    }

    /**
     * 用私钥对信息生成数字签名
     * @param data       已加密数据
     * @param privateKey 私钥(BASE64编码)
     * @return 签名
     * @throws Exception 抛出异常
     */
    public static String sign(String data, String privateKey) throws Exception {
        if (StringUtils.isBlank(data)) {
            return null;
        }
        // 取得私钥
        byte[] priKeyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(priKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        // 生成私钥
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 实例化Signature
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 初始化Signature
        signature.initSign(priKey);
        // 更新
        signature.update(data.getBytes());

        return Base64.encodeBase64String(signature.sign());
    }

    /**
     * RSA校验数字签名
     *
     * @param data    数据
     * @param publicKey 公钥
     * @param sign    签名
     * @return 校验结果，成功为true，失败为false
     * @throws Exception 抛出异常
     */
    public static boolean verify(String data, String publicKey, String sign) throws Exception {
        if (StringUtils.isBlank(data)) {
            return false;
        }
        // 转换公钥材料
        // 实例化密钥工厂
        byte[] pubKeyBytes = Base64.decodeBase64(publicKey);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        // 初始化公钥
        // 密钥材料转换
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(pubKeyBytes);
        // 产生公钥
        PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);
        // 实例化Signature
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 初始化Signature
        signature.initVerify(pubKey);
        // 更新
        signature.update(data.getBytes());
        // 验证
        return signature.verify(Base64.decodeBase64(sign));
    }

    /**
     * 公钥加密
     * @param data 待加密数据
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 抛出异常
     */
    private static byte[] encryptByPubKey(byte[] data, byte[] publicKey) throws Exception {
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        PublicKey publicK = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /**
     * 公钥加密
     *
     * @param data    待加密数据
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 抛出异常
     */
    public static String encryptByPubKey(String data, String publicKey) throws Exception {
        if (StringUtils.isBlank(data)) {
            return null;
        }
        // 私匙加密
        byte[] pubKeyBytes = Base64.decodeBase64(publicKey);
        byte[] enSign = encryptByPubKey(data.getBytes(), pubKeyBytes);
        return Base64.encodeBase64String(enSign);
    }

    /**
     * 私钥加密
     * @param data 待加密数据
     * @param privateKey 私钥
     * @return 密文
     * @throws Exception 抛出异常
     */
    private static byte[] encryptByPriKey(byte[] data, byte[] privateKey) throws Exception {
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }

    /**
     * 私钥加密
     * @param data 待加密数据
     * @param privateKey 私钥
     * @return 密文
     * @throws Exception 抛出异常
     */
    public static String encryptByPriKey(String data, String privateKey) throws Exception {
        if (StringUtils.isBlank(data)) {
            return null;
        }
        // 私匙加密
        byte[] priKeyBytes = Base64.decodeBase64(privateKey);
        byte[] enSign = encryptByPriKey(data.getBytes(), priKeyBytes);
        return Base64.encodeBase64String(enSign);
    }

    /**
     * 公钥解密
     *
     * @param data    待解密数据
     * @param publicKey 公钥
     * @return 明文
     * @throws Exception 抛出异常
     */
    private static byte[] decryptByPubKey(byte[] data, byte[] publicKey) throws Exception {
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        PublicKey publicK = keyFactory.generatePublic(x509KeySpec);
        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    /**
     * 公钥解密
     *
     * @param data    待解密数据
     * @param pub_key 公钥
     * @return 明文
     * @throws Exception 抛出异常
     */
    public static String decryptByPubKey(String data, String pub_key) throws Exception {
        if (StringUtils.isBlank(data)) {
            return null;
        }
        // 公匙解密
        byte[] pub_key_bytes = Base64.decodeBase64(pub_key);
        byte[] design = decryptByPubKey(Base64.decodeBase64(data), pub_key_bytes);
        return new String(design);
    }

    /**
     * 私钥解密
     * @param encryptedData 待解密数据
     * @param privateKey 私钥
     * @return 明文
     * @throws Exception 抛出异常
     */
    private static byte[] decryptByPriKey(byte[] encryptedData, byte[] privateKey) throws Exception {
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_KEY_ALGORITHM);
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    /**
     * 私钥解密
     * @param data 待解密数据
     * @param privateKey 私钥
     * @return 明文
     * @throws Exception 抛出异常
     */
    public static String decryptByPriKey(String data, String privateKey) throws Exception {
        if (StringUtils.isBlank(data)) {
            return null;
        }
        // 私匙解密
        byte[] priKeyBytes = Base64.decodeBase64(privateKey);
        byte[] design = decryptByPriKey(Base64.decodeBase64(data), priKeyBytes);
        return new String(design);
    }
}
