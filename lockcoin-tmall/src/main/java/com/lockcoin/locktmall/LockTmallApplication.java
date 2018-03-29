package com.lockcoin.locktmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author tangwenbo
 * @date 2018/1/29
 * @since JDK1.8
 */
@SpringBootApplication
@EnableSwagger2
@EnableScheduling
@EnableAsync
@EnableRedisHttpSession
public class LockTmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(LockTmallApplication.class, args);
    }
}
