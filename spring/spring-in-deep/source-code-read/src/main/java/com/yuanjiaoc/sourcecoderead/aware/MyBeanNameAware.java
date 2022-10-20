package com.yuanjiaoc.sourcecoderead.aware;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月17日
 */
public class MyBeanNameAware implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("beanName=" + name);
    }
}
