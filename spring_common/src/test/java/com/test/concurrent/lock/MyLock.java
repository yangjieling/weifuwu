package com.test.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义重复锁：同一个线程可以重复获取锁
 * 当调用wait()/notify()方法时必须持有锁，且是同一把锁
 * 可以在方法加上synchronize关键字
 */
public class MyLock implements Lock {

    private boolean isHotLock = false; //是否有线程持有锁

    private Thread hotLockThread = null;//当前正持有锁的线程

    private int hotLockCount;//当前线程持有锁的次数

    @Override
    public synchronized void lock() {
        if (isHotLock && Thread.currentThread() != hotLockThread){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isHotLock = true;
        hotLockThread = Thread.currentThread();
        hotLockCount++;

    }

    @Override
    public synchronized void unlock() {
        if (Thread.currentThread() == hotLockThread){
            hotLockCount--;
            if (hotLockCount == 0){
                notify();
                isHotLock = false;
            }
        }

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
