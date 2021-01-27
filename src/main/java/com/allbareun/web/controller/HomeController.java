package com.allbareun.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping("index")
	public String index() {
		
		return "home.index";
	}
	
	
	@RequestMapping("login")
	public String login() {
		
		return "common/login";
	}
	
	
	@RequestMapping("reg")
	public String reg() {
		
		return "common/reg";
	}
	
	
	@RequestMapping("findId")
	public String findId() {
		
		return "common/findId";
	}
	
	
	@RequestMapping("findPwd")
	public String findPwd() {
		
		return "common/findPwd";
	}
	
}
