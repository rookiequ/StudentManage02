package com.yctu.student.service;

import com.yctu.student.domain.CourseDO;
import com.yctu.student.domain.ResultDO;
import com.yctu.student.domain.StudentDO;
import sun.reflect.generics.tree.VoidDescriptor;

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
    ResultDO<StudentDO> getStudentByNumberAndPassword(String number, String password);


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


    /**
     * 根据学生id查询学生信息包含选择的课程
     * @param studentId
     * @return
     */
    ResultDO<StudentDO> getSelectedCourses(Long studentId);

    /**
     * 学生根据学生id和课程id选课
     * @param studentId
     * @param courseId
     * @return
     */
    ResultDO<Void> selectCourse(Long studentId, Long courseId);

    /**
     * 学生退选课程
     * @param studentId
     * @param courseId
     * @return
     */
    ResultDO<Void> deleteSelectedCourse(Long studentId, Long courseId);

    /**
     * 学生修改密码
      * @param studentId
     * @param password
     * @return
     */
    ResultDO<Void> modifyPassword(Long studentId, String password);
}

