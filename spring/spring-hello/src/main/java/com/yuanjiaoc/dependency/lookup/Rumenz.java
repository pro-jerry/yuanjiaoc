package com.yuanjiaoc.dependency.lookup;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月11日
 */
public class Rumenz extends SuperRumenz {

  private Integer id;
  private String name;

  @Override
  public String toString() {
    return "Rumenz{" + "id=" + id + ", name='" + name + '\'' + "} " + super.toString();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
