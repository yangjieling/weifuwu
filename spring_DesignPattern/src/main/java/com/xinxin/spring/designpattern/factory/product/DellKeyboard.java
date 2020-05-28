package com.xinxin.spring.designpattern.factory.product;

/**
 * 具体产品-戴尔键盘
 */
public class DellKeyboard extends Keyboard {
    @Override
    public void sayHi() {
        System.out.println("**** AbstractFactoryPattern ****    I am a Dell Keyboard.");
    }
}
