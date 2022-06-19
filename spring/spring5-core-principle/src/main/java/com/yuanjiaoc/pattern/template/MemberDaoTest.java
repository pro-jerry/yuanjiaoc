package com.yuanjiaoc.pattern.template;

import com.yuanjiaoc.pattern.template.dao.MemberDao;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月19日
 */
public class MemberDaoTest {

  public static void main(String[] args) {
    MemberDao memberDao = new MemberDao(null);
    memberDao.query();
  }
}
