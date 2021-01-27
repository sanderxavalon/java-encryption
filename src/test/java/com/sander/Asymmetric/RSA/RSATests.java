package com.sander.Asymmetric.RSA;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

public class RSATests {

    private byte[] publicKey;
    private byte[] privateKey;

    @Before
    public void initKey() throws NoSuchAlgorithmException {
        Map<String, Key> keyMap = RSA.initKey();
        publicKey = RSA.getPublicKey(keyMap);
        privateKey = RSA.getPrivateKey(keyMap);
        System.out.println();
        System.out.println("公鑰:" + Base64.encodeBase64String(publicKey));
        System.out.println("私鑰:" + Base64.encodeBase64String(privateKey));
    }

    @Test
    public void RSATest() throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        System.out.println("===私鑰加密，公鑰解密===");
        String plainText_A = "SanderRSA加密測試私加公解";
        System.out.println("原文:" + plainText_A);
        byte[] cipherBytes_A = RSA.encryptByPrivateKey(plainText_A.getBytes(),privateKey);
        System.out.println("私鑰加密後密文:" + Base64.encodeBase64String(cipherBytes_A));
        byte[] plainTextByte_A = RSA.decryptByPublicKey(cipherBytes_A, publicKey);
        System.out.println("公鑰解密後明文:" + new String(plainTextByte_A));


        System.out.println("===公鑰加密，私鑰解密===");
        String plainText_B = "SanderRSA加密測試公加私解";
        byte[] cipherBytes_B = RSA.encryptByPublicKey(plainText_B.getBytes(), publicKey);
        System.out.println("公鑰加密後密文:" + Base64.encodeBase64String(cipherBytes_B));
        byte[] plainTextByte_B = RSA.decryptByPrivateKey(cipherBytes_B, privateKey);
        System.out.println("私鑰解密後明文:" + new String(plainTextByte_B));


    }

}
