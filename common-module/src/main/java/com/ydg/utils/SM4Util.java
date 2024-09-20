package com.ydg.utils;

import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.symmetric.SM4;
import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;

/**
 * @Description: 国密算法
 * @Author : yandg
 * @Date 2024/9/18 星期三
 */
public class SM4Util {

    private final static String key = "0123456789abcdeffedcba9876543210";

    //指明加密算法和秘钥
    private static SM4 sm4 = new SM4(HexUtil.decodeHex(key));

    //加密为16进制，也可以加密成base64/字节数组
    public static String encrypt(String plaintext) {
        return Base64.encodeBase64String(sm4.encryptHex(plaintext).getBytes(StandardCharsets.UTF_8));
    }

    //解密
    public static String decrypt(String ciphertext) {
        return sm4.decryptStr(new String(Base64.decodeBase64(ciphertext.getBytes(StandardCharsets.UTF_8))));
    }

    public static void main(String[] args) {
        String plaintext = "1234567890123456";
        System.out.println(encrypt(plaintext));
//        System.out.println(decrypt(plaintext));
    }
}
