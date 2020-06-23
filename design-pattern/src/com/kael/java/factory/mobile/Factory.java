package com.kael.java.factory.mobile;

import com.kael.java.entity.Mobile;

/**
 * 抽象工厂，专门生产手机，其他手机工厂实现它
 */
public interface Factory {
    Mobile createMobile();
}
