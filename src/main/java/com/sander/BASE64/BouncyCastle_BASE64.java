package com.sander.BASE64;

import org.bouncycastle.util.encoders.Base64;

import java.io.UnsupportedEncodingException;

public class BouncyCastle_BASE64 {

    public final static String ENCODING = "UTF-8";

    public static String encode(String plainText) throws UnsupportedEncodingException {
        byte[] bytes = Base64.encode(plainText.getBytes(ENCODING));
        return new String(bytes, ENCODING);
    }

    public static String decode(String cipher) throws UnsupportedEncodingException {
        byte[] bytes = Base64.decode(cipher.getBytes(ENCODING));
        return  new String(bytes, ENCODING);
    }
}
