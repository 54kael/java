package com.kael.java.factory.mobile;

import com.kael.java.entity.HuaWei;
import com.kael.java.entity.Mobile;
import com.kael.java.entity.XiaoMi;

/**
 * 简单工厂模式
 * 传进来什么，就返回什么
 * 传字符串容易出错，不推荐
 */
public class MobileFactory {
    public Mobile createMobile(String model) {
        if ("Xiaomi".equals(model)) {
            return new XiaoMi();
        } else if ("HuaWei".equals(model)){
            return new HuaWei();
        } else {
            return null;
        }
    }
}
