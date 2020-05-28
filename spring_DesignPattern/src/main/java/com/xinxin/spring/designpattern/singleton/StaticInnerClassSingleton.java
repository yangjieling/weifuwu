package com.xinxin.spring.designpattern.singleton;

/**
 * 静态内部类实现单例模式
 * 静态内部类特点：
 * 当外部类被加载时静态内部类不会被加载，实现了懒加载
 * 当类被加载时是线程安全的，保证了线程安全
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton(){

    }

    private static class SingletonInstance{
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance(){
        return SingletonInstance.INSTANCE;
    }
}