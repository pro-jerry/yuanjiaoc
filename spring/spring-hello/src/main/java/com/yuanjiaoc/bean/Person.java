package com.yuanjiaoc.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月22日
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

  private static final long serialVersionUID = 7387479910468805194L;
  private String name;
  private Integer age;
}
