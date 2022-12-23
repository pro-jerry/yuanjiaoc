package com.yuanjiaoc.config;

import com.yuanjiaoc.aspect.LogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 测试AOP.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月27日
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
