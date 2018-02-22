package com.tangtang.benchmark.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author tangwenbo
 * @date 2018/1/14
 * @since JDK1.8
 */
public class ProxyTest {

  public static void main(String[] args) {
    UserService userService = new UserServiceImpl();
    InvocationHandler invocationHandler = new MyInvocationHandler(userService);
    UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
        userService.getClass().getInterfaces(), invocationHandler);
    System.out.println(userServiceProxy.getName(1));
    System.out.println(userServiceProxy.getAge(1));
  }
}
