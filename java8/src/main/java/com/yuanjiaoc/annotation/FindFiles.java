package com.yuanjiaoc.annotation;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月27日
 */
public class FindFiles {

    @Target(METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FileTypes {

        FileType[] value();//对应3
    }

    @Target(METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(FileTypes.class)//对应1、2
    public @interface FileType {

        String value();
    }

    @FileType(".java")
    @FileType(".html")
    @FileType(".css")
    @FileType(".js")
    public void work() {

        try {
            FileType[] fileTypes = this.getClass().getMethod("work").getAnnotationsByType(FileType.class);
            System.out.println("将从如下后缀名的文件中查找文件内容");
            for (FileType fileType : fileTypes) {
                System.out.println(fileType.value());
            }
            System.out.println("查找过程略。。。");
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FindFiles().work();
    }


}
