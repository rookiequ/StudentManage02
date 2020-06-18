package com.yctu.student.service;

import com.yctu.student.domain.AdminDO;
import com.yctu.student.domain.ResultDO;

public interface AdminService {


    /**
     * 根据账号和密码获取管理员信息
     * @param account
     * @param password
     * @return
     */
    ResultDO<AdminDO> getAdminByAccountAndPassword(String account, String password);


    /**
     * 修改管理员密码
     * @param id
     * @param password
     * @return
     */
    ResultDO<Long> updateAdminPasswordById(Long id, String password);


}

