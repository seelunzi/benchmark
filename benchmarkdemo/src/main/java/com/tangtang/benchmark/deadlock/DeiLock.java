package com.tangtang.benchmark.deadlock;

public class DeiLock extends Thread {

    // 设置一个旗标,控制线程的执行与停止
    private Boolean flag;

    public DeiLock(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (MyLock.objA) {
                System.out.println("if A");
                synchronized (MyLock.objB) {
                    System.out.println("if B");
                }
            }
        } else {
            synchronized (MyLock.objB) {
                System.out.println("else B");
                synchronized (MyLock.objA) {
                    System.out.println("else A");
                }
            }
        }
    }
}
