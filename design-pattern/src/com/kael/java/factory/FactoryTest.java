package com.kael.java.factory;

import com.kael.java.entity.Mobile;
import com.kael.java.entity.XiaoMi;
import com.kael.java.factory.mobile.*;

public class FactoryTest {
    public static void main(String[] args) {
        test3();
    }

    public static void test1() {
        MobileFactory factory = new MobileFactory();
        Mobile mobile = factory.createMobile("Xiaomi");
        mobile.call();
    }

    public static void test2() {
        MobileFactory2 factory2 = new MobileFactory2();
        Mobile mobile = factory2.createHuawei();
        mobile.call();
        Mobile mobile1 = factory2.createXiami();
        mobile1.call();
    }

    public static void test3() {
        Factory factory = new HuaWeiFactory();
        Mobile mobile = factory.createMobile();
        mobile.call();
        Factory factory1 = new XiaoMiFactory();
        Mobile mobile1 = factory1.createMobile();
        mobile1.call();
    }
}
