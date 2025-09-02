package com.bit2025.emaillist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2025.emaillist.repository.EmailRepository;

@Controller
public class EmaillistController {
	
	@Autowired
	private EmailRepository emailRepository;
	
	@ResponseBody
	@RequestMapping("/")
	public String list() {
		return "EmaillistController:list";
	}
}