package com.yuanjiaoc.designprinciple.compositereuse;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class OracleConnection extends DBConnection {

  @Override
  public String getConnection() {
    return "Oracle数据库连接";
  }
}
