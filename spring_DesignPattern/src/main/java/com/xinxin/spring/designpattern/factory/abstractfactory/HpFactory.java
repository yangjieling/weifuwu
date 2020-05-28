package com.xinxin.spring.designpattern.factory.abstractfactory;

import com.xinxin.spring.designpattern.factory.product.HpKeyboard;
import com.xinxin.spring.designpattern.factory.product.HpMouse;
import com.xinxin.spring.designpattern.factory.product.Keyboard;
import com.xinxin.spring.designpattern.factory.product.Mouse;

/**
 * 具体工厂-生产惠普鼠标和惠普键盘
 */
public class HpFactory extends PcFactory {
    @Override
    public Mouse ManufactureMouse() {
        return new HpMouse();
    }

    @Override
    public Keyboard ManufactureKeyboard() {
        return new HpKeyboard();
    }
}
