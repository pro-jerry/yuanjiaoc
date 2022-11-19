package com.yuanjiaoc.sourcecoderead.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月08日
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRegisterPublisherServiceTest {


    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        UserRegisterPublisherService userRegisterPublisherService = (UserRegisterPublisherService) context.getBean(
                "userRegisterPublisherService");

        Person person = new Person();
        person.setId(10000);
        userRegisterPublisherService.insert(person);
    }
}
