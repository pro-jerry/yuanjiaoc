package com.yuanjiaoc.controller;

import com.yuanjiaoc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月22日
 */
@Controller
public class PersonController {

  @Autowired private PersonService personService;
}
