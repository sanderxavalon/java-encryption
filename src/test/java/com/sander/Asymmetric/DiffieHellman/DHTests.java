package com.sander.Asymmetric.DiffieHellman;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

public class DHTests {

    // 甲方公鑰
    private byte[] publicKey_A;
    // 甲方私鑰
    private byte[] privateKey_A;
    // 甲方密鑰
    private byte[] key_A;

    // 乙方公鑰
    private byte[] publicKey_B;
    // 乙方私鑰
    private byte[] privateKey_B;
    // 乙方密鑰
    private byte[] key_B;



    @Before
    public final void initKey() throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, InvalidKeyException {
        // 產生甲方公鑰
        Map<String, Key> keyMap_A = DH.initKey();
        publicKey_A = DH.getPublicKey(keyMap_A);
        privateKey_A = DH.getPrivateKey(keyMap_A);
        System.out.println("甲方公鑰:" + Base64.encodeBase64String(publicKey_A));
        System.out.println("甲方私鑰:" + Base64.encodeBase64String(privateKey_A));

        // 用甲方公鑰產生乙方私鑰
        Map<String, Key> keyMap_B = DH.initKey(publicKey_A);
        publicKey_B = DH.getPublicKey(keyMap_B);
        privateKey_B = DH.getPrivateKey(keyMap_B);
        System.out.println("乙方公鑰:" + Base64.encodeBase64String(publicKey_B));
        System.out.println("乙方私鑰:" + Base64.encodeBase64String(privateKey_B));

        key_A = DH.getSecretKey(publicKey_B, privateKey_A);
        System.out.println("甲方本地密鑰:" + Base64.encodeBase64String(key_A));
        key_B = DH.getSecretKey(publicKey_A, privateKey_B);
        System.out.println("乙方本地密鑰:" + Base64.encodeBase64String(key_B));

    }

    @Test
    public final void DHTest() throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        System.out.println("===開始甲方送乙方加密數據===");
        String plainText_A = "Sander非對稱加密測試甲方TO乙方";
        System.out.println("原文:" + plainText_A);
        System.out.println("===甲方使用本地密鑰加密===");
        byte[] cipherBytes_A = DH.encrypt(plainText_A.getBytes(), key_A);
        System.out.println("甲方加密後密文:" + Base64.encodeBase64String(cipherBytes_A));
        byte[] plainTextByte_A = DH.decrypt(cipherBytes_A, key_B);
        System.out.println("乙方解密後明文:" + new String(plainTextByte_A));

        System.out.println("===開始甲方送乙方加密數據===");
        String plainText_B = "Sander非對稱加密測試乙方TO甲方";
        byte[] cipherBytes_B = DH.encrypt(plainText_B.getBytes(), key_B);
        System.out.println("乙方加密後密文:" + Base64.encodeBase64String(cipherBytes_B));
        byte[] plainTextByte_B = DH.decrypt(cipherBytes_B, key_A);
        System.out.println("甲方解密後明文:" + new String(plainTextByte_B));

    }


}
