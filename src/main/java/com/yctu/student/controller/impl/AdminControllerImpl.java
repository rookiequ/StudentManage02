package com.yctu.student.controller.impl;

import com.yctu.student.constant.ErrorText;
import com.yctu.student.constant.StaticPath;
import com.yctu.student.constant.TemplatePath;
import com.yctu.student.controller.AdminController;
import com.yctu.student.domain.AdminDO;
import com.yctu.student.domain.ResultDO;
import com.yctu.student.service.AdminService;
import com.yctu.student.vo.AccountVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 * @ClassName AdminControllerImpl
 * @Description
 * @Author qlq
 * @Date 2020-06-17 22:20
 */
@Controller
@RequestMapping("/admin")
@SessionAttributes("adminAccount")
public class AdminControllerImpl implements AdminController {

    @Autowired
    private AdminService adminService;



    @Override
    @RequestMapping("/logout")
    public String logout() {
        return TemplatePath.LOGIN;
    }
}
