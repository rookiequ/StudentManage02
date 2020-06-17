package com.yctu.student.service;

import com.yctu.student.domain.ResultDO;
import com.yctu.student.domain.StudentDO;

import java.util.List;

public interface StudentService {

    /**
     * 获取所有学生信息
     * @param page
     * @param size
     * @return
     */
    ResultDO<List<StudentDO>> getAllStudent(int page, int size);

    /**
     * 根据id获取学生信息
     * @param id
     * @return
     */
    ResultDO<StudentDO> getStudentById(Long id);

    /**
     * 根据账号和密码获取学生id
     * @param number
     * @param password
     * @return
     */
    ResultDO<Long> getStudentByNumberAndPassword(String number, String password);


    /**
     * 根据id删除学生信息
     * @param id
     * @return
     */
    ResultDO<Void> deleteStudentById(Long id);

    /**
     * 修改学生信息
     * @param studentDO
     * @return
     */
    ResultDO<Void> updateStudent(StudentDO studentDO);


    /**
     * 添加学生信息
     * @param studentDO
     * @return
     */
    ResultDO<Long> addStudent(StudentDO studentDO);
}

