package com.xinxin.spring.designpattern.factory.methodfactory;

import com.xinxin.spring.designpattern.factory.product.DellMouse;
import com.xinxin.spring.designpattern.factory.product.Mouse;

/**
 * 生成Dell鼠标的工厂
 */
public class DellMouseFactory extends MouseFactory {
    @Override
    public Mouse ManufactureMouse() {
        return new DellMouse();
    }
}
