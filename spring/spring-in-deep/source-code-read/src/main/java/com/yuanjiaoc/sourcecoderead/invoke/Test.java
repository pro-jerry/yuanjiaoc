package com.yuanjiaoc.sourcecoderead.invoke;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年10月26日
 */
public class Test {

    @org.junit.Test
    public void test01() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String className = "com.yuanjiaoc.sourcecoderead.invoke.Person";
        Class clazz = Class.forName(className);
        Object obj = clazz.newInstance();
        Person person = (Person) obj;
        System.out.println(person);
    }

    @org.junit.Test
    public void test02() throws ClassNotFoundException {
        String className = "com.yuanjiaoc.sourcecoderead.invoke.Person";
        Class clazz = Class.forName(className);

        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }

    @org.junit.Test
    public void test03() throws Exception {
        String className = "com.yuanjiaoc.sourcecoderead.invoke.Person";
        Class clazz = Class.forName(className);

        Constructor constructor = clazz.getDeclaredConstructor(int.class, String.class);
        constructor.setAccessible(true);
        Person person = (Person) constructor.newInstance(12, "mina");
        System.out.println(person);

    }

    @org.junit.Test
    public void test04() throws Exception {
        Class clazz = Person.class;
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        Field[] field1s = clazz.getDeclaredFields();
        for (Field field : field1s) {
            System.out.println(field);
        }
    }

    @org.junit.Test
    public void test05() throws Exception {
        Class clazz = Person.class;
        Field[] field1s = clazz.getDeclaredFields();
        for (Field field : field1s) {

            //获取属性权限修饰符
            int i = field.getModifiers();
            String str1 = Modifier.toString(i);
            System.out.println("权限修饰符:" + str1);

            //获取属性的类型
            Class type = field.getType();
            System.out.println("属性类型:" + type);

            String fieldName = field.getName();
            System.out.println("属性名:" + fieldName);
        }
    }

    @org.junit.Test
    public void test06() throws Exception {
        Class clazz = Person.class;
        Field name = clazz.getDeclaredField("name");

        Person p = (Person) clazz.newInstance();
        System.out.println(p);

        name.setAccessible(true);
        name.set(p, "mima");
        System.out.println(p);

        Field ageField = clazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(p, 12);
        System.out.println(p);

    }

    @org.junit.Test
    public void test07() {
        Class clazz = Person.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("-------------");
        Method[] methods2 = clazz.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println(method);
        }
    }

    @org.junit.Test
    public void test08() {
        Class clazz = Person.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {

            method.setAccessible(true);
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }

            //权限修饰符
            String str = Modifier.toString(method.getModifiers());
//            System.out.println(str);

            //返回值类型
            Class returnType = method.getReturnType();
//            System.out.println(returnType.getName());

            //方法名
//            System.out.println(method.getName());
            //形参列表
            Class[] params = method.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                System.out.println(params[i].getName());
            }
        }
    }

    @org.junit.Test
    public void test09()
            throws Exception {
        Class clazz = Person.class;
        Person p = (Person) clazz.newInstance();

        Method m1 = clazz.getMethod("show");
        Object returnVal = m1.invoke(p);
        System.out.println(returnVal);

        Method m2 = clazz.getMethod("toString");
        Object returnVal1 = m2.invoke(p);
        System.out.println(returnVal1);
    }

    @org.junit.Test
    public void test10() {
        Class clazz = Person.class;
        Class superClass = clazz.getSuperclass();
        System.out.println(superClass);
    }

    @org.junit.Test
    public void test11() {
        Class clazz = Person.class;
        Type type = clazz.getGenericSuperclass();
        System.out.println(type);
    }

    @org.junit.Test
    public void test12() {
        Class clazz = Person.class;
        Class[] interfaces = clazz.getInterfaces();
        for (Class i : interfaces) {
            System.out.println(i);
        }
    }

    @org.junit.Test
    public void test13() {
        Class clazz = Person.class;
        Package apackage = clazz.getPackage();
        System.out.println(apackage);
    }

    @org.junit.Test
    public void test14() {
        Class clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }


}
