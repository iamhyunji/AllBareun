package com.allbareun.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mygoal/")
public class MyGoalController {

	@GetMapping("auth")
	public String auth() {
		
		System.out.println("11");
		return "user.mygoal.auth";
	}
	
	@GetMapping("list")
	public String list() {
		return "user.mygoal.list";
	}
}
