package com.project.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.mapper.UserMapper;
import com.project.po.User;
import com.project.service.UserService;

public class UserTest {
	
	@Autowired
	private UserService userService; 
	
	@Test
	public void userServiceTest(){
		List<String> list = userService.getUserDataById(1);
		System.out.println(list.get(0));
	}
}
