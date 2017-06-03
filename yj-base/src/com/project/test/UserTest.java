package com.project.test;

import javax.annotation.Resource;

import org.junit.Test;

import com.project.mapper.UserMapper;
import com.project.po.User;

public class UserTest {
	
	@Resource
	private UserMapper userdao; 
	
	@Test
	public void userServiceTest(){
		User user = userdao.selectByPrimaryKey(1);
		System.out.println(user.getUsername());
	}
}
