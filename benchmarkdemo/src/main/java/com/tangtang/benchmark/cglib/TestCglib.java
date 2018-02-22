package com.tangtang.benchmark.cglib;

import com.tangtang.benchmark.jdk.UserService;
import com.tangtang.benchmark.jdk.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author tangwenbo
 * @date 2018/1/14
 * @since JDK1.8
 */
public class TestCglib {

  public static void main(String[] args) {
    Cglib cglib = new Cglib();
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(UserServiceImpl.class);
    enhancer.setCallback(cglib);
    UserService o = (UserService) enhancer.create();
    o.getName(1);
    o.getAge(1);
  }
}
