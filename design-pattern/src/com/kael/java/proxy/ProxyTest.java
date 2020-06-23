package com.kael.java.proxy;

import com.kael.java.proxy.mapper.ApplicationImplProxy;

public class ProxyTest {
    public static void main(String[] args) {
        System.out.println(3<<5);
    }
    public static void test1() {
        ApplicationImplProxy proxy = new ApplicationImplProxy(new ApplicationImpl());
        proxy.insertUser();
    }
}
