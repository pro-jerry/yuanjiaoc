package com.yuanjiaoc.aop.enableaspectjautoproxy;

import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月28日
 */
@Component
public class Service4 {

    public String say(String name) {
        return "你好：" + name;
    }
}
