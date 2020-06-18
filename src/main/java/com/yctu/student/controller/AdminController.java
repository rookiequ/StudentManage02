package com.yctu.student.controller;

import com.yctu.student.vo.AccountVO;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface AdminController {

    /**
     * 跳转到修改密码的页面
     * @return
     */
    String modifyPassword();


    /**
     * 修改密码后，退出登录
     * @param
     * @param httpSession
     * @return
     */
    String modifyPassword(String newPassword, HttpSession httpSession);





}

