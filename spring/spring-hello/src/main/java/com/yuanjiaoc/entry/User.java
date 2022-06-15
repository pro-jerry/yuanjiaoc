package com.yuanjiaoc.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年06月14日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private Long userId;

  private String nickname;

  private String mail;

  private String password;
}
