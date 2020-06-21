package com.yctu.student.controller;

import com.yctu.student.vo.AccountVO;
import com.yctu.student.vo.AdminVO;
import com.yctu.student.vo.ModifyPasswordVO;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface AdminController {

    /**
     * 跳转到修改密码的页面
     * @return
     */
    String modifyPassword();


    /**
     * 修改密码后，退出登录
     * @param modifyPasswordVO
     * @param httpSession
     * @param model
     * @return
     */
    String modifyPassword(ModifyPasswordVO modifyPasswordVO, HttpSession httpSession, Model model);


    /**
     * 添加管理员账号
     * @param adminVO
     * @return
     */
    String addAdmin(AdminVO adminVO);





}

