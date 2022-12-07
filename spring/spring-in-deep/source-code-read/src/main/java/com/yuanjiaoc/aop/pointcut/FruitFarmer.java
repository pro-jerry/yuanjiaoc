package com.yuanjiaoc.aop.pointcut;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月07日
 */
@Component
public class FruitFarmer {

    @JsonSerialize
    public void print() {
        System.out.println("种水果的农民");
    }

    @JsonSerialize
    public void worker() {
        System.out.println("果农在劳动");
    }
}
