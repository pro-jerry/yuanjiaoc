package com.yuanjiaoc.aop.pointcut;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月07日
 */
@Component
@Validated
public class SweetFruit implements Fruit {

    @Override
    public void print() {
        System.out.println("好吃的甜水果");
    }

    public void print(int i) {
        System.out.println("好吃的甜水果" + i);
    }
}
