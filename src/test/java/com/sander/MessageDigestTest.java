package com.sander;

import com.sander.MessageDigest.MAC.BouncyCastle_MAC;
import com.sander.MessageDigest.MAC.CommonCodec_MAC;
import com.sander.MessageDigest.MAC.JDK_MAC;
import com.sander.MessageDigest.MD5.BouncyCastle_MD5;
import com.sander.MessageDigest.MD5.CommonCodec_MD5;
import com.sander.MessageDigest.MD5.JDK_MD5;
import com.sander.MessageDigest.SHA.BouncyCastle_SHA;
import com.sander.MessageDigest.SHA.CommonCodec_SHA;
import com.sander.MessageDigest.SHA.JDK_SHA;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MessageDigestTest {

    String plainText = "ACCOUNT_BANK_ID=VDA031&ACCOUNT_HOLDER_NAME=123&ACCOUNT_NUMBER=1234567890&APPLY_TIME=20201019165343&APPLY_TYPE=RNBKC&MERCHANT_NOTIFY_ADDRESS=https&MERCHANT_SERIAL_NUMBER=RCAA0001&MERCHANT_TRANSACTION_AMOUNT=40000&MERCHANT_TRANSACTION_NUMBER=CZ2020101916534333588AAA1234567";

    @Test
    public void MD5Test() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println("原文:" + plainText);
        System.out.println("JDK MD5原生：" + JDK_MD5.encode(plainText));
        System.out.println("JDK MD5自己實現：" + JDK_MD5.encodeInOldWay(plainText));
        System.out.println("Common Codec MD5:" + CommonCodec_MD5.encode(plainText));
        System.out.println("Bouncy Castle MD5:" + BouncyCastle_MD5.encode(plainText));
    }

    @Test
    public void SHATest() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println("原文:" + plainText);
        System.out.println("JDK SHA-1原生：" + JDK_SHA.encode(plainText));
        System.out.println("JDK SHA-1自己實現：" + JDK_SHA.encodeInOldWay(plainText));
        System.out.println("Common Codec SHA-1:" + CommonCodec_SHA.encode(plainText));
        System.out.println("Bouncy Castle SHA-1:" + BouncyCastle_SHA.encode(plainText));
    }

    @Test
    public void MACTest() throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        System.out.println("原文:" + plainText);
        String key = JDK_MAC.initHMACKey();
        System.out.println("JDK MAC鑰匙：" + key);
        System.out.println("JDK MAC ：" + JDK_MAC.encode(plainText, key));
        System.out.println("Common Codec MAC ：" + CommonCodec_MAC.encode(plainText, key));
        System.out.println("Bouncy Castle MAC ：" + BouncyCastle_MAC.encode(plainText, key));
    }

}

