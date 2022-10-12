package com.yuanjiaoc.sourcecoderead.propertyvalue;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月12日
 */
public class PropertyValueTest {

    @Test
    public void testPropertyValue() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropertyConfig.class);
        printBeans(context);
        PropertyValue propertyValue = (PropertyValue) context.getBean("propertyValue");
        System.out.println(propertyValue);//PropertyValue{name='feiyue', age=25, city='Beijing'}
        //使用
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("prop.city");
        System.out.println("prop.city=" + property);//Beijing

        context.close();
    }

    private void printBeans(AnnotationConfigApplicationContext context) {
        //根据类型获取bean的id
        System.out.println("IOC容器所有的bean...");
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println("bean名称:" + name);
        }
    }
}
