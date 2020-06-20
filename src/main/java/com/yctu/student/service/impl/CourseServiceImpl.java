package com.yctu.student.service.impl;

import com.github.pagehelper.PageHelper;
import com.yctu.student.constant.ResultCode;
import com.yctu.student.dao.CourseDAO;
import com.yctu.student.dao.TeacherDAO;
import com.yctu.student.domain.CourseDO;
import com.yctu.student.domain.ResultDO;
import com.yctu.student.domain.StudentDO;
import com.yctu.student.domain.TeacherDO;
import com.yctu.student.service.CourseService;
import com.yctu.student.utils.SHA256Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("courseService")
@Transactional(rollbackFor = Exception.class)
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDAO courseDAO;


    /**
     *根据课程id查学生
     * @param id
     * @return
     */
    @Override
    public ResultDO<List<StudentDO>> getAllStudent(Long id,int page, int size) {
        try{
            //分页读取
            PageHelper.startPage(page, size);
            CourseDO studentDOList = courseDAO.getCourseWithStudents(id);
            return new ResultDO<List<StudentDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, studentDOList.getStudentDOList());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDO<List<StudentDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }


    /**
     *根据老师id查课程
     * @param id
     * @return
     */
    @Override
    public ResultDO<List<CourseDO>> getAllCourse(Long id,int page, int size) {
        try{
            //分页读取
            PageHelper.startPage(page, size);
            List<CourseDO> courseDOList = courseDAO.getCoursesByTeacherId(id);
            return new ResultDO<List<CourseDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, courseDOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDO<List<CourseDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }



    /**
     * 根据课程id查询课程
     * @param id
     * @return
     */
    public ResultDO<CourseDO>  getCourseBycid(Long id){
        try {
            CourseDO courseDO = courseDAO.getCourseById(id);
            return new ResultDO<CourseDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, courseDO);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResultDO<CourseDO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }


    /**
     * 教师跟新课程表
     * @param courseDO
     * @return
     */
    public ResultDO<Void>  TeacherUpdateCourse(CourseDO courseDO){
        try {
            courseDAO.updateCourse(courseDO);
            return new ResultDO<Void>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDO<Void>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION);
        }
    }


    @Override
    public ResultDO<Long> AddCourse(CourseDO courseDO) {
        CourseDO courseDOnumber = courseDAO.getCourseBynumber(courseDO.getNumber());
        if (courseDOnumber != null){
            return new ResultDO<Long>(false, ResultCode.COURSE_ALREADY_EXIST, ResultCode.MSG_COURSE_ALREADY_EXIST, null);
        }
        try {
            Long courseId = courseDAO.addCourse(courseDO);
            return new ResultDO<Long>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, courseId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDO<Long>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    @Override
    public ResultDO<Long> DeleteCourse(Long id) {
        try {
            courseDAO.deleteCourse(id);
            courseDAO.deleteCourseAndStudent(id);
            return new ResultDO<Long>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS,null);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDO<Long>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }


}
