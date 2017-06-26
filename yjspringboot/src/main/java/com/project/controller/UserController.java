package com.project.controller;

import com.project.po.GreenhouseUser;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * Created by Bright_ on 2017/6/24.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index(){
        return "/login";
    }

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request,@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){
        boolean result = userService.checkUserInfo(username,password);
        if(result){
            List<GreenhouseUser> usersList = userService.getAllUser();
            request.setAttribute("userList",usersList);
            return "/user/display";
        }
        return "/index";
    }
    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    public String deleteUser(HttpServletRequest request, @RequestParam (value = "id")String userId){
        int user_id = Integer.parseInt(userId);
        userService.deleteUserById(user_id);
        userService.getAllUser();
        request.setAttribute("userList",userService.getAllUser());
        return "/user/display";
    }
    @RequestMapping(value = "add_user")
    public String addUser(){
        return "/user/user_add";
    }

    @RequestMapping(value = "/add")
    public String addUser(HttpServletRequest request,@RequestParam (value = "name")String name, @RequestParam (value = "age")String age){
        GreenhouseUser user = new GreenhouseUser();
        user.setLoginname(name);
        user.setName(name);
        user.setPassword("password");
        userService.addUser(user);
        request.setAttribute("userList",userService.getAllUser());
        return "/user/display";
    }


}
