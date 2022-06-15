package com.yuanjiaoc.designprinciple.interfacegregation.gregation;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class Bird implements IEatAnimal, IFlyAnimal {

  @Override
  public void eat() {}

  @Override
  public void fly() {}
}
