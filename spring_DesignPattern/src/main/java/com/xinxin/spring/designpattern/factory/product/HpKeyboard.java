package com.xinxin.spring.designpattern.factory.product;

/**
 * 具体产品-惠普键盘
 */
public class HpKeyboard extends Keyboard {
    @Override
    public void sayHi() {
        System.out.println("**** AbstractFactoryPattern ****    I am a Hp Keyboard.");
    }
}
