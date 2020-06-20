package com.yctu.student.controller;

import com.yctu.student.domain.CourseDO;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface CourseController {

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
    public String getCourseInfo(Long id, Model model);


    /**老师更新课程信息
     *
     * @param courseDO
     * @return
     */

    public String TeacherUpdateCourse(CourseDO courseDO);

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
     * @return
     */
    public String deleteStudentById(Long id);


}
