package com.yctu.student.controller.impl;

import com.yctu.student.constant.TemplatePath;
import com.yctu.student.controller.StudentController;
import com.yctu.student.domain.ResultDO;
import com.yctu.student.domain.StudentDO;
import com.yctu.student.service.StudentService;
import com.yctu.student.vo.AccountVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName StudentControllerImpl
 * @Description
 * @Author qlq
 * @Date 2020-06-16 16:05
 */
@Controller
@RequestMapping("/student")
public class StudentControllerImpl implements StudentController {

    @Autowired
    private StudentService studentService;

    @Override
    @RequestMapping("/get-all-students")
    public String getAllStudent(Model model){
        System.out.println("controller");

//        model.addAttribute("students", allStudent);
        return "list";
    }

    @Override
    @RequestMapping("/login")
    public String login(AccountVO accountVO, Model model, HttpSession httpSession) {
        if (StringUtils.isBlank(accountVO.getAccount()) || StringUtils.isBlank(accountVO.getAccount())){
            return TemplatePath.COMMON_ERROR;
        }
        ResultDO<Long> resultDO = studentService.getStudentByNumberAndPassword(accountVO.getAccount(), accountVO.getPassword());
        if (resultDO.isSuccess() == false){
            return TemplatePath.COMMON_ERROR;
        }

        model.addAttribute("student", resultDO);
        return TemplatePath.SUCCESS;
    }





   /* @RequestMapping("/getStudentById")
    public ModelAndView getStudentById(){
        StudentDO studentById = studentService.getStudentById(1L);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list");
        modelAndView.addObject("students", studentById);
        return modelAndView;
    }*/

}
