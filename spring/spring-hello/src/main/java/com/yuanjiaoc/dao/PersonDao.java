package com.yuanjiaoc.dao;

import org.springframework.stereotype.Repository;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月22日
 */
@Repository
public class PersonDao {

  private String remark = "1";

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  @Override
  public String toString() {
    return "PersonDao{" + "remark='" + remark + '\'' + '}';
  }
}
