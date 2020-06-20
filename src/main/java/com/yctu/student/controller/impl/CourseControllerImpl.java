package com.yctu.student.controller.impl;

import com.github.pagehelper.PageInfo;
import com.yctu.student.constant.ControllerPath;
import com.yctu.student.constant.ErrorText;
import com.yctu.student.constant.StaticPath;
import com.yctu.student.constant.TemplatePath;
import com.yctu.student.controller.CourseController;
import com.yctu.student.domain.CourseDO;
import com.yctu.student.domain.ResultDO;
import com.yctu.student.domain.StudentDO;
import com.yctu.student.domain.TeacherDO;
import com.yctu.student.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @ClassName CourseControllerImpl
 * @Description CourseController的实现类
 * @Author qlq
 * @Date 2020-06-16 16:05
 */


@Controller
@RequestMapping("/course")
public class CourseControllerImpl implements CourseController {

    @Autowired
    private CourseService courseService;

    @Override
    @RequestMapping("/get-all-course-by-teacher")
    public String CourseList(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                             @RequestParam(name = "size", required = true, defaultValue = "4") int size,
                             Model model, Long teacher_id, HttpSession httpSession) {
        try {
            TeacherDO teacherDO =(TeacherDO)httpSession.getAttribute("teacherAccount");
            ResultDO<List<CourseDO>> listResultDO=courseService.getAllCourse(teacherDO.getId(),page,size);
            List<CourseDO> courseDOList=listResultDO.getModule();

            for(CourseDO courseDO:courseDOList){
                ResultDO<List<StudentDO>> listResultDO2=courseService.getAllStudent(courseDO.getId(),page,size);
                List<StudentDO> studentDOList=listResultDO2.getModule();
                courseDO.setNum(studentDOList.size());
                System.out.println(courseDO);
            }

            PageInfo pageInfo = new PageInfo(courseDOList);
            model.addAttribute("pageInfo", pageInfo);
            return TemplatePath.TEACHER_LIST_COURSE;
       }catch (Exception e) {
           e.printStackTrace();
           return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.ERROR_SYSTEM_EXCEPTION;
       }
    }

    @Override
    @RequestMapping("/get-all-student-by-teacher")
    public String StudentList(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                             @RequestParam(name = "size", required = true, defaultValue = "4") int size,
                             Model model,Long course_id){
        try {
            ResultDO<List<StudentDO>> listResultDO=courseService.getAllStudent(course_id,page,size);
            List<StudentDO> studentDOList=listResultDO.getModule();
            PageInfo pageInfo = new PageInfo(studentDOList);
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("courseid",course_id);
            return TemplatePath.TEACHER_LIST_STUDENT;
        }catch (Exception e) {
            e.printStackTrace();
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.ERROR_SYSTEM_EXCEPTION;
        }

    }



    @Override
    @RequestMapping("/get-all-courses-teacher")
    public String CourseListAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                             @RequestParam(name = "size", required = true, defaultValue = "4") int size,
                             Model model,Long teacher_id, HttpSession httpSession) {
        try {
            TeacherDO teacherDO =(TeacherDO)httpSession.getAttribute("teacherAccount");
            ResultDO<List<CourseDO>> listResultDO=courseService.getAllCourse(teacherDO.getId(),page,size);
            List<CourseDO> courseDOList=listResultDO.getModule();
            PageInfo pageInfo = new PageInfo(courseDOList);
            model.addAttribute("pageInfo", pageInfo);
            return TemplatePath.TEACHER_LIST_COURSE_SECOND;
        }catch (Exception e) {
            e.printStackTrace();
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + ErrorText.ERROR_SYSTEM_EXCEPTION;
        }
    }



    @Override
    @RequestMapping("/get-course-info-teacher")
    public String getCourseInfo(Long id, Model model) {
        ResultDO<CourseDO> resultDO = courseService.getCourseBycid(id);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        CourseDO courseDO = resultDO.getModule();
        model.addAttribute("course", courseDO);
        return TemplatePath.TEACHER_INFO_COURSE;
    }


    @Override
    @RequestMapping("/get-course-by-id-teacher")
    public String updateCourseWithTeacher(Long id, Model model) {
        ResultDO<CourseDO> resultDO = courseService.getCourseBycid(id);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        CourseDO courseDO = resultDO.getModule();
        model.addAttribute("course", courseDO);
        return TemplatePath.TEACHER_UPDATE_COURSE;
    }


    @Override
    @RequestMapping("/update-course-teacher")
    public String TeacherUpdateCourse(CourseDO courseDO) {
        ResultDO<Void> resultDO = courseService.TeacherUpdateCourse(courseDO);
        System.out.println(courseDO);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        return "redirect:/" + ControllerPath.GET_ALL_COURSE_SECOND;
    }



    @Override
    @RequestMapping("/add-course-teacher")
    public String addCourseByTeacher(CourseDO courseDO) {
        System.out.println(courseDO);
        ResultDO<Long> resultDO = courseService.AddCourse(courseDO);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        return "redirect:/" + ControllerPath.GET_ALL_COURSE_SECOND;
    }



    @Override
    @RequestMapping("/delete-course-by-id-teacher")
    public String deleteStudentById(Long id) {
        ResultDO<Long> resultDO = courseService.DeleteCourse(id);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        return "redirect:/" + ControllerPath.GET_ALL_COURSE_SECOND;
    }

}
