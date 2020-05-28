package com.test.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class ThreadTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            System.out.println("使用线程池创建线程执行");
            System.out.println(Thread.currentThread().getName());
        });
        executorService.execute(() -> {
            System.out.println("重复使用线程池创建的线程");
            System.out.println(Thread.currentThread().getName());
        });
    }

    public static void main1(String[] args) {
        Runnable runnable = () ->
                System.out.println("我是lamda实现的Runnable接口");
        ;
        Thread thread = new Thread(runnable);
        thread.start();
        Consumer<Integer> consumer = (age) -> {
            System.out.println(age);
        };
        consumer.accept(123);

    }


    @Test
    public void test1() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            System.out.println("使用线程池创建线程执行");
            Thread.currentThread().getName();
        });
        executorService.execute(() -> {
            System.out.println("重复使用线程池创建的线程");
            Thread.currentThread().getName();
        });
    }
}
