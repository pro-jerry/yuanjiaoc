package com.yuanjiaoc.sourcecoderead.propertyvalue;

import com.yuanjiaoc.sourcecoderead.Person;
import com.yuanjiaoc.sourcecoderead.aware.MyBeanNameAware;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月12日
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PropertyConfig.class)
public class PropertyValueTest {

    @Autowired
    private PropertyConfig propertyConfig;

    @Resource
    private PropertyValue propertyValue;

    @Test
    public void testPopulateBean() {
        System.out.println(propertyValue);
        System.out.println(propertyConfig);
    }

    @Test
    public void testMyBeanNameAware() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropertyConfig.class);
        printBeans(context);
        MyBeanNameAware myBeanNameAware = (MyBeanNameAware) context.getBean("myBeanNameAware");
        System.out.println(myBeanNameAware);
    }


    /**
     * <p>测试属性注入</p>
     * <p>AbstractAutowireCapableBeanFactory#autowireByName</p>
     */
    @Test
    public void testXmlBean() {

        BeanFactory beanFactory =
                new ClassPathXmlApplicationContext("classpath:application-person.xml");
        Person person = beanFactory.getBean("person", Person.class);
        System.out.println(person.getName());

    }

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
