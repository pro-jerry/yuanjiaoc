package com.yuanjiaoc.java8features;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月29日
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

  private static final long serialVersionUID = -9079722457749166858L;
  private String name;
  private Integer age;
  private Double salary;
}
