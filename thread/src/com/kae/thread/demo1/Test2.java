package com.kae.thread.demo1;

import java.util.concurrent.TimeUnit;

/**
 * synchronized关键字锁住同步代码块
 */
public class Test2 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            int surplusTicket=100;
            @Override
            public void run() {
                while (true) {

                    // 该代码块只能被一条线程执行。
                   synchronized (this) {
                       if (surplusTicket>0) {
                           try {
                               TimeUnit.MILLISECONDS.sleep(50);
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                           surplusTicket= surplusTicket - 1;
                           System.out.println(Thread.currentThread().getName()+":买票剩:"+surplusTicket);
                       } else {
                           break;
                       }
                   }


                }
            }
        };
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}
