package com.sander.MessageDigest.SHA;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JDK_SHA {

    public static String encode(String plainText) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA");
        messageDigest.update(plainText.getBytes());
        byte[] bytes = messageDigest.digest();
        String hash = DatatypeConverter.printHexBinary(bytes).toString();
        return hash;
    }

    public static String encodeInOldWay(String plainText) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA");
        messageDigest.update(plainText.getBytes());
        byte[] bytes = messageDigest.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xff & bytes[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
