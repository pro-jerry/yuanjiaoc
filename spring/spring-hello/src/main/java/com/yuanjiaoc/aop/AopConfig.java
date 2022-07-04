package com.yuanjiaoc.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月04日
 */
@Configuration
@ComponentScan(basePackages = "com.yuanjiaoc.aop")
// 开启AOP支持
// 该注解中会使用Import注解导入后置处理器及注册自定义Bean用来完成AOP功能
@EnableAspectJAutoProxy
public class AopConfig {

}
