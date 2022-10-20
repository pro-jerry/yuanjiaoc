package com.yuanjiaoc.sourcecoderead.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月17日
 */
public class MyBeanFactoryAware implements BeanFactoryAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("myBeanFactory=" + beanFactory.getBean("myBeanNameAware").toString());
    }
}
