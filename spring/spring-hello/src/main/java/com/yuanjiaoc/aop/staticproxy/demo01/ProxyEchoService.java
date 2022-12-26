package com.yuanjiaoc.aop.staticproxy.demo01;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月23日
 */
public class ProxyEchoService implements EchoService {

    /**
     * 被代理对象
     */
    private final EchoService echoService;

    public ProxyEchoService(EchoService echoService) {
        this.echoService = echoService;
    }

    @Override
    public String echo(String message) {
        long startTime = System.currentTimeMillis();
        // 调用被代理对象的方法
        String result = echoService.echo(message);
        long costTime = System.currentTimeMillis() - startTime;
        System.out.println("echo 方法执行的实现：" + costTime + " ms.");
        return result;
    }
}
