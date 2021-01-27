package com.sander.MessageDigest.MAC;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;

public class CommonCodec_MAC {

    public final static String ENCODING = "UTF-8";

    public static String encode(String plainText,   String key) throws UnsupportedEncodingException {
        byte[] keyByte = DatatypeConverter.parseHexBinary(key);
        byte[] cipherBytes = new HmacUtils("HmacMD5", keyByte).hmac(plainText);
        return DatatypeConverter.printHexBinary(cipherBytes);
    }

}
