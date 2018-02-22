package com.tangtang.benchmark.disruptor;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tangwenbo
 * @date 2018/1/15
 * @since JDK1.8
 */
public class executorService {

  public static void main(String[] args) {
//    ExecutorService executorService = Executors.newCachedThreadPool();
//
//    WaitStrategy BLOCKING_WAIT = new BlockingWaitStrategy();
//    WaitStrategy SLEEPING_WAIT = new SleepingWaitStrategy();
//    WaitStrategy YIELDING_WAIT = new YieldingWaitStrategy();

    EventFactory<LongEvent> eventFactory = new LongEventFactory();
    ExecutorService executor = Executors.newSingleThreadExecutor();
    // RingBuffer 大小，必须是 2 的 N 次方；
    int ringBufferSize = 1024 * 1024;

    Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(eventFactory,
        ringBufferSize, executor, ProducerType.SINGLE,
        new YieldingWaitStrategy());

    EventHandler<LongEvent> eventHandler = new LongEventHandler();
    disruptor.handleEventsWith(eventHandler);

    disruptor.start();
  }
}
