package com.yuanjiaoc.chapter07;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月01日
 */
public class AtomicReferenceTest {

  public static AtomicReference<User> atomicUserRef = new AtomicReference<User>();

  public static void main(String[] args) {
    User user = new User("conan", 15);
    atomicUserRef.set(user);
    User updateUser = new User("Shinichi", 17);
    atomicUserRef.compareAndSet(user, updateUser);
    System.out.println(atomicUserRef.get().getName());
    System.out.println(atomicUserRef.get().getOld());
  }

  public static class User {
    private final String name;
    private final int old;

    public User(String name, int old) {
      this.name = name;
      this.old = old;
    }

    public String getName() {
      return name;
    }

    public int getOld() {
      return old;
    }
  }
}
