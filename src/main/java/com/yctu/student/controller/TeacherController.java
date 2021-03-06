package com.yctu.student.controller;

import com.yctu.student.domain.CourseDO;
import com.yctu.student.domain.StudentDO;
import com.yctu.student.domain.TeacherDO;
import com.yctu.student.vo.AccountVO;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface TeacherController {

    /**
     * 跳转老师页面
     * @param page
     * @param size
     * @param model
     * @return
     */
    String teacherList(int page, int size , Model model);

    /**
     * 跳转到修改老师信息页面
     * @param id
     * @param model
     * @return
     */
    String updateTeacher(Long id, Model model);



    /**
     * 管理员修改老师信息后跳转到学生列表页面
     * @param teacherDO
     * @return
     */
    String adminUpdateTeacher(TeacherDO teacherDO);




    /**
     * 管理员删除信息后返回老师列表页面
     * @param id
     * @param model
     * @return
     */
    String deleteTeacherById(Long id, Model model);




    /**
     * 跳转到添加老师信息页面
     * @return
     */
    String addTeacher();


    /**
     * 添加老师信息后，跳转到老师列表页面
     * @param teacherDO
     * @return
     */
    String addTeacher(TeacherDO teacherDO);



    /**
     * 查看老师详细信息
     * @param id
     * @param model
     * @return
     */
    String getTeacherInfo(Long id, Model model);

    /**
     * 老师修改密码
     * @param newPassword
     * @param httpSession
     * @param model
     * @return
     */
    public String modifyPassword(String newPassword, HttpSession httpSession, Model model);


    /**
     * 跳转修改密码页面
     * @return
     */
    public String modifyPassword();



}
