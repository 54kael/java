package com.kael.java.proxy;

import com.kael.java.proxy.mapper.ApplicationMapper;

public class ApplicationImpl implements ApplicationMapper {
    @Override
    public void insertUser() {
        System.out.println("执行插入操作==========");
    }
}
