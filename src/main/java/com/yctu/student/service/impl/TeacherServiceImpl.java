package com.yctu.student.service.impl;


import com.github.pagehelper.PageHelper;
import com.yctu.student.constant.ResultCode;
import com.yctu.student.dao.TeacherDAO;
import com.yctu.student.domain.ResultDO;
import com.yctu.student.domain.StudentDO;
import com.yctu.student.domain.TeacherDO;
import com.yctu.student.service.TeacherService;
import com.yctu.student.utils.SHA256Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName teacherServiceImpl
 * @Description 对teacherService的实现
 * @Author qlq
 * @Date 2020-06-15 22:36
 */

@Service("teacherService")
@Transactional(rollbackFor = Exception.class)
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDAO teacherDAO;

    /**
     * 添加老师信息
     * @param teacherDO
     * @return
     */
    @Override
    public ResultDO<Long> addTeacher(TeacherDO teacherDO){
        TeacherDO teacherByNumber = teacherDAO.getTeacherByNumber(teacherDO.getNumber());
        if (teacherByNumber != null){
            return new ResultDO<Long>(false, ResultCode.TEACHER_ALREADY_EXIST, ResultCode.MSG_TEACHER_ALREADY_EXIST, null);
        }
        try {
            teacherDO.setPassword(SHA256Util.SHA256(teacherDO.getPassword()));
            teacherDAO.addTeacher(teacherDO);
            return new ResultDO<Long>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, null);
        }catch (Exception e){
            e.printStackTrace();
            return new ResultDO<Long>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    /**
     * 修改老师信息
     * @param teacherDO
     */
    @Override
    public ResultDO<Long> updateTeacher(TeacherDO teacherDO) {
        try{
            teacherDAO.updateTeacher(teacherDO);
            return new ResultDO<Long>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, null);
        }catch (Exception e){
            e.printStackTrace();
            return new ResultDO<Long>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    /**
     * 根据id删除老师信息
     * @param id
     */
    @Override
    public ResultDO<Long> deleteTeacher(Long id) {
        try{
            teacherDAO.deleteTeacher(id);
            return new ResultDO<Long>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, null);
        }catch (Exception e){
            e.printStackTrace();
            return new ResultDO<Long>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    /**
     * 根据id获取老师信息
     * @param id
     * @return
     */
    @Override
    public ResultDO<TeacherDO> getTeacherById(Long id) {
        if (id <= 0){
            return new ResultDO<TeacherDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try{
            TeacherDO teacherDO=teacherDAO.getTeacherById(id);
            if (teacherDO == null){
                return new ResultDO<TeacherDO>(false, ResultCode.NO_SUCH_TEACHER, ResultCode.MSG_NO_SUCH_TEACHER, null);
            }
            return new ResultDO<TeacherDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, teacherDO);
        }catch (Exception e){
            e.printStackTrace();
            return new ResultDO<TeacherDO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    /**
     * 获取所有老师信息
     * @return
     */
    @Override
    public ResultDO<List<TeacherDO>> getAllTeacher(int page, int size) {
        try{
            PageHelper.startPage(page, size);
            List<TeacherDO> teacherDOList=teacherDAO.getAllTeacher();
            return new ResultDO<List<TeacherDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, teacherDOList);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResultDO<List<TeacherDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }


    /**
     * 根据学院查询老师信息
     * @param college
     * @return
     */
    @Override
    public ResultDO<List<TeacherDO>> getTeachersByCollege(String college) {

        try{
            List<TeacherDO> teacherDOList=teacherDAO.getTeachersByCollege(college);
            return new ResultDO<List<TeacherDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, null);
        }catch (Exception e){
            e.printStackTrace();
            return new ResultDO<List<TeacherDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }


    /**
     * 根据性别获取老师信息
     * @param sex
     * @return
     */

    @Override
    public ResultDO<List<TeacherDO>> getTeachersBySex(String sex) {
        try{
            List<TeacherDO> teacherDOList=teacherDAO.getTeachersBySex(sex);
            return new ResultDO<List<TeacherDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, null);
        }catch (Exception e){
            e.printStackTrace();
            return new ResultDO<List<TeacherDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }

    }

    @Override
    public ResultDO<Long> getTeacherByNumberAndPassword(String number, String password) {
        //先判断参数是否合法
        if (StringUtils.isBlank(number) || StringUtils.isBlank(password)){
            return new ResultDO<Long>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            //判断是否有此账号
            TeacherDO teacherDO = teacherDAO.getTeacherByNumberAndPassword(number, SHA256Util.SHA256(password));
            if (teacherDO == null){
                return new ResultDO<Long>(false, ResultCode.NO_SUCH_ACCOUNT, ResultCode.MSG_NO_SUCH_ACCOUNT, null);
            }
            return new ResultDO<Long>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, teacherDO.getId());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new ResultDO<Long>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }


}
