package com.yuanjiaoc.sourcecoderead.propertyvalue;

import com.yuanjiaoc.sourcecoderead.aware.MyApplicationContextAware;
import com.yuanjiaoc.sourcecoderead.aware.MyBeanFactoryAware;
import com.yuanjiaoc.sourcecoderead.aware.MyBeanNameAware;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * <p>使用@PropertySource注解可以加载多个配置文件,value是数组</p>
 * <p>也可以通过PropertySources加载多个PropertySource，@PropertySource是一个可重复注解</p>
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年10月12日
 */
@Configuration
@PropertySource(value = {"classpath:config.properties"})
public class PropertyConfig {

    @Bean(autowire = Autowire.BY_NAME)
    public PropertyValue propertyValue() {
        return new PropertyValue();
    }

    @Bean
    public MyBeanNameAware myBeanNameAware() {
        return new MyBeanNameAware();
    }

    @Bean
    public MyBeanFactoryAware myBeanFactoryAware() {
        return new MyBeanFactoryAware();
    }

    @Bean
    public MyApplicationContextAware myApplicationContextAware() {
        return new MyApplicationContextAware();
    }

}
