package com.project.controller;

import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Bright_ on 2017/6/7.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userservice;
    @RequestMapping(value = "/index")
    public String indexView() {
        return "user/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request,@RequestParam(value = "username")String username,@RequestParam(value = "password")String password) {
        boolean result = userservice.checkUserInfo(username,password);
        if(result){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            return "user/main";
        }else{
            request.setAttribute("msg","user login error");
            return "user/login";
        }

    }

}
