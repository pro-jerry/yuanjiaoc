package com.yuanjiaoc.sourcecoderead.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月22日
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


    public MyBeanPostProcessor() {
        System.out.println("MyBeanPostProcessor 实例化......");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("spring中bean实例:" + beanName + " 初始化之前处理......");
        return bean;
    }
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("spring中bean实例:" + beanName + " 初始化之后处理......");
        return bean;
    }

}
