package com.yctu.student.controller;


import com.yctu.student.vo.AccountVO;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

public interface StudentController {


    /**
     * 获取所有学生信息
     * @param model
     * @return
     */
    String getAllStudent(Model model);


    /**
     * 学生登录
     * @param accountVO
     * @param model
     * @param httpSession
     * @return
     */
    String login(AccountVO accountVO, Model model, HttpSession httpSession);

}
