package com.yuanjiaoc.config;

import com.yuanjiaoc.bean.Department;
import com.yuanjiaoc.bean.Employee;
import com.yuanjiaoc.bean.Person;
import com.yuanjiaoc.bean.PersonFactoryBean;
import com.yuanjiaoc.condition.LinuxCondition;
import com.yuanjiaoc.condition.WindowsCondition;
import com.yuanjiaoc.selector.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月22日
 */
@Configuration
@Import({Department.class, Employee.class, MyImportSelector.class})
public class PersonConfig2 {

  @Lazy
  @Bean("person")
  //  @Scope("prototype")
  public Person person() {
    System.out.println("给容器中添加Person....");
    return new Person("yuan000", 21);
  }

  @Conditional({WindowsCondition.class})
  @Bean("yuan001")
  public Person person01() {
    return new Person("yuan001", 18);
  }

  @Conditional({LinuxCondition.class})
  @Bean("yuan002")
  public Person person02() {
    return new Person("yuan002", 20);
  }

  @Bean
  public PersonFactoryBean personFactoryBean() {
    return new PersonFactoryBean();
  }
}
