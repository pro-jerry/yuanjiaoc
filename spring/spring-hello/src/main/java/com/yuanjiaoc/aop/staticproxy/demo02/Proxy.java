package com.yuanjiaoc.aop.staticproxy.demo02;

/**
 * 代理角色：中介.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年12月23日
 */
public class Proxy implements Rent {

    private Landlord landlord;

    public Proxy() {
    }

    public Proxy(Landlord landlord) {
        this.landlord = landlord;
    }

    //租房
    public void rent() {
        seeHouse();
        landlord.rent();
        fare();
    }

    //看房
    public void seeHouse() {
        System.out.println("带房客看房");
    }

    //收中介费
    public void fare() {
        System.out.println("收中介费");
    }

}
