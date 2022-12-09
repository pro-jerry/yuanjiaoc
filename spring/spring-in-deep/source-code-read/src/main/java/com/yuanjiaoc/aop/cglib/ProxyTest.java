package com.yuanjiaoc.aop.cglib;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月08日
 */
public class ProxyTest {

    public static void main(String[] args) {
        System.out.println("================ CGLIB动态代理 ================");
        CGLIBProxy cglibProxy = new CGLIBProxy();
        UserServiceImpl cglib = (UserServiceImpl) cglibProxy.newProxy(new UserServiceImpl());
        cglib.addUser("tom", "root");
        System.out.println("================ JDK动态代理 ================");
        JDKProxy jdkProxy = new JDKProxy();
        UserService jdk = (UserService) jdkProxy.newProxy(new UserServiceImpl());
        jdk.addUser("tom", "root");
    }
}
