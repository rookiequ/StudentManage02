package com.yctu.student.service;

import com.yctu.student.domain.StudentDO;

import java.util.List;

public interface StudentService {

    /**
     * 获取所有学生信息
     * @return
     */
    List<StudentDO> getAllStudent();

    /**
     * 根据id获取学生信息
     * @param id
     * @return
     */
    StudentDO getStudentById(Long id);

}

