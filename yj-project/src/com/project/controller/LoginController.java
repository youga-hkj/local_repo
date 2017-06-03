package com.project.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.po.SUser;
import com.project.service.UserService;

@Controller
public class LoginController {
	
	@Resource
	private UserService userservice;
	
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request ,HttpSession session, String username,String password)throws Exception{
		List<SUser> result = userservice.getUserInfoByName(username);
		System.out.println("============="+result.get(0).getUserName());
		if (result.size()>0 ){
			session.setAttribute("username", username);
			return  "/user/main";
		}else{
			request.setAttribute("username", username);
			return "/login";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:/items/queryItems.action";
		
	}
	

}
