package com.bit2025.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit2025.emaillist.repository.EmailRepository;
import com.bit2025.emaillist.vo.EmailVo;

@Controller
public class EmaillistController {
	
	@Autowired
	private EmailRepository emailRepository;
	
	@RequestMapping("/")
	public String list(Model model) {
		List<EmailVo> list = emailRepository.findAll();
		model.addAttribute("list",list);
		return "/WEB-INF/views/list.jsp";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "/WEB-INF/views/add.jsp";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(EmailVo emailVo) {
		emailRepository.insert(emailVo);
		return "redirect:/";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		emailRepository.deleteById(id);
		return "redirect:/";
	}
}