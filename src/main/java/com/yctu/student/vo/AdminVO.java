package com.yctu.student.vo;

import java.io.Serializable;

/**
 * @ClassName AdminVO
 * @Description 管理员确认密码实体类
 * @Author qlq
 * @Date 2020-06-20 20:21
 */
public class AdminVO implements Serializable {


    private String account;

    private String password;

    private String checkPassword;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    @Override
    public String toString() {
        return "AdminVO{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", checkPassword='" + checkPassword + '\'' +
                '}';
    }
}
