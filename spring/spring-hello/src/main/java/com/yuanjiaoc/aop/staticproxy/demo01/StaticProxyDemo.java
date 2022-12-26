package com.yuanjiaoc.aop.staticproxy.demo01;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月23日
 */
public class StaticProxyDemo {

    public static void main(String[] args) {
        // 创建代理类，并传入被代理对象，也就是 DefaultEchoService
        EchoService echoService = new ProxyEchoService(new DefaultEchoService());
        echoService.echo("Hello,World");
    }
}
