package com.tangtang.benchmark.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author tangwenbo
 * @date 2018/1/15
 * @since JDK1.8
 */
public class LongEventFactory implements EventFactory<LongEvent> {

  @Override public LongEvent newInstance() {
    return new LongEvent();
  }
}
