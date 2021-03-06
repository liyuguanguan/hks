package com.moji.hks.controller;

import com.moji.hks.constant.LoginConstant;
import com.moji.hks.mybaties.model.User;
import com.moji.hks.service.UserService;
import com.moji.hks.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import com.moji.hks.dto.LoginResponseDTO;
import org.springframework.web.bind.annotation.RestController;

/**
 *登录模块
 * @Author: liyu.guan
 * @Date: 2019/6/8 下午6:10
 */
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/syslogin",method = RequestMethod.POST)
    @ResponseBody
    public LoginResponseDTO hello1(HttpServletRequest request, User user, String code) {
        LoginResponseDTO responseDTO = new LoginResponseDTO();
        if (!CodeUtil.checkVerifyCode(request, code)) {
            responseDTO.setCode(LoginConstant.CODEFALSE);
            responseDTO.setMessage("验证码有误");
            return responseDTO;
        } else {
            User users = userService.getSys(user);
            if (users != null) {
                responseDTO.setCode(LoginConstant.LOGINSUCCESS);
                responseDTO.setMessage("登录成功");
                request.getSession().setAttribute("user", users);
            } else {
                responseDTO.setCode(LoginConstant.USERNAMEPASSFALSE);
                responseDTO.setMessage("用户名密码错误");
            }
            return responseDTO;
        }
    }




}
