package com.sander.MessageDigest.MAC;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class JDK_MAC {

    public static String initHMACKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        SecretKey key = keyGenerator.generateKey();
        byte[] keyBytes = key.getEncoded();
        return DatatypeConverter.printHexBinary(keyBytes);
    }

    public static String encode(String plainText, String key) throws NoSuchAlgorithmException, InvalidKeyException {
        byte[] keyBytes = DatatypeConverter.parseHexBinary(key);
        SecretKey secretKey = new SecretKeySpec(keyBytes, "HmacMD5");
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        byte[] cipherBytes = mac.doFinal(plainText.getBytes());
        String cipher = DatatypeConverter.printHexBinary(cipherBytes).toString();
        return cipher;
    }
}
