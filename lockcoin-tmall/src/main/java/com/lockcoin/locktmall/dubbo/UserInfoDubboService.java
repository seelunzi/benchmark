package com.lockcoin.locktmall.dubbo;

import com.lockcoin.locktmall.domain.UserInfo;

/**
 * @author tangwenbo
 * @date 2018/1/29
 * @since JDK1.8
 */
public interface UserInfoDubboService {

    /**
     * 查找用户信息
     *
     * @param name 用户名字
     * @return 用户信息
     */
    UserInfo findUserInfoByName(String name);
}
