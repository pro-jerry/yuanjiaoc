package com.yuanjiaoc.designprinciple.compositereuse;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class ProductDao {

  private DBConnection dbConnection;

  public void setDbConnection(DBConnection dbConnection) {
    this.dbConnection = dbConnection;
  }

  public DBConnection getDbConnection() {
    return dbConnection;
  }

  public void addProduct() {
    String conn = dbConnection.getConnection();
    System.out.println("使用" + conn + "增加产品");
  }
}
