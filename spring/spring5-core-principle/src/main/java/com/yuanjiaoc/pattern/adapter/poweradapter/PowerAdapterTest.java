package com.yuanjiaoc.pattern.adapter.poweradapter;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
public class PowerAdapterTest {

  public static void main(String[] args) {
    DC5 dc5 = new PowerAdapter(new AC220());
    dc5.outoupDC5V();
  }
}
