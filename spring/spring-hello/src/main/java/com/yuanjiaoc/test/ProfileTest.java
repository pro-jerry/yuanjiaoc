package com.yuanjiaoc.test;

import com.yuanjiaoc.config.ProfileConfig;
import java.util.stream.Stream;
import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月27日
 */
public class ProfileTest {

  @Test
  public void testProfile01() {
    // 创建IOC容器
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(ProfileConfig.class);
    String[] names = context.getBeanNamesForType(DataSource.class);
    Stream.of(names).forEach(System.out::println);
  }

  @Test
  public void testProfile02() {
    // 创建IOC容器
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.getEnvironment().setActiveProfiles("prod");
    context.register(ProfileConfig.class);
    context.refresh();
    String[] names = context.getBeanNamesForType(DataSource.class);
    Stream.of(names).forEach(System.out::println);
  }
}
