package com.sander.MessageDigest.SHA;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.util.encoders.Hex;

import java.io.UnsupportedEncodingException;

public class BouncyCastle_SHA {
    public final static String ENCODING = "UTF-8";

    public static String encode(String plainText) throws UnsupportedEncodingException {
        Digest digest = new SHA1Digest();
        byte[] plainTextBytes = plainText.getBytes(ENCODING);
        digest.update(plainTextBytes, 0, plainTextBytes.length);
        byte[] encodingBytes = new byte[digest.getDigestSize()];
        digest.doFinal(encodingBytes, 0);
        return Hex.toHexString(encodingBytes);
    }
}
