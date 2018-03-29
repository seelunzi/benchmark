package com.tangtang.benchmark.jdk;

/**
 * @author tangwenbo
 * @date 2018/1/14
 * @since JDK1.8
 */
public class UserServiceImpl implements UserService {
  @Override
  public String getName(int id) {
    System.out.println("------getName------");
    return "Tom";
  }

  @Override
  public Integer getAge(int id) {
    System.out.println("------getAge------");
    return 10;
  }
}