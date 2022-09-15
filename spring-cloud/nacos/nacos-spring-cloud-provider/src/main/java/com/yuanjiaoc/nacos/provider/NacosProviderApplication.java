package com.yuanjiaoc.nacos.provider;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年09月15日
 */
@SpringBootApplication
@EnableFeignClients
public class NacosProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication.class, args);
    }
}
