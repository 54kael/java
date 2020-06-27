package com.kae.thread.demo1;
import java.util.concurrent.TimeUnit;

/**
 * 线程没加锁，共享数据会出现异常
 */
public class Test1 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            int surplusTicket=100;
            @Override
            public void run() {
                while (true) {

                    // 余票大于0时继续买票(当三条线程的余票都为1时，都会进入这里，造成余票负数)
                    if (surplusTicket>0) {

                        // 模拟线程进来后处理一堆复杂业务。
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
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
        };
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}
