package com.project.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.po.User;
import com.project.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userSerivce;
	
	@RequestMapping("/login")
	public String userLogin(){
		return "/user/login";
	}
	
	@RequestMapping("/regist")
	public String userRegist(){
		return "/user/regist";
	}
	@RequestMapping("/user_regist")
	public String user_Regist(HttpServletRequest request,HttpServletResponse response){
		String username = request.getParameter("name");
		String password = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		Date date = new Date(System.currentTimeMillis());
		User user = new User(0, username, password, date, phone, age, email, 4);
		userSerivce.saveUser(user);
		request.setAttribute("username", username);
		request.setAttribute("password",password );
		return "/user/login";
	}
	
	
	@RequestMapping(value="/main",method = RequestMethod.GET)
	public String userLoginCheck(Model model,HttpSession session,@RequestParam("username") String username,
			@RequestParam("password") String password){
		boolean result = userSerivce.findUserByUnamePwd(username, password);
		if(result){			
			session.setAttribute("user",username );
			return "/user/main";
		}else{
			model.addAttribute("msg","login error!");
			return "/user/login";
		}
		
	}
}
