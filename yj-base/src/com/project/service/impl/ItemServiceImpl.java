package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.mapper.ItemMapper;
import com.project.po.Item;
import com.project.po.ItemExample;
import com.project.service.ItemService;

public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemMapper itemdao;
	
	@Override
	public List<Item> getAllItems() {
		ItemExample example = new ItemExample();
		example.createCriteria().andUserIdIsNotNull();
		List<Item> result = itemdao.selectByExample(example);		
		return result;
	}

}
