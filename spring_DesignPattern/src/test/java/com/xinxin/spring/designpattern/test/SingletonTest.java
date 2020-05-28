package com.xinxin.spring.designpattern.test;

import com.xinxin.spring.designpattern.singleton.DoubleCheckSingleton;
import com.xinxin.spring.designpattern.singleton.EnumSingleton;
import com.xinxin.spring.designpattern.singleton.StaticInnerClassSingleton;
import org.junit.jupiter.api.Test;

/**
 * 单例模式实现单元测试
 */
public class SingletonTest {

    public static void main(String[] args) {
        DoubleCheckSingleton instance1 = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton instance2 = DoubleCheckSingleton.getInstance();
        System.out.println(instance1 ==  instance2);
    }

    /**
     * 双从检查单例模式测试
     */
    @Test
    public void test1(){
        DoubleCheckSingleton instance1 = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton instance2 = DoubleCheckSingleton.getInstance();
        System.out.println(instance1 ==  instance2);
    }

    /**
     * 静态内部类
     */
    @Test
    public void test2(){
        StaticInnerClassSingleton instance1 = StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton instance2 = StaticInnerClassSingleton.getInstance();
        System.out.println(instance1 == instance2);
    }

    /**
     * 枚举
     */
    @Test
    public void test3(){
        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        EnumSingleton instance2 = EnumSingleton.INSTANCE;
        System.out.println(instance1 == instance2);
    }

    /**
     * JDK源码示例
     */
    @Test
    public void testResource(){
        Runtime instance1 = Runtime.getRuntime();
        Runtime instance2 = Runtime.getRuntime();
        System.out.println(instance1 == instance2);

        //Runtime的availableProcessor()方法返回当前系统的CPU数目
        int i = instance1.availableProcessors();
        System.out.println(i);
    }
}