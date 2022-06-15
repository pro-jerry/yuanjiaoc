package com.yuanjiaoc.designprinciple.compositereuse;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月15日
 */
public class CompositeReuseTest {

  public static void main(String[] args) {
    ProductDao productDao = new ProductDao();
    productDao.setDbConnection(new OracleConnection());
    System.out.println(productDao.getDbConnection().getConnection());
    productDao.addProduct();
  }
}
