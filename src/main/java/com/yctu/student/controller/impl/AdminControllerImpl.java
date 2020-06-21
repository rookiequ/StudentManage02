package com.yctu.student.controller.impl;

import com.yctu.student.constant.*;
import com.yctu.student.controller.AdminController;
import com.yctu.student.domain.AdminDO;
import com.yctu.student.domain.ResultDO;
import com.yctu.student.service.AdminService;
import com.yctu.student.utils.SHA256Util;
import com.yctu.student.vo.AdminVO;
import com.yctu.student.vo.ModifyPasswordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @ClassName AdminControllerImpl
 * @Description
 * @Author qlq
 * @Date 2020-06-17 22:20
 */
@Controller
@RequestMapping("/admin")
public class AdminControllerImpl implements AdminController {

    @Autowired
    private AdminService adminService;


    @Override
    @RequestMapping("modify-password-page")
    public String modifyPassword() {
        return TemplatePath.ADMIN_MODIFY_PASSWORD;
    }

    @Override
    @RequestMapping("/modify-password")
    public String modifyPassword(ModifyPasswordVO modifyPasswordVO, HttpSession httpSession, Model model) {

        ResultDO<Void> resultDO = new ResultDO<>();

        AdminDO adminDO = (AdminDO) httpSession.getAttribute("adminAccount");
        if (!adminDO.getPassword().equals(SHA256Util.SHA256(modifyPasswordVO.getOldPassword()))){
            resultDO.set(false, ResultCode.PASSWORD_ERROR, ResultCode.MSG_PASSWORD_ERROR);
            model.addAttribute("msg", resultDO);
            return "forward:/" + ControllerPath.ADMIN_MODIFY_PASSWORD_PAGE;
        }
        if (!modifyPasswordVO.getNewPassword().equals(modifyPasswordVO.getCheckPassword())){
            resultDO.set(false, ResultCode.TWO_PASSWORD_NOT_MATCH, ResultCode.MSG_TWO_PASSWORD_NOT_MATCH);
            model.addAttribute("msg", resultDO);
            return "forward:/" + ControllerPath.ADMIN_MODIFY_PASSWORD_PAGE;
        }
        ResultDO<Long> resultDO1 = adminService.updateAdminPasswordById(adminDO.getId(), modifyPasswordVO.getNewPassword());
        if (!resultDO1.isSuccess()){
            return "redirect:/" + StaticPath.COMMON_ERROR + "?" + resultDO1.getMsg();
        }
        httpSession.removeAttribute("adminAccount");

        return TemplatePath.LOGIN;
    }

    @Override
    @RequestMapping("/add-admin")
    public String addAdmin(AdminVO adminVO) {
        return null;
    }


}
