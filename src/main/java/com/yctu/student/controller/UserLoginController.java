package com.yctu.student.controller;

import com.yctu.student.vo.AccountVO;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface UserLoginController {


    /**
     * 跳转到登录页面
     * @return
     */
    String login();

    /**
     * 根据用户类型进行登录
     * @param accountVO
     * @param userType
     * @param model
     * @param httpSession
     * @return
     */
    String login(AccountVO accountVO, String userType, Model model, HttpSession httpSession);

}

