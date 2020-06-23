package com.kael.java.factory.mobile;

import com.kael.java.entity.HuaWei;
import com.kael.java.entity.Mobile;
import com.kael.java.entity.XiaoMi;

/**
 * 改进的工厂模式
 * 还是有缺点，就是每次有新产品都要修改工厂
 */

public class MobileFactory2 {
    public Mobile createXiami() {
        return new XiaoMi();
    }

    public Mobile createHuawei() {
        return new HuaWei();
    }
}
