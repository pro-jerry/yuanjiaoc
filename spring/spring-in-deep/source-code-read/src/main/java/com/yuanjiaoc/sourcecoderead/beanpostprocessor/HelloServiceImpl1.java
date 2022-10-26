package com.yuanjiaoc.sourcecoderead.beanpostprocessor;

import org.springframework.stereotype.Service;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月22日
 */
@Service
public class HelloServiceImpl1 implements HelloService {

    @Override
    public void sayHello() {
        System.out.println("你好我是HelloServiceImpl1");
    }
}
