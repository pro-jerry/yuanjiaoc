package com.yuanjiaoc.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月27日
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        DiskClassLoader diskLoader = new DiskClassLoader(
                "D:\\ideaProject02\\yuanjiaoc\\java8\\target\\classes\\com\\yuanjiaoc\\classloader");
        try {
            //加载class文件
            Class c = diskLoader.loadClass("com.yuanjiaoc.classloader.Test");

            if (c != null) {
                try {
                    Object obj = c.newInstance();
                    Method method = c.getDeclaredMethod("say", null);
                    //通过反射调用Test类的say方法
                    method.invoke(obj, null);
                } catch (InstantiationException | IllegalAccessException
                        | NoSuchMethodException
                        | SecurityException |
                        IllegalArgumentException |
                        InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
