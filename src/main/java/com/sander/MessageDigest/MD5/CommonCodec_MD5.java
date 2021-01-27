package com.sander.MessageDigest.MD5;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jcajce.provider.digest.MD5;
import org.bouncycastle.util.encoders.Base64;

import java.io.UnsupportedEncodingException;

public class CommonCodec_MD5 {

    public final static String ENCODING = "UTF-8";

    public static String encode(String plainText) throws UnsupportedEncodingException {
        return DigestUtils.md5Hex(plainText);
    }

}
