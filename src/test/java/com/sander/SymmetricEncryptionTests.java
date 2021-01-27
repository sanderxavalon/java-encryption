package com.sander;

import com.sander.Symmetric.AES.AESEncryption;
import com.sander.Symmetric.DES.DESEncryption;
import com.sander.Symmetric.DESede.DESedeEncryption;
import com.sander.Symmetric.PBE.PBEEncryption;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jcajce.provider.symmetric.DES;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class SymmetricEncryptionTests {

    public static final String UTF_8 = "UTF-8";
    String plainText = "Sander對稱加解密實驗";

    @Test
    public void DESTest() throws NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, InvalidKeySpecException, InvalidKeyException, UnsupportedEncodingException {
        System.out.println("原文:" + plainText);
        byte[] key = DESEncryption.initKey();
        System.out.println("密鑰:" + Base64.encodeBase64String(key));
        byte[] cipherBytes = DESEncryption.encrypt(plainText.getBytes(UTF_8), key);
        System.out.println("密文:" + Base64.encodeBase64String(cipherBytes));
        byte[] plainTextBytes = DESEncryption.decrypt(cipherBytes, key);
        System.out.println("明文:" + new String(plainTextBytes, UTF_8));
    }

    @Test
    public void DESedeTest() throws NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, InvalidKeySpecException, InvalidKeyException, UnsupportedEncodingException {
        System.out.println("原文:" + plainText);
        byte[] key = DESedeEncryption.initKey();
        System.out.println("密鑰:" + Base64.encodeBase64String(key));
        byte[] cipherBytes = DESedeEncryption.encrypt(plainText.getBytes(UTF_8), key);
        System.out.println("密文:" + Base64.encodeBase64String(cipherBytes));
        byte[] plainTextBytes = DESedeEncryption.decrypt(cipherBytes, key);
        System.out.println("明文:" + new String(plainTextBytes, UTF_8));
    }

    @Test
    public void AESTest() throws NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, InvalidKeySpecException, InvalidKeyException, UnsupportedEncodingException {
        System.out.println("原文:" + plainText);
        byte[] key = AESEncryption.initKey();
        System.out.println("密鑰:" + Base64.encodeBase64String(key));
        byte[] cipherBytes = AESEncryption.encrypt(plainText.getBytes(UTF_8), key);
        System.out.println("密文:" + Base64.encodeBase64String(cipherBytes));
        byte[] plainTextBytes = AESEncryption.decrypt(cipherBytes, key);
        System.out.println("明文:" + new String(plainTextBytes, UTF_8));
    }

    @Test
    public void PBETest() throws NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, InvalidKeySpecException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        System.out.println("原文:" + plainText);
        String password = "ThisIsThePassword";
        byte[] salt = PBEEncryption.initSalt();
        System.out.println("密鑰:" + Base64.encodeBase64String(salt));
        byte[] cipherBytes = PBEEncryption.encrypt(plainText.getBytes(UTF_8), password, salt);
        System.out.println("密文:" + Base64.encodeBase64String(cipherBytes));
        byte[] plainTextBytes = PBEEncryption.decrypt(cipherBytes, password, salt);
        System.out.println("明文:" + new String(plainTextBytes, UTF_8));
    }
}
