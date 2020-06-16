package com.yctu.student.vo;

/**
 * @ClassName AccountVO
 * @Description
 * @Author qlq
 * @Date 2020-06-16 21:11
 */
public class AccountVO {

    private String account;

    private String password;

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

    @Override
    public String toString() {
        return "AccountVO{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
