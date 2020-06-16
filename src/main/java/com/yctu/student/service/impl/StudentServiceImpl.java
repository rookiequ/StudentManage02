package com.yctu.student.service.impl;

import com.yctu.student.constant.ResultCode;
import com.yctu.student.dao.StudentDAO;
import com.yctu.student.domain.ResultDO;
import com.yctu.student.domain.StudentDO;
import com.yctu.student.service.StudentService;
import com.yctu.student.utils.SHA256Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description 对StudentService的实现
 * @Author qlq
 * @Date 2020-06-15 22:36
 */
@Service("studentService")
@Transactional(rollbackFor = Exception.class)
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentDAO studentDAO;

    @Override
    public ResultDO<List<StudentDO>> getAllStudent() {
        try {
            List<StudentDO> studentDOList = studentDAO.getAllStudent();
            return new ResultDO<List<StudentDO>>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, studentDOList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDO<List<StudentDO>>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    @Override
    public ResultDO<StudentDO> getStudentById(Long id) {
        if (id <= 0){
            return new ResultDO<StudentDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            StudentDO studentById = studentDAO.getStudentById(id);
            if (studentById == null){
                new ResultDO<StudentDO>(false, ResultCode.NO_SUCH_STUDENT, ResultCode.MSG_NO_SUCH_STUDENT, null);
            }
            return new ResultDO<StudentDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, studentById);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDO<StudentDO>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }

    @Override
    public ResultDO<Long> getStudentByNumberAndPassword(String number, String password) {
        //先判断参数是否合法
        if (StringUtils.isBlank(number) || StringUtils.isBlank(password)){
            return new ResultDO<Long>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        try {
            //判断是否有此账号
            StudentDO studentDO = studentDAO.getStudentByNumberAndPassword(Integer.parseInt(number), SHA256Util.SHA256(password));
            if (studentDO == null){
                return new ResultDO<Long>(false, ResultCode.NO_SUCH_ACCOUNT, ResultCode.MSG_NO_SUCH_ACCOUNT, null);
            }
            return new ResultDO<Long>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, studentDO.getId());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new ResultDO<Long>(false, ResultCode.ERROR_SYSTEM_EXCEPTION, ResultCode.MSG_ERROR_SYSTEM_EXCEPTION, null);
        }
    }
}
