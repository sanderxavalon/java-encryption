package com.sander;

import com.sander.BASE64.BouncyCastle_BASE64;
import com.sander.BASE64.CommonCodec_BASE64;
import com.sander.BASE64.JDK_BASE64;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class BASE64Tests {

    @Test
    public void BouncyCastleBase64Test() throws UnsupportedEncodingException {
        String plainText = "SanderBASE64加解密實驗";
        System.out.println("原文:" + plainText);
        String cipher = BouncyCastle_BASE64.encode(plainText);
        System.out.println("加密後:" + cipher);
        String restoreText = BouncyCastle_BASE64.decode(cipher);
        System.out.println("解密後" + restoreText);
    }

    @Test
    public void CommonCodecBase64Test() throws UnsupportedEncodingException {
        String plainText = "SanderBASE64加解密實驗";
        System.out.println("原文:" + plainText);
        String cipher = CommonCodec_BASE64.encode(plainText);
        System.out.println("加密後:" + cipher);
        String restoreText = CommonCodec_BASE64.decode(cipher);
        System.out.println("解密後" + restoreText);
    }

    @Test
    public void CommonCodecBase64WithRFC2045Test() throws UnsupportedEncodingException {
        String plainText = "SanderBASE64加解密實驗";
        System.out.println("原文:" + plainText);
        String cipher = CommonCodec_BASE64.encodeInRFC2045(plainText);
        System.out.println("加密後(有LineBreak):" + cipher);
        String restoreText = CommonCodec_BASE64.decode(cipher);
        System.out.println("解密後" + restoreText);
    }

    // 注意：不要用這種方法
    @Test
    public void JDKBase64Test() throws IOException {
        String plainText = "SanderBASE64加解密實驗";
        System.out.println("原文:" + plainText);
        String cipher = JDK_BASE64.encode(plainText);
        System.out.println("加密後" + cipher);
        String restoreText = JDK_BASE64.decode(cipher);
        System.out.println("解密後" + restoreText);
    }
}
