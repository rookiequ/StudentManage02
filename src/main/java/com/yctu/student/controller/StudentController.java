package com.yctu.student.controller;


import com.yctu.student.domain.StudentDO;
import com.yctu.student.vo.AccountVO;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface StudentController {





    /**
     * 跳转到学生列表页
     * @param page
     * @param size
     * @param model
     * @return
     */
    String studentList(int page, int size ,Model model);



    /**
     * 跳转到修改学生信息页面
     * @param id
     * @param model
     * @return
     */
    String updateStudent(Long id, Model model);


    /**
     * 管理员修改学生信息后跳转到学生列表页面
     * @param studentDO
     * @return
     */
    String adminUpdateStudent(StudentDO studentDO);


    /**
     * 管理员删除信息后返回学生列表页面
     * @param id
     * @return
     */
    String deleteStudentById(Long id);


    /**
     * 注销返回登录页面
     * @param httpSession
     * @return
     */
    String logout(HttpSession httpSession);


    /**
     * 跳转到添加学生信息页面
     * @return
     */
    String addStudent();

    /**
     * 添加学生信息后，跳转到学生列表页面
     * @param studentDO
     * @return
     */
    String addStudent(StudentDO studentDO);




}
