package com.project.controller;

import com.project.po.Users;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
            List<Users> usersList = userService.getAllUser();
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
        Users users = new Users();
        users.setAge(Integer.parseInt(age));
        users.setDelflag(0);
        users.setName(name);
        users.setPassword("password");
        userService.addUser(users);
        request.setAttribute("userList",userService.getAllUser());
        return "/user/display";
    }


}
