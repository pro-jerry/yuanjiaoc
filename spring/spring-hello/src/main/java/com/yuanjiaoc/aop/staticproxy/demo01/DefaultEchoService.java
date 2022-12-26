package com.yuanjiaoc.aop.staticproxy.demo01;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月23日
 */
public class DefaultEchoService implements EchoService {

    @Override
    public String echo(String message) {
        return "[ECHO] " + message;
    }
}
