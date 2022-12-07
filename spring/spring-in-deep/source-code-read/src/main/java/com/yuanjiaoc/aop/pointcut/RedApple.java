package com.yuanjiaoc.aop.pointcut;

import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月07日
 */
@Component
public class RedApple extends SweetFruit implements Origin {

    @Override
    public void print() {
        System.out.println("好吃的红苹果");
    }

    @Override
    public void printOrigin() {
        System.out.println("浙江产的红苹果");
    }

    public void printPrice() {
        System.out.println("红苹果10块一斤");
    }

    public void printPrice(Integer price) {
        System.out.println("红苹果" + price + "块一斤");
    }

    public void printPrice(Integer price, String mesg) {
        System.out.println("红苹果" + price + "块一斤");
    }


    public void printWeight(FruitWeight weight) {
        System.out.println("这个苹果" + weight.getWeight() + "克");
    }

}
