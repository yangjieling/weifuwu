package com.test.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaTest {

    public static void main(String[] args) {
        Runnable java8_lambda = () -> System.out.println("java8 lambda");
        java8_lambda.run();
        testConsumer();
        Integer supplier = testSupplier();
        System.out.println("main:supplier=====>" + supplier);
        Integer function = testFunction();
        System.out.println("main:function=====>" + function);
    }

    public static void testConsumer(){
        Consumer<String> consumer = (a) -> System.out.println(a);
        consumer.accept("accept");
    }

    public static Integer testSupplier(){
        Supplier<Integer> supplier = () -> {
            System.out.println("supplier");
            return new Integer("123");
        };
        return supplier.get();
    }

    public static Integer testFunction(){
        Function<String,Integer> function = (a) -> new Integer(a);
        return function.apply("123");
    }
}
