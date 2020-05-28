package com.test.concurrent.lock;

public class MyLockTest {

    private MyLock lock = new MyLock();

    public void methodA(){
        lock.lock();
        System.out.println("进入方法A");
        methodB();
        lock.unlock();
    }

    public void methodB(){
        lock.lock();
        System.out.println("进入方法B");
        lock.unlock();
    }

    public static void main(String[] args) {
        MyLockTest myLockTest = new MyLockTest();
        myLockTest.methodA();
    }
}
