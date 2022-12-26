package com.yuanjiaoc.aop.dynamicproxy.jdk.demo01;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月26日
 */
public interface IUserService {

    /**
     * 插入用户信息
     *
     * @param name
     */
    void insert(String name);
}
