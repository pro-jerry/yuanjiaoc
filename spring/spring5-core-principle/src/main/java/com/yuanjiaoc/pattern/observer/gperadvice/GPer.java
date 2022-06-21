package com.yuanjiaoc.pattern.observer.gperadvice;

import java.util.Observable;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
public class GPer extends Observable {
  private final String name = "GPer生态圈";
  private static GPer gper = null;

  private GPer() {}

  public static GPer getInstance() {
    if (null == gper) {
      gper = new GPer();
    }
    return gper;
  }

  public String getName() {
    return name;
  }

  public void publishQuestion(Question question) {
    System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题。");
    setChanged();
    notifyObservers(question);
  }
}
