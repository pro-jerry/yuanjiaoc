package com.yuanjiaoc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月27日
 */
@Profile("dev")
@Configuration
public class ProfileConfig {

  @Profile("default")
  @Bean("devDataSource")
  public DataSource dataSourceDev() throws Exception {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test_dev");
    dataSource.setUser("root");
    dataSource.setPassword("root");
    dataSource.setDriverClass("com.mysql.jdbc.Driver");
    return dataSource;
  }

  @Profile("test")
  @Bean("testDataSource")
  public DataSource dataSourceTest() throws Exception {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test_test");
    dataSource.setUser("root");
    dataSource.setPassword("root");
    dataSource.setDriverClass("com.mysql.jdbc.Driver");
    return dataSource;
  }

  @Profile("prod")
  @Bean("prodDataDource")
  public DataSource dataSourceProd() throws Exception {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test_prod");
    dataSource.setUser("root");
    dataSource.setPassword("root");
    dataSource.setDriverClass("com.mysql.jdbc.Driver");
    return dataSource;
  }
}
