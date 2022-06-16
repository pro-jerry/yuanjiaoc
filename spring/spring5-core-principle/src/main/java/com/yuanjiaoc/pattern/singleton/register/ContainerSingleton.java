package com.yuanjiaoc.pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Spring中的做法，就是用这种注册式单例.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月16日
 */
public class ContainerSingleton {
  private ContainerSingleton() {}

  private static final Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

  public static Object getInstance(String className) {
    synchronized (ioc) {
      if (!ioc.containsKey(className)) {
        Object obj = null;
        try {
          obj = Class.forName(className).newInstance();
          ioc.put(className, obj);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return obj;
      } else {
        return ioc.get(className);
      }
    }
  }
}
