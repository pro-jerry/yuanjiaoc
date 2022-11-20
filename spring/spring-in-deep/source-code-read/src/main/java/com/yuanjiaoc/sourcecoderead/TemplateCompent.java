package com.yuanjiaoc.sourcecoderead;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月19日
 */
public class TemplateCompent {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class
        context.register(TemplateCompent.class);
        // 启动 Spring 应用上下文
        context.refresh();

        context.close();
    }
}
