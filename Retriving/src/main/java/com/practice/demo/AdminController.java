package com.practice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.dao.Admin;

//import com.practice.demo.dao.GetMapping;
//import com.practice.demo.dao.RequestParam;

@Controller
public class AdminController {
	
	@Autowired
	Admin admin;
	
	@RequestMapping("/")
	@ResponseBody
	public String host()
	{
		return "show";
	}


	@GetMapping("admin/add")
	@ResponseBody
	public String addItem(@RequestParam("id") int id,@RequestParam("name") String name,
			@RequestParam("price") double price)
	{
		 admin.addItem(id, name, price);
		return "Added";
	}
	@GetMapping("/admin/edit")
	@ResponseBody
	public String editItem(@RequestParam("id") Integer id,@RequestParam("name") String name, @RequestParam("price") double price) {

		String editItem = admin.editItem(id, name, price);
		return editItem;
		
	}
	
	


}
