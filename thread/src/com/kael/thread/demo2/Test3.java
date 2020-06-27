package com.kael.thread.demo2;

import java.util.concurrent.TimeUnit;

public class Test3 {

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            private int ticket = 100;
            @Override
            public void run() {
                while (true) {
                   try{
                            Thread.sleep(30);
                            if (ticket<0) {
                                break;
                            }
                            ticket--;
                            System.out.println(Thread.currentThread().getName()+":"+ticket);



                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

                }
            }
        };

        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        Thread thread3 = new Thread(r);

        thread1.start();
        thread2.start();
        thread3.start();
    }


}
