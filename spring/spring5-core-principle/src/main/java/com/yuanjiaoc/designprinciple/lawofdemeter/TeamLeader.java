package com.yuanjiaoc.designprinciple.lawofdemeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class TeamLeader {

  //  public void checkNumberOfCourses(List<Course> courseList) {
  //    System.out.println("目前已发布的课程数量是：" + courseList.size());
  //  }
  public void checkNumberOfCourses() {
    List<Course> courseList = new ArrayList<Course>();
    for (int i = 0; i < 20; i++) {
      courseList.add(new Course());
    }
    System.out.println("目前已发布的课程数量是：" + courseList.size());
  }
}
