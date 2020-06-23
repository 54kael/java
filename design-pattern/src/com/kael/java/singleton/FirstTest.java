package com.kael.java.singleton;

import com.kael.java.util.CalculateUtil1;
import com.kael.java.util.CalculateUtil2;
import com.kael.java.util.SingletonEnum;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    public static void main(String[] args) throws InterruptedException {
        test3();
    }

    public static void test1() {
        CalculateUtil1 calculate1 = CalculateUtil1.getCalculate1();
        CalculateUtil1 calculate2 = CalculateUtil1.getCalculate1();
        System.out.println(calculate1);
        System.out.println(calculate2);
    }

    public static void test2() throws InterruptedException {
        Runnable r = () -> {
            CalculateUtil2 calculateUtil21 = null;
            try {
                calculateUtil21 = CalculateUtil2.getCalculate2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("新线程获取："+calculateUtil21);
        };
        new Thread(r).start();
        CalculateUtil2 calculateUtil2 = CalculateUtil2.getCalculate2();
        System.out.println("主线程"+calculateUtil2);
    }

    public static void test3() {
        SingletonEnum singletonEnum = SingletonEnum.singletonEnum;
        singletonEnum.setId("1");
        singletonEnum.setName("xiaoming");
        System.out.println(singletonEnum);
        System.out.println(singletonEnum.hashCode());
        SingletonEnum singletonEnum1 = SingletonEnum.singletonEnum;
        singletonEnum1.setName("xiaohong");
        System.out.println(singletonEnum1);
        System.out.println(singletonEnum1.hashCode());
    }
}
