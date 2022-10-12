package com.yuanjiaoc.bean;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月07日
 */
public class SupplierBean {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(User.class);
        beanDefinition.setInstanceSupplier(SupplierBean::createUser);
        context.registerBeanDefinition(User.class.getSimpleName(), beanDefinition);
        context.refresh();
        System.out.println(context.getBean(User.class).getName());
    }

    private static User createUser() {
        return new User("yuanjiaoc");
    }

    static class User {

        private final String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @PostConstruct
        public void init() {
            System.out.println("user 初始化.....");
        }
    }
}
