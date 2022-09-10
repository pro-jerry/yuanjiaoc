package com.yuanjiaoc.test.ioc;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月10日
 */
public class Car {

    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.turnOn();
    }

    public static void main(String[] args) {
        CombustionCar combustionCar = new CombustionCar();
        combustionCar.start();

        ElectricCar electricCar = new ElectricCar();
        electricCar.start();
    }
}
