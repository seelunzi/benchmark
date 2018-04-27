package com.tangtang.benchmark.deadlock;

/***
 * @author tang
 * */
public class DeiLockDemo {

    /***
     * 深入分析一下死锁产生的原因
     * 听一下别人是怎么分析这个问题的
     */
    public static void main(String[] args) {
        DeiLock dl1 = new DeiLock(true);
        /**
         * 先拿到B锁就会死锁
         * */
        DeiLock dl2 = new DeiLock(false);
        dl1.start();
        dl2.start();
        System.out.print("=========");
    }
}
