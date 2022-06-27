package com.yuanjiaoc.service;

import com.yuanjiaoc.dao.PersonDao;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月22日
 */
@Service
public class PersonService {

  //  @Qualifier("personDao")
  //  @Autowired(required = false)
  //  @Resource(name = "personDao")
  @Inject private PersonDao personDao;

  @Override
  public String toString() {
    return "PersonService{" + "personDao=" + personDao + '}';
  }
}
