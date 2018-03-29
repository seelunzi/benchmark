package com.tangtang.benchmark;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BenchmarkApplicationTests {

	@Test
	public void contextLoads() {
        byte[] bytes = "be34f4e5a973d73f91d16b6d279034dc".getBytes();
        RSA sadsadsd = new RSA(null, bytes);
        byte[] encrypt = sadsadsd.encrypt(StrUtil.bytes("我是一段测试aaaa", CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
	}

}
