package com.yuanjiaoc.aop.pointcut;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月07日
 */
@Component
@Aspect
public class AopDesignator {

    /**
     * @Before("within(com.yuanjiaoc.aop.pointcut.Fruit)") public void withinTest(JoinPoint point) {
     * System.out.println("within(com.yuanjiaoc.aop.pointcut.Fruit) - " + point.getSignature()); }
     * @Before("within(com.yuanjiaoc.aop.pointcut.SweetFruit)") public void withinTest1(JoinPoint point) {
     * System.out.println("within(com.yuanjiaoc.aop.pointcut.SweetFruit) - " + point.getSignature()); }
     * @Before("within(com.yuanjiaoc.aop.pointcut.RedApple)") public void withinTest2(JoinPoint point) {
     * System.out.println("within(com.yuanjiaoc.aop.pointcut.RedApple) - " + point.getSignature()); }
     * @Before("within(com.yuanjiaoc.aop.pointcut.FruitFarmer)") public void withinTest3(JoinPoint point) {
     * System.out.println("within(com.yuanjiaoc.aop.pointcut.FruitFarmer) - " + point.getSignature()); }
     **/

    /*
    @Before("this(com.yuanjiaoc.aop.pointcut.Fruit)")
    public void withinTest(JoinPoint point) {
        System.out.println("this(com.yuanjiaoc.aop.pointcut.Fruit) - " + point.getSignature());
    }

    @Before("this(com.yuanjiaoc.aop.pointcut.SweetFruit)")
    public void thisTest1(JoinPoint point) {
        System.out.println("this(com.yuanjiaoc.aop.pointcut.SweetFruit) - " + point.getSignature());
    }

    @Before("this(com.yuanjiaoc.aop.pointcut.RedApple)")
    public void thisTest2(JoinPoint point) {
        System.out.println("this(com.yuanjiaoc.aop.pointcut.RedApple) - " + point.getSignature());
    }

    @Before("this(com.yuanjiaoc.aop.pointcut.Origin)")
    public void thisTest3(JoinPoint point) {
        System.out.println("this(com.yuanjiaoc.aop.pointcut.Origin) - " + point.getSignature());
    }
     */

    /*
    @Before("target(com.yuanjiaoc.aop.pointcut.Fruit)")
    public void targetTest(JoinPoint point) {
        System.out.println("target(com.yuanjiaoc.aop.pointcut.Fruit) - " + point.getSignature());
    }

    @Before("target(com.yuanjiaoc.aop.pointcut.SweetFruit)")
    public void targetTest1(JoinPoint point) {
        System.out.println("target(com.yuanjiaoc.aop.pointcut.SweetFruit) - " + point.getSignature());
    }

    @Before("target(com.yuanjiaoc.aop.pointcut.RedApple)")
    public void targetTest2(JoinPoint point) {
        System.out.println("target(com.yuanjiaoc.aop.pointcut.RedApple) - " + point.getSignature());
    }

    @Before("target(com.yuanjiaoc.aop.pointcut.Origin)")
    public void targetTest3(JoinPoint point) {
        System.out.println("target(com.yuanjiaoc.aop.pointcut.Origin) - " + point.getSignature());
    }
    */
    
    /*
    @Before("within(com.yuanjiaoc.aop.pointcut.*) && args(java.lang.Integer, java.lang.String)")
    public void argsTest(JoinPoint point) {
        System.out.println("args(java.lang.Integer, java.lang.String) - " + point.getSignature());
    }
     */

    /*
    @Before("within(com.yuanjiaoc.aop.pointcut.*) && @target(org.springframework.validation.annotation.Validated)")
    public void _targetTest(JoinPoint point) {
        System.out.println("@target(org.springframework.validation.annotation.Validated) - " + point.getSignature());
    }
     */
    
    /*
    @Before("within(com.yuanjiaoc.aop.pointcut.*) && @within(org.springframework.validation.annotation.Validated)")
    public void _withinTest(JoinPoint point) {
        System.out.println("@within(org.springframework.validation.annotation.Validated) - " + point.getSignature());
    }
     */
    
    /*
    @Before("within(com.yuanjiaoc.aop.pointcut.*) && @args(com.fasterxml.jackson.databind.annotation.JsonDeserialize)")
    public void _argsTest(JoinPoint point) {
        System.out.println(
                "@args(com.fasterxml.jackson.databind.annotation.JsonDeserialize) - " + point.getSignature());
    }
     */
    @Before("within(com.yuanjiaoc.aop.pointcut.*) && @annotation(com.fasterxml.jackson.databind.annotation.JsonSerialize)")
    public void _annotationTest(JoinPoint point) {
        System.out.println(
                "@annotation(com.fasterxml.jackson.databind.annotation.JsonSerialize) - " + point.getSignature());
    }

}
