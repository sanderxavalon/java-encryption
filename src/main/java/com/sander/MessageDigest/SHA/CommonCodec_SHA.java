package com.sander.MessageDigest.SHA;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

public class CommonCodec_SHA {
    public final static String ENCODING = "UTF-8";

    public static String encode(String plainText) throws UnsupportedEncodingException {
        return DigestUtils.sha1Hex(plainText);
    }

}
