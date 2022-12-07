package com.yuanjiaoc.aop.pointcut;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月07日
 */
@JsonDeserialize
public class AppleWeight implements FruitWeight {

    public int weight;

    public AppleWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }
}
