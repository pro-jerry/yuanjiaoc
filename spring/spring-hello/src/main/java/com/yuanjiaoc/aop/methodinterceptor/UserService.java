package com.yuanjiaoc.aop.methodinterceptor;

import org.springframework.stereotype.Service;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月23日
 */
@Service
public class UserService {

    public void saveUser(String name, String sex) {
        System.out.println("name = " + name + ", sex = " + sex + " id =");
        sayHello(name);
    }

    public void sayHello(String name) {
        System.out.println("Hello name = " + name + " Welcome in Spring Interceptor world");
    }
}
