package com.sander.MessageDigest.MAC;

import org.apache.commons.codec.digest.HmacUtils;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;

public class BouncyCastle_MAC {
    public final static String ENCODING = "UTF-8";

    public static String encode(String plainText,   String key) throws UnsupportedEncodingException {
        byte[] keyByte = Hex.decode(key);
        HMac hMac = new HMac(new MD5Digest());
        hMac.init(new KeyParameter(keyByte));
        hMac.update(plainText.getBytes(), 0, plainText.length());
        byte[] cipherBytes = new byte[hMac.getMacSize()];
        hMac.doFinal(cipherBytes, 0);
        return Hex.toHexString(cipherBytes);
    }

}
