package com.test.concurrent.bean;

import lombok.SneakyThrows;

public class Person implements Runnable {
    @SneakyThrows
    @Override
    public void run() {
        System.out.println("你好 我是线程  实现了Runnable接口");
    }
}
