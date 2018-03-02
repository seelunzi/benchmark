package com.tangtang.benchmark.token;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

public class Rsa {
    public static void main(String[] args) {
        RSA rsa = new RSA();

//获得私钥
        rsa.getPrivateKey();
        rsa.getPrivateKeyBase64();
//获得公钥
        rsa.getPublicKey();
        rsa.getPublicKeyBase64();

//公钥加密，私钥解密
        byte[] encrypt = rsa.encrypt(StrUtil.bytes("我是一段测试aaaa", CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
        byte[] decrypt = rsa.decrypt(encrypt, KeyType.PrivateKey);

//Junit单元测试
        // Assert.assertEquals("我是一段测试aaaa", StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8));
    }
}
