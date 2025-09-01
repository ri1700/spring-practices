package com.bit2025.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 *  @RequestMapping 클래스 + 메소드 매핑
 *  
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVo vo) {
		System.out.println(vo);
		return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping("/joinsuccess")
	public String joinsuccess() {
		System.out.println("join 처리~");
		return "/WEB-INF/views/joinsuccess.jsp";
	}
}
