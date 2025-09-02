package com.bit2025.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam("id") Long id) {
		/**
		 * 
		 * 만일, id라는 Parameter 값이 없거나 값이 올바르지 못하면
		 * 400 bad request error가 발생한다.
		 * 
		 */
		return "UserController:update(" + id + ")";
	}
	
	@ResponseBody
	@RequestMapping(value = "/update2", method = RequestMethod.GET)
	public String update2(@RequestParam(value = "n",required = true, defaultValue = "") String name) {
		
		return "UserController:update(" + name + ")";
	}
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@RequestParam(value = "p",required = true, defaultValue = "1") Integer page) {
		
		return "UserController:list(" + page + ")";
	}
}
