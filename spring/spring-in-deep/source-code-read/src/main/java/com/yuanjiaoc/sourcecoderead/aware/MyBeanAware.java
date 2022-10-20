package com.yuanjiaoc.sourcecoderead.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月20日
 */
public class MyBeanAware implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {

    private ApplicationContext applicationContext;

    // 通过上下文环境对象得到Spring容器中的Bean
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入的IOC：" + applicationContext);
        this.applicationContext = applicationContext;
    }

    // 获取bean的名字
    public void setBeanName(String s) {
        System.out.println("当前bean的名字：" + s);
    }

    // 解析一些字符串、占位符等
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        String resolveStringValue = stringValueResolver.resolveStringValue("你好${os.name}");
        System.out.println("解析的字符串是：" + resolveStringValue);
    }
}
