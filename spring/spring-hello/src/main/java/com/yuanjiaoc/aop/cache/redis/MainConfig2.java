package com.yuanjiaoc.aop.cache.redis;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月31日
 */
@ComponentScan
@EnableCaching //@1
@Configuration
public class MainConfig2 {

    @Bean //@2
    public CacheManager cacheManager() throws IOException {
        RedissonSpringCacheManager cacheManager = new RedissonSpringCacheManager(this.redissonClient());
        cacheManager.setCacheNames(Arrays.asList("cache1"));
        return cacheManager;
    }

    @Bean //@3
    public RedissonClient redissonClient() throws IOException {
        Config config = Config.fromYAML(new File("src/main/resources/redis.yaml"));
        return Redisson.create(config);
    }
}
