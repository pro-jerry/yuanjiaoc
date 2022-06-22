package com.yuanjiaoc.spring01.demo.mvc.action;

import com.yuanjiaoc.spring01.demo.service.IDemoService;
import com.yuanjiaoc.spring01.mvcframework.annotation.GPAutowired;
import com.yuanjiaoc.spring01.mvcframework.annotation.GPController;
import com.yuanjiaoc.spring01.mvcframework.annotation.GPRequestMapping;
import com.yuanjiaoc.spring01.mvcframework.annotation.GPRequestParam;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月21日
 */
@GPController
@GPRequestMapping("/demo")
public class DemoAction {

  @GPAutowired private IDemoService demoService;

  @GPRequestMapping("/query")
  public void query(
      HttpServletRequest req, HttpServletResponse resp, @GPRequestParam("name") String name) {
    String result = demoService.get(name);
    //		String result = "My name is " + name;
    try {
      resp.getWriter().write(result);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @GPRequestMapping("/add")
  public void add(
      HttpServletRequest req,
      HttpServletResponse resp,
      @GPRequestParam("a") Integer a,
      @GPRequestParam("b") Integer b) {
    try {
      resp.getWriter().write(a + "+" + b + "=" + (a + b));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @GPRequestMapping("/remove")
  public void remove(
      HttpServletRequest req, HttpServletResponse resp, @GPRequestParam("id") Integer id) {}
}
