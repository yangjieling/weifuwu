package com.xinxin.spring.thread;


import java.util.concurrent.TimeUnit;

/**
 * 什么是线程：
 * 进程里的一个最小执行单元，程序不同的执行路径
 */
public class WhatIsThread {

    private static class TestThread extends Thread{
        @Override
        public void run() {
            for (int i=0;i<10;i++){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("TestThread");
            }
        }
    }

    public static void main(String[] args) {
        new TestThread().start();
        for (int i=0;i<10;i++){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main");
        }
    }
}
