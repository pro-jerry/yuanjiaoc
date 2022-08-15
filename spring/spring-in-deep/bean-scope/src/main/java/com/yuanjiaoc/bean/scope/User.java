package com.yuanjiaoc.bean.scope;

import com.yuanjiaoc.common.domain.City;
import com.yuanjiaoc.common.domain.Company;
import java.util.List;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.Data;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.core.io.Resource;

/**
 * 用户类.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月07日
 */
@Data
public class User implements BeanNameAware {

  private Long id;

  private String name;

  private City city;

  private City[] workCities;

  private List<City> lifeCities;

  private Resource configFileLocation;

  private Company company;

  private Properties context;

  private String contextAsText;

  /** 当前 Bean 的名称 */
  private transient String beanName;

  public static User createUser() {
    User user = new User();
    user.setId(100L);
    user.setName("三省");
    return user;
  }

  @PostConstruct
  public void init() {
    System.out.println("User Bean [" + this.beanName + "] 初始化...");
  }

  @PreDestroy
  public void destroy() {
    System.out.println("User Bean [" + this.beanName + "] 销毁中...");
  }
}
