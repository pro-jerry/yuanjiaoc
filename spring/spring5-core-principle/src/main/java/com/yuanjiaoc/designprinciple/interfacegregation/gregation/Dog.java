package com.yuanjiaoc.designprinciple.interfacegregation.gregation;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class Dog implements IEatAnimal, ISwimAnimal {

  @Override
  public void eat() {}

  @Override
  public void swim() {}
}
