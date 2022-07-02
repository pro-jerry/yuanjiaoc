package com.yuanjiaoc;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年07月02日
 */
@Role(role = "CEO", id = 1)
public class Tony {

  @Role(role = "teacher", id = 2)
  public String son;

  @Role(role = "doctor", id = 3)
  public String getDaughter() {
    return "daughter is doctor";
  }
}
