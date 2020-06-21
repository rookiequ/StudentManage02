package com.yctu.student.controller.impl;

import com.yctu.student.constant.ErrorText;
import com.yctu.student.constant.ResultCode;
import com.yctu.student.constant.StaticPath;
import com.yctu.student.constant.TemplatePath;
import com.yctu.student.controller.UserController;
import com.yctu.student.domain.AdminDO;
import com.yctu.student.domain.ResultDO;
import com.yctu.student.domain.StudentDO;
import com.yctu.student.domain.TeacherDO;
import com.yctu.student.service.AdminService;
import com.yctu.student.service.StudentService;
import com.yctu.student.service.TeacherService;
import com.yctu.student.vo.AccountVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName UserLoginControllerImpl
 * @Description
 * @Author qlq
 * @Date 2020-06-17 23:50
 */
@Controller
@RequestMapping("/user")
@SessionAttributes({"adminAccount", "teacherAccount", "studentAccount","result"})
public class UserControllerImpl implements UserController {

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

    @Autowired
    private TeacherService teacherService;

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
                        HttpSession httpSession)  {
        if (StringUtils.isBlank(accountVO.getAccount()) || StringUtils.isBlank(accountVO.getPassword()) || StringUtils.isBlank(userType)){
            ResultDO<Void> resultDO = new ResultDO<Void>(false, ResultCode.MUST_INPUT_ACCOUNT_PASSWORD_USERTYPE, ResultCode.MSG_MUST_INPUT_ACCOUNT_PASSWORD_USERTYPE);
            model.addAttribute("result", resultDO);
            return TemplatePath.LOGIN;
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
            ResultDO<TeacherDO> resultDO = teacherService.getTeacherByNumberAndPassword(accountVO.getAccount(), accountVO.getPassword());
            if (!resultDO.isSuccess()) {
                //账号或者密码错误
                model.addAttribute("result", resultDO);
                return TemplatePath.LOGIN;
            }
            TeacherDO teacherDO = resultDO.getModule();
            model.addAttribute("teacherAccount", teacherDO);
            return TemplatePath.TEACHER_MAIN;
        } else if (USER_STUDENT.equals(userType)) {
            //学生
            ResultDO<StudentDO> resultDO = studentService.getStudentByNumberAndPassword(accountVO.getAccount(), accountVO.getPassword());
            if (!resultDO.isSuccess()) {
                //账号或者密码错误
                model.addAttribute("result", resultDO);
                return TemplatePath.LOGIN;
            }
            //TODO 用户登录的session问题
            StudentDO studentDO = resultDO.getModule();
            model.addAttribute("studentAccount", studentDO);
            return TemplatePath.STUDENT_MAIN;
        } else {
            return TemplatePath.LOGIN;
        }


    }

    @Override
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        //TODO 移除session问题
        return "redirect:/" + StaticPath.LOGIN;
    }
}
