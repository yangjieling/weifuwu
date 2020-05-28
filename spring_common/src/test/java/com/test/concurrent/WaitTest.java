package com.test.concurrent;

public class WaitTest implements Runnable {

    private static Object obj = new Object();

    @Override
    public void run() {
        synchronized (obj){
            System.out.println(Thread.currentThread().getName()+"占用资源");
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
            System.out.println(Thread.currentThread().getName() + "释放资源");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new WaitTest(),"线程1");
        thread.start();
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (obj){
            obj.notify();
        }
    }
}