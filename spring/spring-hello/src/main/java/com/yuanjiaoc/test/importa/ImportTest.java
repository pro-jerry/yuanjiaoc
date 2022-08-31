package com.yuanjiaoc.test.importa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年08月31日
 */
public class ImportTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(NorMal.class);
        ac.start();
        NorMal normal = ac.getBean(NorMal.class);
        System.out.println(normal != null);
    }
}
