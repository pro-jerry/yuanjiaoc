package com.yuanjiaoc.aop.staticproxy.demo02;

/**
 * 真实角色: 房东，房东要出租房子.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年12月23日
 */
public class Landlord implements Rent {

    @Override
    public void rent() {
        System.out.println("房屋出租");
    }
}
