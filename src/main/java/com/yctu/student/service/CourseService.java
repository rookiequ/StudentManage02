package com.yctu.student.service;

import com.yctu.student.domain.CourseDO;
import com.yctu.student.domain.ResultDO;
import com.yctu.student.domain.StudentDO;

import java.util.List;

public interface CourseService {

    /**
     * 根据课程id查学生
     * @param id
     * @param page
     * @param size
     * @return
     */
    public ResultDO<List<StudentDO>> getAllStudent(Long id,int page, int size);


    /**
     * 添加课程信息
     * @param courseDO
     * @return
     */
    ResultDO<Long> addCourse(CourseDO courseDO);


    /**
     * 根据老师id查询老师的课程
     * @param id
     * @param page
     * @param size
     * @return
     */
    public ResultDO<List<CourseDO>> getAllCourse(Long id, int page, int size);

    /**
     * 根据课程id查课程
     * @param id
     * @return
     */
    public ResultDO<CourseDO>  getCourseBycid(Long id);

    /**
     * 老是更新课表
     * @param courseDO
     * @return
     */

    public ResultDO<Void>  TeacherUpdateCourse(CourseDO courseDO);

    /**
     * 添加课程
     * @param courseDO
     * @return
     */
    public ResultDO<Long> AddCourse(CourseDO courseDO);

    /**
     * 老师端删除课程
     * @param id
     * @return
     */
    public ResultDO<Long> DeleteCourse(Long id);

    /**
     * 分页获取所有课程信息
     * @param page
     * @param size
     * @return
     */
    ResultDO<List<CourseDO>> getAllCourse(int page, int size);


    /**
     * 根据id获取课程信息
     * @param id
     * @return
     */
    ResultDO<CourseDO> getCourseById(Long id);

    /**
     * 修改课程信息
     * @param courseDO
     * @return
     */
    ResultDO<Void> updateCourse(CourseDO courseDO);

    /**
     * 根据id删除课程信息
     * @param id
     * @return
     */
    ResultDO<Void> deleteCourseById(Long id);

}

