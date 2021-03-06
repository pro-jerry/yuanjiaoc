package com.yuanjiaoc.pattern.template.entity;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月19日
 */
public class Member {

  private String username;
  private String password;
  private String nickName;

  private int age;
  private String addr;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }
}
