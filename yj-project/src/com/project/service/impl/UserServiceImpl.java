package com.project.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.mapper.SUserMapper;
import com.project.po.Goods;
import com.project.po.SUser;
import com.project.po.SUserExample;
import com.project.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Resource
	private SUserMapper userdao ;
	
	@Override
	public Goods getUserById(int id) {
		return null;
	}
	@Override
	public List<SUser> getUserInfoByName(String username) {
		SUserExample example = new SUserExample();	
		example.createCriteria().andUserNameEqualTo(username);
		List<SUser> result = userdao.selectByExample(example);
		return null;
	}

}
