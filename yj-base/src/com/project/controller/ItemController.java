package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.po.Item;
import com.project.service.ItemService;

@Controller
@RequestMapping("item")
public class ItemController {
	@Autowired
	private ItemService itemservice;
	@RequestMapping(value="all",method=RequestMethod.GET)
	public String getItemList(Model model){
		List<Item> itemlist = itemservice.getAllItems();
		model.addAttribute("itemlist",itemlist);
		return "item/main";
	}
}
