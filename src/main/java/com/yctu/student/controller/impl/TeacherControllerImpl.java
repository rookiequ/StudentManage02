package com.yctu.student.controller.impl;

import com.github.pagehelper.PageInfo;
import com.yctu.student.constant.*;
import com.yctu.student.controller.TeacherController;
import com.yctu.student.domain.CourseDO;
import com.yctu.student.domain.AdminDO;
import com.yctu.student.domain.ResultDO;

import com.yctu.student.domain.StudentDO;
import com.yctu.student.domain.TeacherDO;
import com.yctu.student.service.TeacherService;
import com.yctu.student.utils.SHA256Util;
import com.yctu.student.vo.AccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/teacher")
public class TeacherControllerImpl implements TeacherController {

    @Autowired
    private TeacherService teacherService;


    @Override
    @RequestMapping("/get-all-teachers")
    public String teacherList(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                              @RequestParam(name = "size", required = true, defaultValue = "8") int size,
                              Model model) {
        try {
            ResultDO<List<TeacherDO>> resultDO = teacherService.getAllTeacher(page, size);
            List<TeacherDO> teacherDOList = resultDO.getModule();
            PageInfo pageInfo = new PageInfo(teacherDOList);
            model.addAttribute("pageInfo", pageInfo);
            return TemplatePath.ADMIN_LIST_TEACHER;
        }catch (Exception e) {
            e.printStackTrace();
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.ERROR_SYSTEM_EXCEPTION;
        }
    }

    @Override
    @RequestMapping("/get-teacher-by-id")
    public String updateTeacher(Long id, Model model) {
            ResultDO<TeacherDO> resultDO = teacherService.getTeacherById(id);
            if (!resultDO.isSuccess()){
                return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
            }
            TeacherDO teacherDO = resultDO.getModule();
            model.addAttribute("teacher", teacherDO);
            return TemplatePath.ADMIN_UPDATE_TEACHER;
    }

    @Override
    @RequestMapping("/update-teacher")
    public String adminUpdateTeacher(TeacherDO teacherDO) {
        ResultDO<Long> resultDO = teacherService.updateTeacher(teacherDO);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        return "redirect:/" + ControllerPath.GET_ALL_TEACHER;
    }

    @Override
    @RequestMapping("/delete-teacher-by-id")
    public String deleteTeacherById(Long id, Model model) {
        ResultDO<Void> resultDO = teacherService.deleteTeacher(id);
        if (!resultDO.isSuccess()){
            model.addAttribute("msg",resultDO);
            return "forward:/" + ControllerPath.GET_ALL_TEACHER;
        }
        return "redirect:/" + ControllerPath.GET_ALL_TEACHER;
    }




    @Override
    @RequestMapping("/add-teacher-page")
    public String addTeacher() {
        return TemplatePath.ADMIN_ADD_TEACHER;
    }



    @Override
    @RequestMapping("/add-teacher")
    public String addTeacher(TeacherDO teacherDO) {
        ResultDO<Long> resultDO = teacherService.addTeacher(teacherDO);

        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        return "redirect:/" + ControllerPath.GET_ALL_TEACHER;

    }

    @Override
    @RequestMapping("/get-teacher-info")
    public String getTeacherInfo(Long id, Model model) {
        ResultDO<TeacherDO> resultDO = teacherService.getTeacherById(id);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        TeacherDO teacherDO = resultDO.getModule();
        model.addAttribute("teacher", teacherDO);
        return TemplatePath.ADMIN_INFO_TEACHER;
    }

    @Override
    @RequestMapping("modify-password-page")
    public String modifyPassword() {
        return TemplatePath.TEACHER_MODIFY_PASSWORD;
    }

    @Override
    @RequestMapping("/modify-password")
    public String modifyPassword(String newPassword, HttpSession httpSession, Model model) {
        TeacherDO teacherDO = (TeacherDO) httpSession.getAttribute("teacherAccount");
        ResultDO<Long> resultDO = teacherService.updateTeacherPasswordById(teacherDO.getId(), newPassword);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        httpSession.removeAttribute("teacherAccount");
        return TemplatePath.LOGIN;
    }


}
