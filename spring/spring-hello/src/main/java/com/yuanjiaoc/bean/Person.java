package com.yuanjiaoc.bean;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

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

  @Value("mina")
  private String name;

  @Value("#{20-2}")
  private Integer age;

  @Value("${person.nickName}")
  private String nickName;
}
