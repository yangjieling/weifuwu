package com.xinxin.spring.designpattern.factory.abstractfactory;

import com.xinxin.spring.designpattern.factory.product.DellKeyboard;
import com.xinxin.spring.designpattern.factory.product.DellMouse;
import com.xinxin.spring.designpattern.factory.product.Keyboard;
import com.xinxin.spring.designpattern.factory.product.Mouse;

/**
 * 具体工厂-生产戴尔鼠标和戴尔键盘
 */
public class DellFactory extends PcFactory {
    @Override
    public Mouse ManufactureMouse() {
        return new DellMouse();
    }

    @Override
    public Keyboard ManufactureKeyboard() {
        return new DellKeyboard();
    }
}
