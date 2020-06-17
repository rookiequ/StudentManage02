package com.yctu.student.controller.impl;

import com.yctu.student.constant.ErrorText;
import com.yctu.student.constant.StaticPath;
import com.yctu.student.constant.TemplatePath;
import com.yctu.student.controller.UserLoginController;
import com.yctu.student.domain.AdminDO;
import com.yctu.student.domain.ResultDO;
import com.yctu.student.domain.TeacherDO;
import com.yctu.student.service.AdminService;
import com.yctu.student.service.StudentService;
import com.yctu.student.vo.AccountVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @ClassName UserLoginControllerImpl
 * @Description
 * @Author qlq
 * @Date 2020-06-17 23:50
 */
@Controller
@RequestMapping("/user")
public class UserLoginControllerImpl implements UserLoginController {

    /** 管理员用户 */
    private static final String USER_ADMIN = "admin";
    /** 老师用户 */
    private static final String USER_TEACHER = "teacher";
    /** 学生用户 */
    private static final String USER_STUDENT = "student";



    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;


    @Override
    @RequestMapping("/login-page")
    public String login() {
        return TemplatePath.LOGIN;
    }

    @Override
    @RequestMapping("/login")
    public String login(AccountVO accountVO,
                        @RequestParam(required = true, name = "userType") String userType,
                        Model model,
                        HttpSession httpSession) {
        if (StringUtils.isBlank(accountVO.getAccount()) || StringUtils.isBlank(accountVO.getPassword()) || StringUtils.isBlank(userType)){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.PARAMETER_INVALID;
        }
        if (USER_ADMIN.equals(userType)) {
            //管理员
            ResultDO<AdminDO> resultDO = adminService.getAdminByAccountAndPassword(accountVO.getAccount(), accountVO.getPassword());
            if (!resultDO.isSuccess()) {
                //账号或者密码错误
                model.addAttribute("result", resultDO);
                return TemplatePath.LOGIN;
            }
            AdminDO adminDO = resultDO.getModule();
            model.addAttribute("adminAccount", adminDO);
            return TemplatePath.ADMIN_MAIN;
        } else if (USER_TEACHER.equals(userType)) {
            //老师
            //TODO 老师登录功能的实现
            return TemplatePath.TEACHER_MAIN;
        } else if (USER_STUDENT.equals(userType)) {
            //学生
            ResultDO<Long> resultDO = studentService.getStudentByNumberAndPassword(accountVO.getAccount(), accountVO.getPassword());
            if (!resultDO.isSuccess()) {
                //账号或者密码错误
                model.addAttribute("result", resultDO);
                return TemplatePath.LOGIN;
            }
            //TODO 用户登录的session问题
            Long studentId = resultDO.getModule();
            model.addAttribute("studentId", studentId);
            return TemplatePath.STUDENT_MAIN;
        } else {
            return null;
        }

    }
}
