package com.yctu.student.controller.impl;

import com.github.pagehelper.PageInfo;
import com.yctu.student.constant.ControllerPath;
import com.yctu.student.constant.ErrorText;
import com.yctu.student.constant.StaticPath;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName StudentControllerImpl
 * @Description StudentController的实现类
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
    public String studentList(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                @RequestParam(name = "size", required = true, defaultValue = "4") int size,
                                Model model){
        try {
            ResultDO<List<StudentDO>> resultDO = studentService.getAllStudent(page, size);
            List<StudentDO> studentDOList = resultDO.getModule();
            PageInfo pageInfo = new PageInfo(studentDOList);
            model.addAttribute("pageInfo", pageInfo);
            return TemplatePath.ADMIN_LIST_STUDENT;
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.ERROR_SYSTEM_EXCEPTION;
        }
    }



    @Override
    @RequestMapping("/get-student-by-id")
    public String updateStudent(Long id, Model model) {
        ResultDO<StudentDO> resultDO = studentService.getStudentById(id);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        StudentDO studentDO = resultDO.getModule();
        model.addAttribute("student", studentDO);
        return TemplatePath.ADMIN_UPDATE_STUDENT;
    }

    @Override
    @RequestMapping("/get-student-by-id-teacher")
    public String updateStudentWithTeacher(Long id, Model model) {
        ResultDO<StudentDO> resultDO = studentService.getStudentById(id);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        StudentDO studentDO = resultDO.getModule();
        model.addAttribute("student", studentDO);
        return TemplatePath.TEACHER_UPDATE_STUDENT;
    }

    @Override
    @RequestMapping("/update-student")
    public String adminUpdateStudent(StudentDO studentDO) {

        ResultDO<Void> resultDO = studentService.updateStudent(studentDO);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        return "redirect:/" + ControllerPath.GET_ALL_STUDENT;
    }


    @Override
    @RequestMapping("/update-student-teacher")
    public String TeacherUpdateStudent(StudentDO studentDO) {

        ResultDO<Void> resultDO = studentService.updateStudent(studentDO);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        return "redirect:/" + ControllerPath.GET_ALL_COURSE;
    }

    @Override
    @RequestMapping("/delete-student-by-id")
    public String deleteStudentById(Long id) {
        ResultDO<Void> resultDO = studentService.deleteStudentById(id);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        return "redirect:/" + ControllerPath.GET_ALL_STUDENT;
    }



    @Override
    @RequestMapping("/add-student-page")
    public String addStudent() {
        return TemplatePath.ADMIN_ADD_STUDENT;
    }

    @Override
    @RequestMapping("/add-student")
    public String addStudent(StudentDO studentDO) {
        ResultDO<Long> resultDO = studentService.addStudent(studentDO);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        return "redirect:/" + ControllerPath.GET_ALL_STUDENT;
    }

    @Override
    @RequestMapping("/get-student-info")
    public String getStudentInfo(Long id, Model model) {
        ResultDO<StudentDO> resultDO = studentService.getStudentById(id);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        StudentDO studentDO = resultDO.getModule();
        model.addAttribute("student", studentDO);
        return TemplatePath.ADMIN_INFO_STUDENT;
    }


    @Override
    @RequestMapping("/get-student-info-teacher")
    public String getStudentInfoWithTeacher(Long id, Model model) {
        ResultDO<StudentDO> resultDO = studentService.getStudentById(id);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        StudentDO studentDO = resultDO.getModule();
        model.addAttribute("student", studentDO);
        return TemplatePath.TEACHER_INFO_STUDENT;
    }





}
