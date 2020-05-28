package com.xinxin.spring.reflect;

import com.xinxin.springsoundcode.annotation.Autowired;
import com.xinxin.springsoundcode.controller.UserController;
import com.xinxin.springsoundcode.service.UserService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class ReflectTest {

    @Test
    public void test1() throws Exception {
        UserService userService = new UserService();
        System.out.println(userService);
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        Field field = clazz.getDeclaredField("userService");
        String name = field.getName();
        name = name.substring(0,1).toUpperCase()+name.substring(1,name.length());
        String setMethodName = "set" + name;
        Method method = clazz.getMethod(setMethodName, UserService.class);
        method.invoke(userController,userService);
        System.out.println(userController.getUserService());
    }

    @Test
    public void test2(){
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            field.setAccessible(true);
            Class<?> type = field.getType();
            try {
                Object o = type.newInstance();
                field.set(userController,o);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        System.out.println(userController.getUserService());
    }

    @Test
    public void test3(){
        UserController userController = new UserController();
        Class<? extends UserController> clazz = userController.getClass();
        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            field.setAccessible(true);
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation != null){
                Class<?> type = field.getType();
                try {
                    Object instance = type.newInstance();
                    field.set(userController,instance);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(userController.getUserService());
    }
}
