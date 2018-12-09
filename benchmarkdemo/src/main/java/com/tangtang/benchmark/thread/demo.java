package com.tangtang.benchmark.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author tangwenbo
 * @date 2018/1/16
 * @since JDK1.8
 */
public class demo {

    public Integer count = 0;

    public Integer add() {
        Integer count = null;
        return count++;
    }

    public static void main(String[] args) {
        final demo demo = new demo();
        Executor executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++) {
/***      executor.execute(new Runnable() {
@Override public void run() {
demo.count++;
}
});*/
            executor.execute(() -> System.out.println(demo.count++));
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("final count value:" + demo.count);
    }


}
