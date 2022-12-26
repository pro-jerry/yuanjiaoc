package com.yuanjiaoc.aop.staticproxy.demo02;

/**
 * 客户类，一般客户都会去找代理！
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年12月23日
 */
public class Client {

    public static void main(String[] args) {

        //房东要租房
        Landlord landlord = new Landlord();
        //中介帮助房东
        Proxy proxy = new Proxy(landlord);
        //客户找中介
        proxy.rent();
    }
}
