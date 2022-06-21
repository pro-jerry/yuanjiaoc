package com.yuanjiaoc.pattern.observer.gperadvice;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
public class ObserverTest {

  public static void main(String[] args) {
    GPer gper = GPer.getInstance();
    Teacher tom = new Teacher("Tom");
    Teacher mic = new Teacher("Mic");

    // 这为没有@Tom老师
    Question question = new Question();
    question.setUserName("小明");
    question.setContent("观察者设计模式适用于哪些场景？");
    gper.addObserver(tom);
    gper.addObserver(mic);
    gper.publishQuestion(question);
  }
}
