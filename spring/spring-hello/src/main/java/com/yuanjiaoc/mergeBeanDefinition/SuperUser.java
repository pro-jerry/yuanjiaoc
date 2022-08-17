package com.yuanjiaoc.mergeBeanDefinition;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年08月17日
 */
@Data
public class SuperUser implements Serializable {

  private String address;

  public SuperUser(String address) {
    this.address = address;
  }

  public SuperUser() {}
}
