package com.yuanjiaoc.pattern.template.course;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月19日
 */
public class BigDataCourse extends NetworkCourse {

  private boolean needHomeworkFlag = false;

  public BigDataCourse(boolean needHomeworkFlag) {
    this.needHomeworkFlag = needHomeworkFlag;
  }

  @Override
  void checkHomework() {
    System.out.println("检查大数据的课后作业");
  }

  @Override
  protected boolean needHomework() {
    return this.needHomeworkFlag;
  }
}
