package com.yuanjiaoc.sourcecoderead.beanpostprocessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月22日
 */
@Component
public class HelloServiceTest {

    @RountingInjected(value = "helloServiceImpl2")
    private HelloService helloService;

    public void testSayHello() {
        helloService.sayHello();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                "com.yuanjiaoc.sourcecoderead.beanpostprocessor");
        HelloServiceTest helloServiceTest = applicationContext.getBean(HelloServiceTest.class);
        helloServiceTest.testSayHello();
    }

}
