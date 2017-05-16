package com.project.service;

import java.util.List;

import com.project.po.Goods;
import com.project.po.SUser;

public interface UserService {
	public Goods getUserById(int id);
	public List<SUser> getUserInfoByName(String username);
}
