package com.bit2025.hellospring.controller;

import java.io.IOException;
import java.io.Writer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public String hello2(@RequestParam("n") String name) {
		System.out.println("name:" + name);
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello3")
	public ModelAndView hello3(@RequestParam("n") String name) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		mav.addObject("name", name);
		return mav;
	}
	
	@RequestMapping("/hello4")
	public String hello4(@RequestParam("n") String name, Model model) {
		model.addAttribute("name", name);
		return "/WEB-INF/views/hello3.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/hello5")
	public String hello5() {
		return "<h1>hello, spring!</h1>";
	}
	
	@RequestMapping("/hello6")
	public String hello6() {
		return "redirect:/hello";
	}
	
	@RequestMapping("/hello7")
	public void hello7(
			HttpServletRequest request,
			HttpServletResponse response,
			Writer out) throws IOException {
		String name = request.getParameter("name");
		System.out.println("name:" + name);

		//response.getWriter().print("<h1>hello, spring</h1>");
		out.write("<h1>hello, spring</h1>");
	}
}