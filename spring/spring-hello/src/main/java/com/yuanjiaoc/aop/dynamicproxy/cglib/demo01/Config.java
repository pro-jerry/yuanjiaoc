package com.yuanjiaoc.aop.dynamicproxy.cglib.demo01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月26日
 */
@Configuration
public class Config {


    @Bean
    public C1 c1() {
        return new C1();
    }

    @Bean
    public C2 c2() {
        C1 c1 = this.c1(); //@1
        return new C2(c1);
    }

    @Bean
    public C3 c3() {
        C1 c1 = this.c1(); //@2
        return new C3(c1);
    }

    public static class C1 {

    }

    public static class C2 {

        private final C1 c1;

        public C2(C1 c1) {
            this.c1 = c1;
        }
    }

    public static class C3 {

        private final C1 c1;

        public C3(C1 c1) {
            this.c1 = c1;
        }
    }
}
