package com.yuanjiaoc.cloud.gateway;

import java.util.function.Predicate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月11日
 */
@SpringBootApplication
public class SpringcloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudGatewayApplication.class, args);
    }

    /**
     * 读取body断言需要注册bodyPredicate
     *
     * @return
     */
    @Bean
    public Predicate bodyPredicate() {
        return o -> true;
    }
}
