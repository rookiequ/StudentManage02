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
import com.yctu.student.service.CourseService;
import com.yctu.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName CourseControllerImpl
 * @Description
 * @Author qlq
 * @Date 2020-06-19 12:13
 */
@Controller
@RequestMapping("/course")
public class CourseControllerImpl implements CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;

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
    public String teacherDeleteCourseById(Long id, Model model) {
        ResultDO<Void> resultDO = courseService.deleteCourseById(id);
        if (!resultDO.isSuccess()){
            //将错误信息传到前端，通过js，使用弹窗提示错误原因
            model.addAttribute("msg", resultDO);
            return "forward:/" + ControllerPath.GET_ALL_COURSE_SECOND;
        }
        return "redirect:/" + ControllerPath.GET_ALL_COURSE_SECOND;
    }




    @Override
    @RequestMapping("/add-course")
    public String teacherAddCourse(CourseDO courseDO) {

        ResultDO<Long> resultDO = courseService.addCourse(courseDO);
        if (!resultDO.isSuccess()){
            //TODO 没有老师信息或者已存在课程,应该怎么跳转
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        return "redirect:/" + ControllerPath.GET_ALL_COURSE;
    }

    @Override
    @RequestMapping("/admin-get-all-courses")
    public String courseList(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                             @RequestParam(name = "size", required = true, defaultValue = "8") int size,
                             Model model) {
        ResultDO<List<CourseDO>> resultDO = courseService.getAllCourse(page, size);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        List<CourseDO> courseDOList = resultDO.getModule();
        PageInfo pageInfo = new PageInfo(courseDOList);
        model.addAttribute("pageInfo", pageInfo);
        return TemplatePath.ADMIN_LIST_COURSE;
    }

    @Override
    @RequestMapping("/get-course-by-id")
    public String updateCourse(Long id, Model model) {
        ResultDO<CourseDO> resultDO = courseService.getCourseById(id);
        if (!resultDO.isSuccess()){
            return "redirect/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        CourseDO courseDO = resultDO.getModule();
        model.addAttribute("course", courseDO);
        return TemplatePath.ADMIN_UPDATE_COURSE;
    }

    @Override
    @RequestMapping("/get-course-info")
    public String adminGetCourseInfo(Long id, Model model) {
        ResultDO<CourseDO> resultDO = courseService.getCourseById(id);
        if (!resultDO.isSuccess()){
            return "redirect/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        CourseDO courseDO = resultDO.getModule();
        model.addAttribute("course", courseDO);
        return TemplatePath.ADMIN_INFO_COURSE;
    }

    @Override
    @RequestMapping("/update-course")
    public String adminUpdateCourse(CourseDO courseDO) {
        ResultDO<Void> resultDO = courseService.updateCourse(courseDO);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        return "redirect:/" + ControllerPath.GET_ALL_COURSE;
    }

    @Override
    @RequestMapping("/delete-course-by-id")
    public String deleteTeacher(Long id, Model model) {
        ResultDO<Void> resultDO = courseService.deleteCourseById(id);
        if (!resultDO.isSuccess()){
            model.addAttribute("msg", resultDO);
            return "forward:/" + ControllerPath.GET_ALL_COURSE;
//            return "redirect:/" + StaticPath.COMMON_ERROR + "?" +resultDO.getMsg();
        }
        return "redirect:/" + ControllerPath.GET_ALL_COURSE;
    }

    @Override
    @RequestMapping("/student-get-all-courses")
    public String studentGetAllCourses(@RequestParam(name = "page", required = true, defaultValue = "1") int page,
                                       @RequestParam(name = "size", required = true, defaultValue = "8") int size,
                                       Model model) {
        ResultDO<List<CourseDO>> resultDO = courseService.getAllCourse(page, size);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        List<CourseDO> courseDOList = resultDO.getModule();
        PageInfo pageInfo = new PageInfo(courseDOList);
        model.addAttribute("pageInfo", pageInfo);
        return TemplatePath.STUDENT_LIST_COURSE;
    }

    @Override
    @RequestMapping("/student-get-selected-courses")
    public String studentGetSelectedCourses(Model model, HttpSession httpSession) {
        StudentDO studentDO = (StudentDO) httpSession.getAttribute("studentAccount");
        ResultDO<StudentDO> resultDO = studentService.getSelectedCourses(studentDO.getId());
        StudentDO studentDOWithCourses = resultDO.getModule();
        model.addAttribute("student", studentDOWithCourses);
        return TemplatePath.STUDENT_SELECTED_COURSE;
    }

    @Override
    @RequestMapping("/student-select-course")
    public String studentSelectCourse(Long id, HttpSession httpSession, Model model) {
        StudentDO studentDO = (StudentDO) httpSession.getAttribute("studentAccount");
        ResultDO<Void> resultDO = studentService.selectCourse(studentDO.getId(), id);
        if (!resultDO.isSuccess()){
            model.addAttribute("msg", resultDO);
            return "forward:/" + ControllerPath.STUDENT_GET_ALL_COURSE_PAGE;
        }
        return "redirect:/" + ControllerPath.GET_SELECTED_COURSE;
    }

    @Override
    @RequestMapping("/student-delete-course")
    public String studentDeleteSelectedCourse(Long id, HttpSession httpSession) {
        StudentDO studentDO = (StudentDO) httpSession.getAttribute("studentAccount");
        ResultDO<Void> resultDO = studentService.deleteSelectedCourse(studentDO.getId(), id);
        if (!resultDO.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO.getMsg();
        }
        return "redirect:/" + ControllerPath.GET_SELECTED_COURSE;
    }


}
