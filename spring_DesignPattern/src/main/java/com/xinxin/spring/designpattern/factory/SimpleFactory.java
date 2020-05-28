package com.xinxin.spring.designpattern.factory;

import com.xinxin.spring.designpattern.factory.product.DellMouse;
import com.xinxin.spring.designpattern.factory.product.HpMouse;
import com.xinxin.spring.designpattern.factory.product.Mouse;

/**
 * 简单/静态工厂模式
 * 违反了开闭原则
 * 设计步骤：
 * 抽象产品
 * 具体产品
 * 产品工厂类
 */
public class SimpleFactory {

    public static Mouse ManufactureMouse(String mouseType){
        if ("Dell".equals(mouseType)){
            return new DellMouse();
        } else if ("Hp".equals(mouseType)) {
            return new HpMouse();
        }
        return null;
    }
}
