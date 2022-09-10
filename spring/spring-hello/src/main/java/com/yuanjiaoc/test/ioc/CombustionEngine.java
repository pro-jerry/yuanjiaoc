package com.yuanjiaoc.test.ioc;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月10日
 */
public class CombustionEngine implements Engine {

    @Override
    public void turnOn() {
        System.out.println("燃油引擎启动");
    }
}
