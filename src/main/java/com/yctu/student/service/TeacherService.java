package com.yctu.student.service;

import com.yctu.student.domain.ResultDO;
import com.yctu.student.domain.StudentDO;
import com.yctu.student.domain.TeacherDO;

import java.util.List;

public interface TeacherService {
    /**
     * 添加老师信息
     * @param teacherDO
     * @return
     */
    ResultDO<Long> addTeacher(TeacherDO teacherDO);

    /**
     * 修改老师信息
     * @param teacherDO
     */
    ResultDO<Long> updateTeacher(TeacherDO teacherDO);


    /**
     * 根据id删除老师信息
     * @param id
     */
    ResultDO<Long> deleteTeacher(Long id);

    /**
     * 根据id获取老师信息
     * @param id
     * @return
     */
    ResultDO<TeacherDO> getTeacherById(Long id);

    /**
     * 获取所有老师信息
     * @return
     */
    ResultDO<List<TeacherDO>> getAllTeacher(int page, int size);

    /**
     * 根据学院查询老师信息
     * @param college
     * @return
     */
    ResultDO<List<TeacherDO>> getTeachersByCollege(String college);


    /**
     * 根据性别获取老师信息
     * @param sex
     * @return
     */
    ResultDO<List<TeacherDO>> getTeachersBySex(String sex);


    /**
     * 根据账号和密码获取老师id
     * @param number
     * @param password
     * @return
     */
    ResultDO<Long> getTeacherByNumberAndPassword(String number, String password);

}
