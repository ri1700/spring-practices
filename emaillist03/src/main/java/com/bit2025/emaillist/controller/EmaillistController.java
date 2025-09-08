package com.bit2025.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit2025.emaillist.service.EmaillistService;
import com.bit2025.emaillist.vo.EmailVo;

@Controller
public class EmaillistController {
	
	@Autowired
	private EmaillistService emaillistService;

	@RequestMapping("/")
	public String list(Model model) {
		List<EmailVo> list = emaillistService.getEmails(); 
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add() {
		return "add";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(EmailVo emailVo) {
		emaillistService.addEmail(emailVo);
		return "redirect:/";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		emaillistService.deleteEmail(id); 
		return "redirect:/";
	}
	
}