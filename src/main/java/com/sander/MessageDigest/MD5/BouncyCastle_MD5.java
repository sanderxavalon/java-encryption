package com.sander.MessageDigest.MD5;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.util.encoders.Hex;

import java.io.UnsupportedEncodingException;

public class BouncyCastle_MD5 {
    public final static String ENCODING = "UTF-8";

    public static String encode(String plainText) throws UnsupportedEncodingException {
        Digest digest = new MD5Digest();
        byte[] plainTextBytes = plainText.getBytes(ENCODING);
        digest.update(plainTextBytes, 0, plainTextBytes.length);
        byte[] encodingBytes = new byte[digest.getDigestSize()];
        digest.doFinal(encodingBytes, 0);
        return Hex.toHexString(encodingBytes);
    }

}
