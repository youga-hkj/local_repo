package com.project.service;

import java.util.List;

import com.project.po.User;

public interface UserService {
	public List<User> findUserByUnamePwd(String username,String password); 
	
	public void saveUser(User user);
	
	public List<String> getUserDataById(int id);
}
