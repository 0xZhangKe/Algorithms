/*
 * Copyright (c) 2016. Bilibili Inc.
 */

package com.zhangke.algorithms.encode;

import com.google.common.base.Charsets;
import com.zhangke.algorithms.encode.Base64;
import io.reactivex.rxjava3.annotations.Nullable;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author yrom
 */
public class AES {

    /**
     * @param key   secret key
     * @param input data bytes to encrypt
     * @return encrypted result
     * @throws InvalidKeyException      length of key is invalid or unsupported on this JVM
     * @throws GeneralSecurityException some thing went wrong
     */
    public static byte[] encryptToBytes(SecretKey key, IvParameterSpec iv, byte[] input)
            throws GeneralSecurityException {
        try {
            Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, key, iv);
            return c.doFinal(input);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * @return null if input is invalid!
     */
    public static byte[] encryptToBytes(byte[] keyBytes, byte[] ivBytes, byte[] input) {
        try {
            return encryptToBytes(new SecretKeySpec(Arrays.copyOf(keyBytes, 16), "AES"),
                    new IvParameterSpec(Arrays.copyOf(ivBytes, 16)),
                    input);
        } catch (GeneralSecurityException e) {
            return null;
        }
    }

    /**
     * Encrypt data
     *
     * @param input data bytes to encrypt
     */
    static byte[] encryptToBytes(String key, String iv, byte[] input) {
        return encryptToBytes(key.getBytes(Charsets.UTF_8), iv.getBytes(Charsets.UTF_8), input);
    }

    /**
     * Encrypt data
     *
     * @param keyBytes bytes of secret key. Will be padded with 0x00 , if length < 16, or shrink length > 16
     * @param ivBytes  bytes of secret key. Will be padded with 0x00 , if length < 16, or shrink length > 16
     * @param input    data bytes to encrypt
     * @return base64 encoded string
     */
    @Nullable
    private static String encrypt(byte[] keyBytes, byte[] ivBytes, byte[] input) {
        return encrypt(new SecretKeySpec(Arrays.copyOf(keyBytes, 16), "AES"),
                new IvParameterSpec(Arrays.copyOf(ivBytes, 16)),
                input);
    }

    /**
     * @return base64 encoded string
     */
    @Nullable
    private static String encrypt(String key, String iv, byte[] input) {
        return encrypt(key.getBytes(Charsets.UTF_8), iv.getBytes(Charsets.UTF_8), input);
    }

    /**
     * @return base64 encoded string
     */
    @Nullable
    public static String encrypt(String key, String iv, String input) {
        return encrypt(key, iv, input.getBytes(Charsets.UTF_8));
    }

    /**
     * @param key   secret key
     * @param input data bytes to encrypt
     * @return decrypted result
     * @throws InvalidKeyException      length of key is invalid or unsupported on this JVM
     * @throws GeneralSecurityException input is invalid!
     */
    private static byte[] decryptFromBytes(SecretKey key, IvParameterSpec iv, byte[] input)
            throws GeneralSecurityException {
        try {
            Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE, key, iv);
            return c.doFinal(input);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * @param key   secret key string
     * @param iv    iv parameter string
     * @param input data bytes to encrypt
     * @return decrypted result, or null if failed
     */
    @Nullable
    static byte[] decryptFromBytes(String key, String iv, byte[] input) {
        return decryptFromBytes(key.getBytes(Charsets.UTF_8),
                iv.getBytes(Charsets.UTF_8), input);
    }

    /**
     * @return decrypted result, or null if failed
     */
    @Nullable
    private static byte[] decryptFromBytes(byte[] keyBytes, byte[] ivBytes, byte[] input) {
        try {
            return decryptFromBytes(new SecretKeySpec(Arrays.copyOf(keyBytes, 16), "AES"),
                    new IvParameterSpec(Arrays.copyOf(ivBytes, 16)),
                    input);
        } catch (GeneralSecurityException e) {
            return null;
        }
    }

    /**
     * @param key     secret key string
     * @param iv      iv parameter string
     * @param encoded base64 encoded data to decrypt
     * @return decrypted result, or null if failed
     */
    public static byte[] decrypt(String key, String iv, String encoded) {
        return decryptFromBytes(key, iv, Base64.decode(encoded, Base64.NO_WRAP));
    }

    /**
     * @return base64 encoded string, null if encrypt failed
     */
    @Nullable
    static String encrypt(SecretKey key, IvParameterSpec iv, byte[] input) {
        try {
            return Base64.encodeToString(encryptToBytes(key, iv, input), Base64.NO_WRAP);
        } catch (Exception e) {
            return null;
        }
    }
}
