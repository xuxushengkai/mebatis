package com.sjj.mebatis.v1;

import java.lang.reflect.Proxy;
import java.util.ResourceBundle;

public class SJConfiguration {
    public static final ResourceBundle sqlMappings;

    static {
        sqlMappings = ResourceBundle.getBundle("v1sql");
    }

    public <T> T  getMapper(Class clazz,SJSqlSession sqlSession){
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz}，new SJMapperProxy(sqlSession));
    }
}
