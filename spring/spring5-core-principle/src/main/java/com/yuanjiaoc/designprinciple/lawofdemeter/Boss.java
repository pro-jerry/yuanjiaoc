package com.yuanjiaoc.designprinciple.lawofdemeter;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class Boss {

  //  public void commandCheckNumber(TeamLeader teamLeader) {
  //    // 模拟Boss一页一页往下翻页，TeamLeader实时统计
  //    List<Course> courseList = new ArrayList<Course>();
  //    for (int i = 0; i < 20; i++) {
  //      courseList.add(new Course());
  //    }
  //    teamLeader.checkNumberOfCourses(courseList);
  //  }
  public void commandCheckNumber(TeamLeader teamLeader) {
    teamLeader.checkNumberOfCourses();
  }
}
