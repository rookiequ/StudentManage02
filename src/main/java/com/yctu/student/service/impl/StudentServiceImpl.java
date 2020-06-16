package com.yctu.student.service.impl;

import com.yctu.student.dao.StudentDAO;
import com.yctu.student.domain.StudentDO;
import com.yctu.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description 对StudentService的实现
 * @Author qlq
 * @Date 2020-06-15 22:36
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentDAO studentDAO;

    @Override
    public List<StudentDO> getAllStudent() {
        System.out.println("service");
        return studentDAO.getAllStudent();
    }

    @Override
    public StudentDO getStudentById(Long id) {
        return studentDAO.getStudentById(id);
    }
}
