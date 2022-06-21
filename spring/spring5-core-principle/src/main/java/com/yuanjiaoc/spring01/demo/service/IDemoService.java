package com.yuanjiaoc.spring01.demo.service;

import com.yuanjiaoc.spring01.mvcframework.annotation.GPService;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月20日
 */
@GPService
public interface IDemoService {

  String get(String name);
}
