package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.mapper.UserDataMapper;
import com.project.mapper.UserMapper;
import com.project.po.User;
import com.project.po.UserData;
import com.project.po.UserDataExample;
import com.project.po.UserExample;
import com.project.service.UserService;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userdao;
	@Autowired
	private UserDataMapper userdatadao;
	@Override
	public List<User> findUserByUnamePwd(String username, String password) {
		UserExample example = new UserExample();
		example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
		List<User> result = userdao.selectByExample(example);
		return result;
	}
	
	@Override
	public void saveUser(User user) {
		userdao.insert(user);
	}

	@Override
	public List<String> getUserDataById(int id) {
		List<String> result = new ArrayList<String>();
		UserDataExample example = new UserDataExample();
		example.createCriteria().andUserIdEqualTo(id);
		List<UserData> list = userdatadao.selectByExample(example);
		for (UserData userData : list) {
			result.add(userData.getData());
		}
		return result;
	}

}
