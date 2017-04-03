package com.hengtian.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hengtian.service.UserService;

@Controller
public class AdminHandler {
	@Autowired
	private UserService uService;
	
	@RequestMapping("/adminLogin")
	public String adminLogin(String username, String password, Model model) throws Exception {
		boolean b = uService.adminLogin(username, password);
		String path = "";
		if (b){
			path = "jsp/manager/addCategory";
		} else{
			model.addAttribute("message","”√ëÙ√˚ªÚ√‹¥aÂe’`");
			path = "jsp/manager/index";
		}
		return path;
	}

	@RequestMapping("/toAdmin")
	public String toAdmin() {
		return "jsp/manager/index";
	}
}
