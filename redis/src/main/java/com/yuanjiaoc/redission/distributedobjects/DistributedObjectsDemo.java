package com.yuanjiaoc.redission.distributedobjects;

import com.yuanjiaoc.redission.common.SomeObject;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.GeoEntry;
import org.redisson.api.GeoUnit;
import org.redisson.api.RAtomicDouble;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RBinaryStream;
import org.redisson.api.RBitSet;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RBucket;
import org.redisson.api.RBuckets;
import org.redisson.api.RGeo;
import org.redisson.api.RHyperLogLog;
import org.redisson.api.RKeys;
import org.redisson.api.RLongAdder;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RTopic;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;
import org.redisson.config.Config;

/**
 * 分布式对象.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月13日
 */
public class DistributedObjectsDemo {

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

  public static void main(String[] args) {
    Config config = new Config();
    config.useSingleServer().setAddress("redis://127.0.0.1:6379");

    RedissonClient redisson = Redisson.create(config);
    RKeys keys = redisson.getKeys();

    Iterable<String> allKeys = keys.getKeys();
    //    allKeys.forEach(x -> System.out.println(x));
    Iterable<String> foundedKeys = keys.getKeysByPattern("uv*");
    //    foundedKeys.forEach(x -> System.out.println(x));
    //    System.out.println(keys.randomKey());
    System.out.println(keys.count());
    redisson.shutdown();
  }

  @Test
  public void testObjectBucket() {

    RBucket<String> bucket = redisson.getBucket("myRBucket");
    bucket.set("1");
    bucket.compareAndSet("1", "3");
    System.out.println(bucket.get());

    RBuckets buckets = redisson.getBuckets();
    Map<String, Object> map = new HashMap<>();
    map.put("myBucket1", "11");
    map.put("myBucket2", "10");
    map.put("myRBucket", "10");
    // 利用Redis的事务特性，同时保存所有的通用对象桶，如果任意一个通用对象桶已经存在则放弃保存其他所有数据。
    buckets.trySet(map);
    // 同时保存全部通用对象桶。
    buckets.set(map);

    System.out.println(bucket.get());
  }

  @Test
  public void testBinaryStream() {
    RBinaryStream stream = redisson.getBinaryStream("anyStream");
    byte[] content = new byte[] {1, 2, 3, 4, 5, 7};
    stream.set(content);
  }

  @Test
  public void testGeospatialBucket() {

    RGeo<String> geo = redisson.getGeo("testGeo");
    geo.add(
        new GeoEntry(13.361389, 38.115556, "Palermo"),
        new GeoEntry(15.087269, 37.502669, "Catania"));
    geo.addAsync(37.618423, 55.751244, "Moscow");
    Double distance = geo.dist("Palermo", "Moscow", GeoUnit.KILOMETERS);
    System.out.println(distance);
  }

  @Test
  public void testBitSet() {
    RBitSet set = redisson.getBitSet("simpleBitset");
    set.set(0, true);
    set.set(1, false);
    //    set.clear(1812);
    System.out.println(set.toString());
  }

  @Test
  public void testAtomicLong() {
    RAtomicLong atomicLong = redisson.getAtomicLong("myAtomicLong");
    atomicLong.set(3);
    atomicLong.incrementAndGet();
    System.out.println(atomicLong.get());
  }

  @Test
  public void testAtomicDouble() {
    RAtomicDouble atomicDouble = redisson.getAtomicDouble("myAtomicDouble");
    atomicDouble.set(2.81);
    atomicDouble.addAndGet(4.11);
    System.out.println(atomicDouble.get());
  }

  @Test
  public void testTopic() {

    new Thread(
            () -> {
              try {
                System.out.println("接收线程....");
                Thread.sleep(1000L);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              RTopic topic = redisson.getTopic("anyTopic");
              topic.addListener(
                  String.class,
                  new MessageListener<String>() {
                    @Override
                    public void onMessage(CharSequence charSequence, String s) {
                      System.out.println("----------------");
                      System.out.println(s);
                    }
                  });
            })
        .start();

    new Thread(
            () -> {
              System.out.println("发送线程....");
              RTopic topic = redisson.getTopic("anyTopic");
              long clientsReceivedMessage = topic.publish("Hello World");
              System.out.println("发送:" + clientsReceivedMessage);
            })
        .start();
  }

  @Test
  public void testBloomFilter() {
    RBloomFilter<SomeObject> bloomFilter = redisson.getBloomFilter("sample");
    // 初始化布隆过滤器，预计统计元素数量为55000000，期望误差率为0.03
    bloomFilter.tryInit(55000000L, 0.03);
    bloomFilter.add(new SomeObject("field1Value", "field2Value"));
    bloomFilter.add(new SomeObject("field5Value", "field8Value"));
    boolean isContains = bloomFilter.contains(new SomeObject("field1Value", "field2Value"));
    System.out.println(isContains);
  }

  @Test
  public void testHyperLogLog() {
    RHyperLogLog<Integer> log = redisson.getHyperLogLog("log");
    log.add(1);
    log.add(2);
    log.add(3);
    System.out.println(log.count());
  }

  @Test
  public void testLongAdder() {
    RLongAdder atomicLong = redisson.getLongAdder("myLongAdder");
    System.out.println(atomicLong.sum());
    atomicLong.add(12);
    atomicLong.increment();
    atomicLong.decrement();
    System.out.println(atomicLong.sum());
  }

  @Test
  public void testRateLimiter() {
    RRateLimiter rateLimiter = redisson.getRateLimiter("myRateLimiter");
    // 初始化
    // 最大流速 = 每1秒钟产生10个令牌
    rateLimiter.trySetRate(RateType.OVERALL, 10, 1, RateIntervalUnit.SECONDS);

    CountDownLatch latch = new CountDownLatch(2);
    rateLimiter.acquire(3);
  }
}
