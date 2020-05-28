package com.xinxin.spring.designpattern.factory.methodfactory;

import com.xinxin.spring.designpattern.factory.product.Mouse;

/**
 * 抽象工厂-生产鼠标
 */
public abstract class MouseFactory {

    public abstract Mouse ManufactureMouse();
}
