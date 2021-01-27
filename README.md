# java-encryption

## 說明

大概就是把常見的演算法用實現一次這樣。
`test`資料夾內含有測試案例可供參考。

## 依賴

除原生API實現加密與編碼以外，依賴以下兩個Package：

```xml
    <dependency>
      <groupId>commons-codec</groupId>
      <artifactId>commons-codec</artifactId>
      <version>1.14</version>
    </dependency>
    <dependency>
      <groupId>org.bouncycastle</groupId>
      <artifactId>bcprov-jdk15to18</artifactId>
      <version>1.66</version>
    </dependency>
```

## 編碼與加密演算法

### BASE64

實現：`API`, `common-codec`, `bouncycastle`

### MessageDigest(消息摘要)

`MD5`, `SHA`, `MAC`實現：`API`, `common-codec`, `bouncycastle`

### Symmetric(對稱加密)

`AES`, `DES`, `DESede`, `PBE`實現：`API`

### Asymmetric(非對稱加密)

`DH(Diffle-Hellman)`, `RSA`實現：`API`

