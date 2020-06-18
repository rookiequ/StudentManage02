package com.yctu.student.service.impl;

import com.yctu.student.constant.ResultCode;
import com.yctu.student.dao.AdminDAO;
import com.yctu.student.domain.AdminDO;
import com.yctu.student.domain.ResultDO;
import com.yctu.student.service.AdminService;
import com.yctu.student.utils.SHA256Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName AdminServiceImpl
 * @Description
 * @Author qlq
 * @Date 2020-06-17 22:27
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;


    @Override
    public ResultDO<AdminDO> getAdminByAccountAndPassword(String account, String password) {
        AdminDO adminDO = adminDAO.getAdminByAccountAndPassword(account, SHA256Util.SHA256(password));
        if (adminDO == null){
            return new ResultDO<AdminDO>(false, ResultCode.PARAMETER_INVALID, ResultCode.MSG_PARAMETER_INVALID, null);
        }
        return new ResultDO<AdminDO>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, adminDO);
    }

    @Override
    public ResultDO<Long> updateAdminPasswordById(Long id, String password) {
        AdminDO adminById = adminDAO.getAdminById(id);
        if (adminById == null){
            return new ResultDO<Long>(false, ResultCode.NO_SUCH_ADMIN, ResultCode.MSG_NO_SUCH_ADMIN, null);
        }
        adminById.setPassword(SHA256Util.SHA256(password));
        adminDAO.updateAdmin(adminById);
        return new ResultDO<Long>(true, ResultCode.SUCCESS, ResultCode.MSG_SUCCESS, adminById.getId());
    }
}
