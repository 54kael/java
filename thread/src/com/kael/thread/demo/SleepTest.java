package com.kael.thread.demo;

/**
 * 实现runnable的好处
 * 1.避免单继承的局限性
 * 2.解耦
 */
public class SleepTest {
    public static void main(String[] args) {
        for (int i=0; i<=60; i++) {
           try{
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        }
    }
}
