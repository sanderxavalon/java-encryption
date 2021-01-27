package com.sander.BASE64;

import org.bouncycastle.util.encoders.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class JDK_BASE64 {
    public final static String ENCODING = "UTF-8";

    public static String encode(String plainText) throws UnsupportedEncodingException {
        return new BASE64Encoder().encode(plainText.getBytes(ENCODING));
    }

    public static String decode(String cipher) throws IOException {
        byte[] bytes = new BASE64Decoder().decodeBuffer(cipher);
        return new String(bytes);
    }
}
