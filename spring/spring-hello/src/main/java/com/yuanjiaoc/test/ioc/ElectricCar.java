package com.yuanjiaoc.test.ioc;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月10日
 */
public class ElectricCar extends Car {

    private Engine engine;

    public ElectricCar() {
        super(new ElectricEngine());
    }

}
