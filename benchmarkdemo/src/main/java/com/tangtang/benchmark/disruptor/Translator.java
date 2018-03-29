package com.tangtang.benchmark.disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

/**
 * @author tangwenbo
 * @date 2018/1/15
 * @since JDK1.8
 */
public class Translator implements EventTranslatorOneArg<LongEvent, Long> {

  public static Translator TRANSLATOR = new Translator();

  @Override public void translateTo(LongEvent longEvent, long l, Long data) {
    longEvent.set(data);
  }

  public static void publishEvent2(Disruptor<LongEvent> disruptor) {
    // 发布事件；
    RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
    //获取要通过事件传递的业务数据；
    long data = 12;
    ringBuffer.publishEvent(TRANSLATOR, data);
  }
}
