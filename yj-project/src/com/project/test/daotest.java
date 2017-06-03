package com.project.test;


import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.mapper.SUserMapper;
import com.project.po.SUser;

public class daotest {
	
	
	@Autowired
	@Resource
	private SUserMapper userdao;
	
	@Test
	public void Userdaotest(){		
		SUser user = userdao.selectByPrimaryKey(3);
		System.out.println(user.getUserName());
	}
}
