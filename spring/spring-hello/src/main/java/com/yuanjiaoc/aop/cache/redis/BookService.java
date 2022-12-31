package com.yuanjiaoc.aop.cache.redis;

import java.util.Arrays;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月31日
 */
@Component
public class BookService {

    @Cacheable(cacheNames = "cache1", key = "#root.targetClass.name+'-'+#root.method.name")
    public List<String> list() {
        System.out.println("---模拟从db中获取数据---");
        return Arrays.asList("java高并发", "springboot", "springcloud");
    }
}
