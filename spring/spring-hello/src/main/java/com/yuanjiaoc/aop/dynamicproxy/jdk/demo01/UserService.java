package com.yuanjiaoc.aop.dynamicproxy.jdk.demo01;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月26日
 */
public class UserService implements IUserService {

    @Override
    public void insert(String name) {
        System.out.println(String.format("用户[name:%s]插入成功!", name));
    }

    public static void main(String[] args) {
        IUserService userService = CostTimeInvocationHandler.createProxy(new UserService(), IUserService.class);
        userService.insert("路人甲Java");
    }
}
