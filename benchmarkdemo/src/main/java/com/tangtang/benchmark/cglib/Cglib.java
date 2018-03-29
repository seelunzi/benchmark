package com.tangtang.benchmark.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author tangwenbo
 * @date 2018/1/14
 * @since JDK1.8
 */
public class Cglib implements MethodInterceptor {

  @Override public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//    System.out.println("++++++before " + methodProxy.getSuperName() + "++++++");
    HashMap<String, Object> ceshi = new HashMap<>();
    ceshi.put("sa", "asa");
    System.out.println(ceshi);
    System.out.println(method.getName());
    Object o1 = methodProxy.invokeSuper(o, objects);
//    System.out.println("++++++before " + methodProxy.getSuperName() + "++++++");
    return o1;
  }
}
