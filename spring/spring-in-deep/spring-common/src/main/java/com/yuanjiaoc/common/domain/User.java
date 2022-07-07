package com.yuanjiaoc.common.domain;

import java.util.List;
import java.util.Properties;
import lombok.Data;
import org.springframework.core.io.Resource;

/**
 * 用户类.
 *
 * @author 何二白
 * @version 1.0
 * @since 2022年07月07日
 */
@Data
public class User {

  private Long id;

  private String name;

  private City city;

  private City[] workCities;

  private List<City> lifeCities;

  private Resource configFileLocation;

  private Company company;

  private Properties context;

  private String contextAsText;
}
