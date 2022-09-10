package com.yuanjiaoc.test.ioc;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月10日
 */
public class CombustionCar extends Car {

    private Engine engine;

    public CombustionCar() {
        super(new CombustionEngine());
    }
}
