package com.project.controller;

import com.project.pojo.User;
import com.project.pojo.WebResultDto;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 方法(或接口)是登录controller
 * @Author  haojiaxing
 * @Date   2020/7/21 14:16
 **/
@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    public UserService userService;


    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    @ResponseBody
    public WebResultDto login(User user){

        WebResultDto dto = new WebResultDto();
        User resultUser = userService.login(user);
        if (resultUser == null){
            dto.setInfo("用户不存在，用户名或者密码错误");
        }else {
            dto.success(resultUser);
        }
        return  dto;

    }






}
