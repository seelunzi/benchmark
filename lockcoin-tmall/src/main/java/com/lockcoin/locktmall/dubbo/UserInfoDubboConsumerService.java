package com.lockcoin.locktmall.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lockcoin.locktmall.domain.UserInfo;
import org.springframework.stereotype.Component;

/**
 * @author tangwenbo
 * @date 2018/1/29
 * @since JDK1.8
 */
@Component
public class UserInfoDubboConsumerService {

    @Reference
    UserInfoDubboService cityDubboService;

    public void userInfo() {
        String Name = "user";
        UserInfo userInfo = cityDubboService.findUserInfoByName(Name);
        System.out.println(userInfo.toString());
    }
}
