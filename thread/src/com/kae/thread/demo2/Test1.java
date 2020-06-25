package com.kae.thread.demo2;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) {
        Object obj = new Object();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (obj) {
                    System.out.println("线程1执行中...");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1继续执行...");
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
               synchronized (obj) {
                   System.out.println("线程2启动，用来唤醒线程1");
                   try {
                       TimeUnit.SECONDS.sleep(5);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println("5s后由线程2唤醒线程1");
                   obj.notify();
               }

            }
        };

        t1.start();
        t2.start();
    }
}
