package com.yuanjiaoc.pattern.template.dao;

import com.yuanjiaoc.pattern.template.JdbcTemplate;
import com.yuanjiaoc.pattern.template.RowMapper;
import com.yuanjiaoc.pattern.template.entity.Member;
import java.sql.ResultSet;
import java.util.List;
import javax.sql.DataSource;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月19日
 */
public class MemberDao extends JdbcTemplate {

  public MemberDao(DataSource dataSource) {
    super(dataSource);
  }

  public List<?> query() {
    String sql = "select * from t_member";

    return super.executeQuery(
        sql,
        new RowMapper<Member>() {
          @Override
          public Member mapRow(ResultSet rs, int rowNum) throws Exception {
            Member member = new Member();
            member.setUsername(rs.getString("username"));
            member.setPassword(rs.getString("password"));
            member.setAge(rs.getInt("age"));
            member.setAddr(rs.getString("addr"));
            return member;
          }
        },
        null);
  }
}
