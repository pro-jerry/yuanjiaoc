package com.yuanjiaoc.pattern.template;

import java.sql.ResultSet;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月19日
 */
public interface RowMapper<T> {
  T mapRow(ResultSet rs, int rowNum) throws Exception;
}
