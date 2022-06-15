package com.yuanjiaoc.designprinciple.openclose;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Java 架构课程.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
@Data
@AllArgsConstructor
public class JavaCourse implements ICourse {

  private Integer id;
  private String name;
  private Double price;
}
