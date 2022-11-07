package com.yuanjiaoc.sourcecoderead.autowire;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月03日
 */
//@Component
public class MyBeanPost implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.printf("-----执行postProcessBeforeInitialization-------bean%s \n", bean);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("-----执行postProcessAfterInitialization-------");
        return null;
    }
}
