package com.xinxin.spring.thread.method;

import java.util.concurrent.TimeUnit;

public class Sleep_Yield_Join {
    public static void main(String[] args) {
        //testSleep();
        //testYield();
        testJoin();
    }

    /**
     * sleep:当前线程暂停执行，暂停这段时间不抢占CPU资源，但是不释放自己获取的锁
     * 其他线程可以通过调用改线程的interrup()唤醒，被唤醒线程会抛出异常InterruptedException
     * 关于释放锁需要调整测试代码，后边锁的地方再演示
     */
    static void testSleep(){
        new Thread(()->{
            for (int i=0;i<100;i++){
                System.out.println(Thread.currentThread().getName() + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"testSleep").start();
    }

    /**
     * yield:线程停止执行，重新回到队列中和其他获取资源的线程再次共同抢占CPU资源，
     * 有可能下一个获取到CPU资源的还是他，但是其他线程获取CPU资源的可能性更大
     * 但是线程也不会释放锁
     * 关于释放锁需要调整测试代码，后边锁的地方再演示
     */
    static void testYield(){
        Thread thread = new Thread(() -> {
            for (int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName() + i);
                Thread.yield();
            }
        },"testYield-A");

        Thread thread1 = new Thread(() -> {
            for (int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName() + i);
                Thread.yield();
            }
        }, "testThread-B");

        thread.start();
        thread1.start();
    }

    /**
     * join:当前的线程加入你要调用join的线程，调用者线程会等待被调用者线程执行完成后，调用者线程再继续执行
     */
    static void testJoin(){
        Thread t1 = new Thread(() -> {
            for (int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName() + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "testJoinA");

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "testJoinB");

        t1.start();
        t2.start();
    }
}
