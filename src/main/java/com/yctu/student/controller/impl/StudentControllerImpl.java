package com.yctu.student.controller.impl;

import com.yctu.student.controller.StudentController;
import com.yctu.student.domain.StudentDO;
import com.yctu.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping("/getAll")
    public ModelAndView getAllStudent(){
        System.out.println("controller");
        List<StudentDO> allStudent = studentService.getAllStudent();
        for (StudentDO studentDO : allStudent) {
            System.out.println(studentDO);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list");
        modelAndView.addObject("students", allStudent);
        return modelAndView;
    }

    @RequestMapping("/getStudentById")
    public ModelAndView getStudentById(){
        StudentDO studentById = studentService.getStudentById(1L);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list");
        modelAndView.addObject("students", studentById);
        return modelAndView;
    }

}
