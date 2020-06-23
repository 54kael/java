package com.kael.java.proxy.mapper;

public class ApplicationImplProxy implements ApplicationMapper{
    private ApplicationMapper applicationMapper;

    public ApplicationImplProxy() {
    }

    public ApplicationImplProxy(ApplicationMapper applicationMapper) {
        this.applicationMapper = applicationMapper;
    }

    @Override
    public void insertUser() {
        System.out.println("开启事务");
        applicationMapper.insertUser();
        System.out.println("关闭事务");
    }
}
