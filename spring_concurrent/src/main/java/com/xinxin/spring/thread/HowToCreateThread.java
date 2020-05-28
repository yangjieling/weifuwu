package com.xinxin.spring.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的几种方式
 */
public class HowToCreateThread {

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Hello MyThread");
        }
    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("Hello MyRunnable");
        }
    }

    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("Hello MyCallable");
            return "SUCCESS";
        }
    }

    /**
     * 启动线程的几种方式
     * @param args
     */
    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRunnable()).start();
        new Thread(()->{
            System.out.println("Hello MyLambda");
        }).start();

        Thread thread = new Thread(new FutureTask<String>(new MyCallable()));
        thread.start();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            System.out.println("Hello ThreadPool");
        });
        executorService.shutdown();
    }
}
