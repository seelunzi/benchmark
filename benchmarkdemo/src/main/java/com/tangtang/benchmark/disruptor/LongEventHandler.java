package com.tangtang.benchmark.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author tangwenbo
 * @date 2018/1/15
 * @since JDK1.8
 */
public class LongEventHandler implements EventHandler<LongEvent> {

  @Override public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
    System.out.println("Event: " + longEvent);
  }
}
