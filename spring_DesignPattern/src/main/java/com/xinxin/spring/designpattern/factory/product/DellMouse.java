package com.xinxin.spring.designpattern.factory.product;

/**
 * 具体产品-戴尔鼠标
 */
public class DellMouse extends Mouse {
    @Override
    public void sayHi() {
        System.out.println("**** SimpleFactoryPattern ****    I am a Dell Mouse.");
    }
}
