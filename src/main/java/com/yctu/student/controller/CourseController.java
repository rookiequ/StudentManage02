package com.yctu.student.controller;

import com.yctu.student.domain.CourseDO;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface CourseController {


    /**
     * 老师添加课程信息
     * @param courseDO
     * @return
     */
    String teacherAddCourse(CourseDO courseDO);


    /**
     * 跳转到课程列表页面
     * @param page
     * @param size
     * @param model
     * @return
     */
    String courseList(int page, int size, Model model);


    /**
     * 根据id获取信息后，然后跳转到修改课程的页面
     * @param id
     * @param model
     * @return
     */
    String updateCourse(Long id, Model model);



    /**
     * 根据老师id找出老师的所有课程
     * @param page
     * @param size
     * @param model
     * @param teacher_id
     * @return
     */
    public String CourseList(int page, int size , Model model,Long teacher_id, HttpSession httpSession);

    /**
     * 根据老师id找出老师的所有课程(课程管理使用）
     * @param page
     * @param size
     * @param model
     * @param teacher_id
     * @return
     */
    public String CourseListAll(int page, int size , Model model,Long teacher_id,HttpSession httpSession);

    /**
     * 根据课程id找出该课所有的学生
     * @param page
     * @param size
     * @param model
     * @param course_id
     * @return
     */
    public String StudentList(int page, int size , Model model,Long course_id);

    /**
     * 查询课程信息并跳转
     * @param id
     * @param model
     * @return
     */
    public String adminGetCourseInfo(Long id, Model model);


    /**
     * 查询课程信息并跳转
     * @param id
     * @param model
     * @return
     */
    public String getCourseInfo(Long id, Model model);


    /**老师更新课程信息
     *
     * @param courseDO
     * @return
     */
    public String TeacherUpdateCourse(CourseDO courseDO);





    /**
     * 更新课程信息，然后跳转到课程列表
     * @param courseDO
     * @return
     */
    String adminUpdateCourse(CourseDO courseDO);

    /**
     * 删除课程信息后，然后跳转到课程列表
     * @param id
     * @param model
     * @return
     */
    String deleteTeacher(Long id, Model model);


    /**
     * 跳转到学生选课页面
     * @param page
     * @param size
     * @param model
     * @return
     */
    String studentGetAllCourses(int page, int size, Model model);


    /**
     * 跳转到学生已选课程页面
     * @param model
     * @param httpSession
     * @return
     */
    String studentGetSelectedCourses(Model model, HttpSession httpSession);

    /**
     * 学生选择课程后跳转到已选课程列表
     * @param id
     * @param httpSession
     * @param model
     * @return
     */
    String studentSelectCourse(Long id, HttpSession httpSession, Model model);


    /**
     * 学生退选课程后跳转到已选课程列表
     * @param id
     * @param httpSession
     * @return
     */
    String studentDeleteSelectedCourse(Long id, HttpSession httpSession);


    /**
     * 跳转更新课表
     * @param id
     * @param model
     * @return
     */
    public String updateCourseWithTeacher(Long id, Model model);

    /**
     * 老师添加课程
     * @param courseDO
     * @return
     */
    public String addCourseByTeacher(CourseDO courseDO);

    /**
     * 老师端删除课程
     * @param id
     * @param model
     * @return
     */
    public String teacherDeleteCourseById(Long id, Model model);


}
