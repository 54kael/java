package com.kae.thread.demo1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock重入锁加锁
 */
public class Test3 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Runnable r = new Runnable() {
            int surplusTicket=100;
            @Override
            public void run() {
                while (true) {
                    // 加锁
                    lock.lock();
                    try {
                        if (surplusTicket>0) {
                            // 模拟线程进来后处理一堆复杂业务。
                            TimeUnit.MILLISECONDS.sleep(50);
                            surplusTicket= surplusTicket - 1;
                            System.out.println(Thread.currentThread().getName()+":买票剩:"+surplusTicket);
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        // 解锁
                        lock.unlock();
                    }
                }
            }
        };
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
}
