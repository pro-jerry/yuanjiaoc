package com.yuanjiaoc.redission.distributedcollections;

import com.yuanjiaoc.redission.common.SomeObject;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * 分布式集合.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月13日
 */
public class DistributedCollectionsDemo {

  private RedissonClient redisson;

  @Before
  public void init() {
    Config config = new Config();
    config.useSingleServer().setAddress("redis://127.0.0.1:6379");

    redisson = Redisson.create(config);
  }

  @After
  public void destory() {
    redisson.shutdown();
  }

  @Test
  public void testMap() throws ExecutionException, InterruptedException {
    RMap<String, SomeObject> map = redisson.getMap("anyMap");
    SomeObject prevObject = map.put("123", new SomeObject());
    SomeObject currentObject = map.putIfAbsent("323", new SomeObject());
    SomeObject obj = map.remove("123");

    map.fastPut("321", new SomeObject());
    map.fastRemove("321");

    map.fastPutAsync("321", new SomeObject());
    map.fastRemoveAsync("321");
  }
}
