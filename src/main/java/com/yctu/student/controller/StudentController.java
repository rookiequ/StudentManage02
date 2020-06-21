package com.yctu.student.controller;


import com.yctu.student.domain.StudentDO;
import com.yctu.student.vo.AccountVO;
import com.yctu.student.vo.ModifyPasswordVO;
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
     * @param model
     * @return
     */
    String deleteStudentById(Long id, Model model);




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


    /**
     * 查看学生详细信息
     * @param id
     * @param model
     * @return
     */
    String getStudentInfo(Long id, Model model);

    /**
     * 老师系统查看学生详情
     * @param id
     * @param model
     * @return
     */
    public String getStudentInfoWithTeacher(Long id, Model model);

    /**
     * 老师系统修改学生信息
     * @param id
     * @param model
     * @return
     */
    public String updateStudentWithTeacher(Long id, Model model);

    /**
     * 老师修改学生信息跳转主页
     * @param studentDO
     * @return
     */
    public String TeacherUpdateStudent(StudentDO studentDO);

    /**
     * 跳转到学生修改密码页面
     * @return
     */
    String modifyPassword();

    /**
     * 学生修改密码后跳转
     * @param modifyPasswordVO
     * @param httpSession
     * @param model
     * @return
     */
    String modifyPassword(ModifyPasswordVO modifyPasswordVO, HttpSession httpSession, Model model);

}
