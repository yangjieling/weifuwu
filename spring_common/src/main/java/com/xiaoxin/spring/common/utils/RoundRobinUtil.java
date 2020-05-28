package com.xiaoxin.spring.common.utils;

public class RoundRobinUtil {

    public static void main(String[] args) {
//        int[] arr = {10,9,8,7,6,5,4,3,2,1,0};
//        int index = 0;
//        int i = 0;
//        for(;i<11;i++){
//            int nextIndex = (index+1) % arr.length;
//            index = nextIndex;
//            System.out.println(arr[nextIndex]);
//        }

        String  email = "909231497@qq.com";
        String phoneReg = "^[1][34578]\\d{9}$";
        String phone = "13611566308";
        System.out.println(phone.matches(phoneReg));
    }
}
