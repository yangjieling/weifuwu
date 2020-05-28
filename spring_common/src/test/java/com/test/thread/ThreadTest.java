package com.test.thread;

import java.util.Random;

public class ThreadTest extends Thread {

    private Work work;

    public ThreadTest(Work work){
        this.work = work;
    }

    @Override
    public void run() {
        Random random = new Random();
        Data data = new Data();
        int n1 = random.nextInt(1000);
        int n2 = random.nextInt(2000);
        int n3 = random.nextInt(3000);
        work.process(data,n1,n2,n3);
        System.out.println(String.valueOf(n1) + "+" + String.valueOf(n2) + "+"
                + String.valueOf(n3) + "=" + data.value);
    }

    public static void main(String[] args) {
        Thread thread = new ThreadTest(new Work());
        thread.start();
    }
}

class Data{
    public int value = 0;
}

class Work{
    public void process(Data data,Integer... numbers){
        for (int n : numbers){
            data.value += n;
        }
    }
}