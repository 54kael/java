package com.kael.java.util;

/**
 * 懒汉式单例
 */
import java.util.concurrent.TimeUnit;

public class CalculateUtil2 {
    private CalculateUtil2() {
        System.out.println("++执行构造方法++");
    }
    private static CalculateUtil2 c;

    // 加synchronized锁，该方法只能被一个线程访问
    public static synchronized  CalculateUtil2 getCalculate2() throws InterruptedException {
        if (c==null) {
            TimeUnit.SECONDS.sleep(3);
            c=new CalculateUtil2();
        }
        return c;
    }
}
