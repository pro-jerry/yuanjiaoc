package com.yuanjiaoc.pattern.decorator.battercake.v1;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
public class BattercakeTest {
  public static void main(String[] args) {
    Battercake battercake = new Battercake();
    System.out.println(battercake.getMsg() + ",总价格：" + battercake.getPrice());

    Battercake battercakeWithEgg = new BattercakeWithEgg();
    System.out.println(battercakeWithEgg.getMsg() + ",总价格：" + battercakeWithEgg.getPrice());

    Battercake battercakeWithEggAndSausage = new BattercakeWithEggAndSausage();
    System.out.println(
        battercakeWithEggAndSausage.getMsg() + ",总价格：" + battercakeWithEggAndSausage.getPrice());
  }
}
