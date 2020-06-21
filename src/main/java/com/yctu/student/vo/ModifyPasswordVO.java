package com.yctu.student.vo;

import java.io.Serializable;

/**
 * @ClassName ModifyPasswordVO
 * @Description 用户修改密码的实体类
 * @Author qlq
 * @Date 2020-06-20 20:33
 */
public class ModifyPasswordVO  implements Serializable {

    /** 原密码 */
    private String oldPassword;
    /** 新密码 */
    private String newPassword;
    /** 确认密码 */
    private String checkPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    @Override
    public String toString() {
        return "ModifyPasswordVO{" +
                "oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", checkPassword='" + checkPassword + '\'' +
                '}';
    }
}
