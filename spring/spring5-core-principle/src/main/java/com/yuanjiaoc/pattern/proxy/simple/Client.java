package com.yuanjiaoc.pattern.proxy.simple;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月17日
 */
public class Client {

  public static void main(String[] args) {
    Proxy proxy = new Proxy(new RealSubject());
    proxy.request();
  }
}
