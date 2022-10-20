package com.yuanjiaoc.sourcecoderead.propertyvalue;

import com.yuanjiaoc.sourcecoderead.aware.MyBeanAware;
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

    @Bean(autowire = Autowire.BY_NAME, initMethod = "initMethod")
    public PropertyValue propertyValue() {
        return new PropertyValue();
    }

    @Bean
    public MyBeanAware myBeanAware() {
        return new MyBeanAware();
    }


}
