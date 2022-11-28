package com.yuanjiaoc.annotation;

import java.lang.reflect.Field;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月28日
 */
public class GetUser {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class userClass = Class.forName("com.yuanjiaoc.annotation.User1");

        // 读取类上的注解
        Table table = (Table) userClass.getAnnotation(Table.class);
        System.out.println(table.value());

        // 读取属性上注解
        Field userId = userClass.getDeclaredField("userId");
        UserFiled userFiledId = userId.getAnnotation(UserFiled.class);
        System.out.println(userFiledId.length() + "----" + userFiledId.type() + "-----" + userFiledId.name());

        Field userName = userClass.getDeclaredField("userName");
        UserFiled userFiledName = userName.getAnnotation(UserFiled.class);
        System.out.println(userFiledName.length() + "----" + userFiledName.type() + "----" + userFiledName.name());

        Field password = userClass.getDeclaredField("password");
        UserFiled userFiledPassword = password.getAnnotation(UserFiled.class);
        System.out.println(
                userFiledPassword.name() + "-----" + userFiledPassword.type() + "-----" + userFiledPassword.length());

        // 拼接一个sql语句
        String name = "chenwei";
        String sql = " select * from " + table.value() + " where " + userFiledName.name() + " = " + name;
        System.out.println(sql);
    }
}
