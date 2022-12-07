package com.yuanjiaoc.aop.example01;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月07日
 */
@Aspect
@Component
public class BuyAspectJ {

    @Before("execution(* com.yuanjiaoc.aop.example01.IBuy.buy(..)) && bean(girl)")
    public void haha() {
        System.out.println("男孩女孩都买自己喜欢的东西");
    }
}
