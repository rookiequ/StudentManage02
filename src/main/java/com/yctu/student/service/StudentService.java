package com.yctu.student.service;

import com.yctu.student.domain.ResultDO;
import com.yctu.student.domain.StudentDO;

import java.util.List;

public interface StudentService {

    /**
     * 获取所有学生信息
     * @return
     */
    ResultDO<List<StudentDO>> getAllStudent();

    /**
     * 根据id获取学生信息
     * @param id
     * @return
     */
    ResultDO<StudentDO> getStudentById(Long id);

    /**
     * 根据账号和密码获取学生信息
     * @param number
     * @param password
     * @return
     */
    ResultDO<Long> getStudentByNumberAndPassword(String number, String password);
}

