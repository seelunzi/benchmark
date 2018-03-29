package com.tangtang.benchmark.blockqueue;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author tangwenbo
 * @date 2018/1/14
 * @since JDK1.8
 */
public class BlockQueueTest {

  public static void main(String[] args) {
    LinkedBlockingDeque<String> strings = new LinkedBlockingDeque<>(2);
    try {
      strings.put("a");
      strings.put("b");
      boolean d = strings.offer("D");
      System.out.println(strings);
      System.out.println(d);
      Thread.sleep(60);
      strings.poll();
      strings.put("c");
      System.out.println(strings);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
