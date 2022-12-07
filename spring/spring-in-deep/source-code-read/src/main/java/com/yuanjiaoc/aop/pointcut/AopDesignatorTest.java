package com.yuanjiaoc.aop.pointcut;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月07日
 */
@RunWith(SpringRunner.class)
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(value = "com.yuanjiaoc.aop.pointcut")
@SpringBootTest(classes = com.yuanjiaoc.aop.pointcut.AopDesignatorTest.class)
public class AopDesignatorTest {

    @Autowired
    @Qualifier("sweetFruit")
    private SweetFruit sweetFruit;

    @Autowired
    @Qualifier("redApple")
    private RedApple redApple;

    @Autowired
    @Qualifier("redApple")
    private Fruit rFruit;

    @Autowired
    @Qualifier("sweetFruit")
    private Fruit sFruit;

    @Autowired
    private FruitFarmer fruitFarmer;


    @Test
    public void test_annotation() {
        System.out.println("-------------FruitFarmer------------------");
        fruitFarmer.print();
        fruitFarmer.worker();
    }

    @Test
    public void test_args() {
        System.out.println("-------------RedApple--------------------");
        redApple.printPrice(100);
        FruitWeight fruitWeight = new AppleWeight(500);

        redApple.printWeight(fruitWeight);
    }

    @Test
    public void test_within() {
        System.out.println("-------------RedApple--------------------");
        redApple.print();
        redApple.print(11);

        System.out.println("-------------FruitFarmer------------------");
        fruitFarmer.print();
    }

    @Test
    public void test_Target() {
        System.out.println("-------------RedApple--------------------");
        redApple.print();

        System.out.println("-------------FruitFarmer------------------");
        fruitFarmer.print();
    }

    @Test
    public void testArgs() {
        System.out.println("-------------RedApple--------------------");
        redApple.printPrice();
        redApple.printPrice(10);
        redApple.printPrice(1000, "这个苹果价格很贵");
    }


    @Test
    public void testTarget() {
        System.out.println("-------------SweetFruit------------------");
        sweetFruit.print();

        System.out.println("-------------RedApple--------------------");
        redApple.print();
        redApple.printOrigin();
    }

    @Test
    public void testThis() {
        System.out.println("-------------SweetFruit------------------");
        sweetFruit.print();

        System.out.println("-------------RedApple--------------------");
        redApple.print();
        redApple.printOrigin();

        System.out.println("-------------FruitFarmer------------------");
        fruitFarmer.print();

    }

    @Test
    public void testWithin() {
        System.out.println("-------------Fruit(SweetFruit)-----------");
        sFruit.print();

        System.out.println("-------------Fruit(RedApple)-------------");
        rFruit.print();

        System.out.println("-------------SweetFruit------------------");
        sweetFruit.print();

        System.out.println("-------------RedApple--------------------");
        redApple.print();
        redApple.printOrigin();

        System.out.println("-------------FruitFarmer-----------------");
        fruitFarmer.print();
    }
}
