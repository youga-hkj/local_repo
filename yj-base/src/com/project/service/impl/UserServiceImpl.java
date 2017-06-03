package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.mapper.UserMapper;
import com.project.po.User;
import com.project.po.UserExample;
import com.project.service.UserService;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userdao;
	
	@Override
	public boolean findUserByUnamePwd(String username, String password) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
		List<User> result = userdao.selectByExample(example);
		if(result.size()>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void saveUser(User user) {
		userdao.insert(user);
	}

}
