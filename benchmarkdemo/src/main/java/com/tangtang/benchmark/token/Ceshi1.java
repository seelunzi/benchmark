package com.tangtang.benchmark.token;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

public class Ceshi1 {

    public static void main(String[] args) throws Exception {
        byte[] bytes = "be34f4e5a973d73f91d16b6d279034dc".getBytes();
        RSA sadsadsd = new RSA("be34f4e5a973d73f91d16b6d279034dc", null);
        byte[] encrypt = sadsadsd.encrypt(StrUtil.bytes("我是一段测试aaaa", CharsetUtil.CHARSET_UTF_8), KeyType.PrivateKey);

//        String key="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVRiDkEKXy/KBTe+UmkA+feq1zGWIgBxkgbz7aBJGb5+eMKKoiDRoEHzlGndwFKm4mQWNftuMOfNcogzYpGKSEfC7sqfBPDHsGPZixMWzL3J10zkMTWo6MDIXKKqMG1Pgeq1wENfJjcYSU/enYSZkg3rFTOaBSFId+rrPjPo7Y4wIDAQAB";
//        int length = key.length();
//        System.out.print(length);

//        PublicKey be34f4e5a973d73f91d16b6d279034dc = RSAUtils.loadPublicKey("ce789c61bbd5b4d30e674ce05544d49d");

//        PrivateKey be34f4e5a973d73f91d16b6d279034dc1 = RSAUtils.loadPrivateKey("be34f4e5a973d73f91d16b6d279034dc");
//
//        byte[] bytes = RSAUtils.encryptData("我是一段测试aaaa".getBytes(), be34f4e5a973d73f91d16b6d279034dc1);
//
////        RSAUtils.
//        String encode = Base64Utils.encode(bytes);
//        System.out.print(encode);


    }
}
