package com.yuanjiaoc.annotation;

import java.lang.reflect.Method;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月27日
 */
public class UserFactory {

    public static User create() {
        User user = new User();
        Method[] methods = User.class.getMethods();

        try {
            for (Method method : methods) {
                if (method.isAnnotationPresent(Init.class)) {
                    Init init = method.getAnnotation(Init.class);
                    method.invoke(user, init.value());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return user;
    }

    public static void main(String[] args) {
        User user = UserFactory.create();
        user.setAge("30");
        System.out.println(user.getName());
        System.out.println(user.getAge());
    }
}
