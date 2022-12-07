package com.yuanjiaoc.aop.example01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月07日
 */
@Configuration
@ComponentScan(basePackages = "com.yuanjiaoc.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
