package com.bit2025.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
	
/**
 * 
 *  @RequestMapping 클래스 단독 매핑
 * 
 * 	Spring MVC 4.x 지원
 * 
 */

@RequestMapping("/guestbook")
//@Controller
public class GuestbookController {
	
	@RequestMapping
	public void list() {
		
	}
	@RequestMapping
	public void delete() {
		
	}
	@RequestMapping
	public void deleteform() {
		
	}
}
