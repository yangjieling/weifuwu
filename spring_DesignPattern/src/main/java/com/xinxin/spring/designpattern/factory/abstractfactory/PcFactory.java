package com.xinxin.spring.designpattern.factory.abstractfactory;

import com.xinxin.spring.designpattern.factory.product.Keyboard;
import com.xinxin.spring.designpattern.factory.product.Mouse;

/**
 * 抽象工厂-生产鼠标和键盘
 */
public abstract class PcFactory {
    public abstract Mouse ManufactureMouse();
    public abstract Keyboard ManufactureKeyboard();
}
