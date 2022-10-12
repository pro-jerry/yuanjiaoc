package com.yuanjiaoc.sourcecoderead;

import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月08日
 */
public class SourceReadTest {

    @Resource
    private ApplicationContext applicationContext;

    @Test
    public void testComponentScan() {
        applicationContext = new AnnotationConfigApplicationContext("com.yuanjiaoc.sourcecoderead");
        BeanClass beanClass = (BeanClass) applicationContext.getBean("beanClass");
        BeanDefinitionTest beanDefinitionTest = (BeanDefinitionTest) applicationContext.getBean("beanDefinitionTest");
        System.out.println("BeanClass-->" + beanClass.getUsername());
        System.out.println("BeanDefinitionTest-->" + beanDefinitionTest.getClass());

    }


    @Test
    public void testXmlBean() {

        BeanFactory beanFactory =
                new ClassPathXmlApplicationContext("classpath:application-person.xml");
        Person person = beanFactory.getBean("person", Person.class);
        System.out.println(person.getName());

    }

    public static void main(String[] args) throws NoSuchMethodException {

        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory =
                new ClassPathXmlApplicationContext("classpath:application-person.xml");
        Person person = beanFactory.getBean("person", Person.class);
        System.out.println(person.getName());
    }


}
