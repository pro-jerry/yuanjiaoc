package com.yuanjiaoc.aop.cache;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年12月31日
 */
@Component
@CacheConfig(cacheNames = "cache1")
public class ArticleService {

    Map<Long, String> articleMap = new HashMap<>();

    @Cacheable(cacheNames = {"cache1"})
    public List<String> list() {
        System.out.println("获取文章列表!");
        return Arrays.asList("spring", "mysql", "java高并发", "maven");
    }

    @Cacheable(cacheNames = {"cache1"}, key = "#root.target.class.name+'-'+#page+'-'+#pageSize")
    public String getPage(int page, int pageSize) {
        String msg = String.format("page-%s-pageSize-%s", page, pageSize);
        System.out.println("从db中获取数据：" + msg);
        return msg;
    }

    /**
     * 通过文章id获取文章
     *
     * @param id    文章id
     * @param cache 是否尝试从缓存中获取
     * @return
     */
    @Cacheable(cacheNames = "cache1", key = "'getById'+#id", condition = "#cache")
    public String getById(Long id, boolean cache) {
        System.out.println("获取数据!");
        return "spring缓存:" + UUID.randomUUID();
    }

    /**
     * 获取文章，先从缓存中获取，如果获取的结果为空，不要将结果放在缓存中
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "cache1", key = "'findById'+#id", unless = "#result==null")
    public String findById(Long id) {
        this.articleMap.put(1L, "spring系列");
        System.out.println("----获取文章:" + id);
        return articleMap.get(id);
    }

    @CachePut(cacheNames = "cache1", key = "'findById'+#id")
    public String add(Long id, String content) {
        System.out.println("新增文章:" + id);
        this.articleMap.put(id, content);
        return content;
    }

    @CacheEvict(cacheNames = "cache1", key = "'findById'+#id") //@1
    public void delete(Long id) {
        System.out.println("删除文章：" + id);
        this.articleMap.remove(id);
    }
}
