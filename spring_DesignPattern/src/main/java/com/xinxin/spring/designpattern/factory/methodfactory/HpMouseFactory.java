package com.xinxin.spring.designpattern.factory.methodfactory;

import com.xinxin.spring.designpattern.factory.product.HpMouse;
import com.xinxin.spring.designpattern.factory.product.Mouse;

/**
 * 具体工厂-生产惠普鼠标
 */
public class HpMouseFactory extends MouseFactory {
    @Override
    public Mouse ManufactureMouse() {
        return new HpMouse();
    }
}
