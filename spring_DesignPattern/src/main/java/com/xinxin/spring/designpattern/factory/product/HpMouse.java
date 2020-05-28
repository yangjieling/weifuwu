package com.xinxin.spring.designpattern.factory.product;

/**
 * 具体产品-惠普鼠标
 */
public class HpMouse extends Mouse {
    @Override
    public void sayHi() {
        System.out.println("**** SimpleFactoryPattern ****    I am a Hp Mouse.");
    }
}
