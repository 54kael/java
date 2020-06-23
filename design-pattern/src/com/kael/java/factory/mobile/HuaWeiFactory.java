package com.kael.java.factory.mobile;

import com.kael.java.entity.HuaWei;
import com.kael.java.entity.Mobile;

public class HuaWeiFactory implements Factory{
    @Override
    public Mobile createMobile() {
        return new HuaWei();
    }
}
