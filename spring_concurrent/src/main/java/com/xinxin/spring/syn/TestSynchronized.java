package com.xinxin.spring.syn;

import org.openjdk.jol.info.ClassLayout;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试synchronized关键字
 */

public class TestSynchronized {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("a","a");
        map.put("b","b");
        map.put("b","c");
        map.put(null,2);
        map.put(null,"3");
        System.out.println(ClassLayout.parseInstance(map).toPrintable());
    }
}