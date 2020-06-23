package com.kael.java.util;

/**
 * 恶汉式单例
 */
public class CalculateUtil1 {
    private CalculateUtil1(){
        System.out.println("++执行构造方法++");
    }
    private static final CalculateUtil1 c = new CalculateUtil1();

    public static CalculateUtil1 getCalculate1(){
        return c;
    }
}
