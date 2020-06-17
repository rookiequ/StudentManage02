package com.yctu.student.controller;


import com.yctu.student.domain.StudentDO;
import com.yctu.student.vo.AccountVO;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface StudentController {


    /**
     * 获取所有学生信息
     * @param page
     * @param size
     * @param model
     * @return
     */
    String getAllStudent(int page, int size ,Model model);


    /**
     * 学生登录
     * @param accountVO
     * @param model
     * @param httpSession
     * @return
     */
    String login(AccountVO accountVO, Model model, HttpSession httpSession);


    /**
     * 根据id获取学生信息
     * @param id
     * @param model
     * @return
     */
    String getStudentById(Long id, Model model);


    /**
     * 修改学生信息
     * @param studentDO
     * @return
     */
    String updateStudent(StudentDO studentDO);


    /**
     * 根据id删除学生信息
     * @param id
     * @return
     */
    String deleteStudentById(Long id);

}
