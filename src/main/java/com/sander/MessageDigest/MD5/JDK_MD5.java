package com.sander.MessageDigest.MD5;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

public class JDK_MD5 {

    public static String encode(String plainText) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(plainText.getBytes());

        byte[] bytes = messageDigest.digest();
        String hash = DatatypeConverter.printHexBinary(bytes).toString();
        return hash;
    }

    public static String encodeInOldWay(String plainText) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(plainText.getBytes("UTF-8"));
        byte[] bytes = messageDigest.digest();
        StringBuffer sb = new StringBuffer(bytes.length * 2);
        for(Byte b : bytes){
            //右移四位, 取字節中前四位轉換
            sb.append(hexDigits[(b >> 4) & 0x0f]);
            //取字節中後四位轉換
            sb.append(hexDigits[b & 0x0f]);
        }
        return sb.toString();
    }

}
