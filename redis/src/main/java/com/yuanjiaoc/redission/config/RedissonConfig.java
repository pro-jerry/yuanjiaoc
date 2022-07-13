package com.yuanjiaoc.redission.config;

import java.util.concurrent.ExecutionException;
import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RFuture;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月12日
 */
public class RedissonConfig {

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    Config config = new Config();
    config.useSingleServer().setAddress("redis://127.0.0.1:6379");

    RedissonClient client = Redisson.create(config);
    RAtomicLong longObject = client.getAtomicLong("myLong");
    // 同步执行方式
    longObject.compareAndSet(0, 401);
    System.out.println("--同步--" + longObject.get());
    // 异步执行方式
    RFuture<Boolean> future = longObject.compareAndSetAsync(401, 402);
    future.whenComplete(
        (res, exception) -> {
          System.out.println(res.toString());
        });
    client.shutdown();
  }
}
