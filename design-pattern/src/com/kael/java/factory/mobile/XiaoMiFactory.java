package com.kael.java.factory.mobile;

import com.kael.java.entity.Mobile;
import com.kael.java.entity.XiaoMi;

public class XiaoMiFactory implements Factory{
    @Override
    public Mobile createMobile() {
        return new XiaoMi();
    }
}
