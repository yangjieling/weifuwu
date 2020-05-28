package com.xinxin.spring.designpattern.test;

import com.xinxin.spring.designpattern.factory.SimpleFactory;
import com.xinxin.spring.designpattern.factory.abstractfactory.DellFactory;
import com.xinxin.spring.designpattern.factory.abstractfactory.HpFactory;
import com.xinxin.spring.designpattern.factory.methodfactory.DellMouseFactory;
import com.xinxin.spring.designpattern.factory.methodfactory.HpMouseFactory;
import com.xinxin.spring.designpattern.factory.product.Keyboard;
import com.xinxin.spring.designpattern.factory.product.Mouse;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

/**
 * 工厂模式单元测试
 */
public class FactoryTest {

    /**
     * 简单工厂模式测试
     */
    @Test
    public void test1(){
        Mouse mouse = SimpleFactory.ManufactureMouse("Dell");
        mouse.sayHi();
    }

    /**
     * 工厂方法模式测试
     */
    @Test
    public void test2(){
        DellMouseFactory dellMouseFactory = new DellMouseFactory();
        Mouse mouse = dellMouseFactory.ManufactureMouse();
        mouse.sayHi();

        HpMouseFactory hpMouseFactory = new HpMouseFactory();
        Mouse mouse1 = hpMouseFactory.ManufactureMouse();
        mouse1.sayHi();

    }

    /**
     * 抽象工厂模式测试
     */
    @Test
    public void test3(){
        DellFactory dellFactory = new DellFactory();
        Keyboard keyboard = dellFactory.ManufactureKeyboard();
        Mouse mouse = dellFactory.ManufactureMouse();
        keyboard.sayHi();
        mouse.sayHi();

        HpFactory hpFactory = new HpFactory();
        Keyboard keyboard1 = hpFactory.ManufactureKeyboard();
        Mouse mouse1 = hpFactory.ManufactureMouse();
        keyboard1.sayHi();
        mouse1.sayHi();
    }

    /**
     * JDK源码 Calendar
     */
    @Test
    public void testResource(){
        Calendar calendar = Calendar.getInstance();

        /**
         * .........
         * if (aLocale.hasExtensions()) {
         *             String caltype = aLocale.getUnicodeLocaleType("ca");
         *             if (caltype != null) {
         *                 switch (caltype) {
         *                 case "buddhist":
         *                 cal = new BuddhistCalendar(zone, aLocale);
         *                     break;
         *                 case "japanese":
         *                     cal = new JapaneseImperialCalendar(zone, aLocale);
         *                     break;
         *                 case "gregory":
         *                     cal = new GregorianCalendar(zone, aLocale);
         *                     break;
         *                 }
         *             }
         *         }
         * .........
         */
    }
}
