package com.yuanjiaoc.aop.enableaspectjautoproxy;

import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月28日
 */
@Component
public class UserService {

    public void say() {
        System.out.println("我是UserService");
    }
}
