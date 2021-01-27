package com.sander.BASE64;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class CommonCodec_BASE64 {

    public final static String ENCODING = "UTF-8";

    public static String encode(String plainText) throws UnsupportedEncodingException {
        byte[] bytes = Base64.encodeBase64(plainText.getBytes(ENCODING));
        return new String(bytes, ENCODING);
    }

    public static String encodeInRFC2045(String plainText) throws UnsupportedEncodingException {
        byte[] bytes = Base64.encodeBase64(plainText.getBytes(ENCODING), true);
        return new String(bytes, ENCODING);
    }

    public static String decode(String cipher) throws UnsupportedEncodingException {
        byte[] bytes = Base64.decodeBase64(cipher);
        return  new String(bytes, ENCODING);
    }

}
