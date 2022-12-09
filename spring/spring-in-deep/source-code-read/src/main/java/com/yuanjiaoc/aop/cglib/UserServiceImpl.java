package com.yuanjiaoc.aop.cglib;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月08日
 */
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(String username, String password) {
        System.out.println("调用了 UserServiceImpl 类的 addUser() 方法");
    }
}
