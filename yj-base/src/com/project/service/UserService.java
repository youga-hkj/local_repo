package com.project.service;

import com.project.po.User;

public interface UserService {
	public boolean findUserByUnamePwd(String username,String password); 
	
	public void saveUser(User user);
}
