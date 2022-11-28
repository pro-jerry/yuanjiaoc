package com.yuanjiaoc.annotation;

/**
 * @author 何二白
 * @version 1.0
 * @since 2022年11月28日
 */
@Table(value = "user_table")
public class User1 {

    @UserFiled(name = "user_id", type = "int", length = 8)
    private int userId;

    @UserFiled(name = "user_name", type = "varchar", length = 16)
    private String userName;

    @UserFiled(name = "password", type = "varchar", length = 16)
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
