package com.yuanjiaoc.sourcecoderead.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月17日
 */
public class MyApplicationContextAware implements ApplicationContextAware {

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
        System.out.println("applicationName:" + ctx.getApplicationName());
    }
}
