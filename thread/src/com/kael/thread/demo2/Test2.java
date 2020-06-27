package com.kael.thread.demo2;

public class Test2 {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            private int ticket = 100;
            final Object object = new Object();
            @Override
            public void run() {
                while (ticket>0) {
                    ticket =  saleTicket(ticket);
                    System.out.println(Thread.currentThread().getName()+":--"+ticket);
                }
            }
        };

        Thread one = new Thread(r1);
        Thread two = new Thread(r1);
        Thread three = new Thread(r1);

        one.start();
        two.start();
        three.start();
    }

    public synchronized static int saleTicket(int ticket) {
        ticket = ticket - 1;
        return ticket;
    }
}
