package com.yuanjiaoc.redission.distributedlocks;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.RedissonMultiLock;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * 分布式锁和同步器.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年08月02日
 */
public class DistributedLocks {

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
  public void testReentrantLock() throws InterruptedException {

    RLock lock = redisson.getLock("anyLock");
    // 加锁以后10秒钟自动解锁
    // 无需调用unlock方法手动解锁
    //    lock.lock(10, TimeUnit.SECONDS);
    // 尝试加锁，最多等待100秒，上锁以后10秒自动解锁
    boolean res = lock.tryLock(100, 30, TimeUnit.SECONDS);
    if (res) {
      try {
        System.out.println(res);
      } finally {
        lock.unlock();
      }
    }
  }

  /**
   * 公平锁（Fair Lock）.
   *
   * @throws InterruptedException
   */
  @Test
  public void testFairLock() throws InterruptedException {
    RLock fairLock = redisson.getFairLock("anyLock01");
    // 尝试加锁，最多等待100秒，上锁以后10秒自动解锁
    boolean res = fairLock.tryLock(100, 10, TimeUnit.SECONDS);
    fairLock.unlock();
  }

  /** 联锁（MultiLock） */
  @Test
  public void testMultiLock() {
    RLock lock1 = redisson.getLock("lock1");
    RedissonMultiLock lock = new RedissonMultiLock(lock1);
    lock.lock();
    lock.unlock();
  }

  /** 红锁（RedLock） */
  @Test
  public void testRedLock() {
    RLock lock1 = redisson.getLock("redlock");
    RedissonRedLock lock = new RedissonRedLock(lock1);
    lock.lock();
    lock.unlock();
  }

  @Test
  public void testReadWriteLock() throws InterruptedException {
    RReadWriteLock rwlock = redisson.getReadWriteLock("anyRWLock");

    // 尝试加锁，最多等待100秒，上锁以后10秒自动解锁
    boolean res = rwlock.readLock().tryLock(50, 10, TimeUnit.SECONDS);
  }
}
