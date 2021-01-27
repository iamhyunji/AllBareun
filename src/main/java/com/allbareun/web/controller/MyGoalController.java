package com.allbareun.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//localhost:8080/mygoal/detail
@Controller
@RequestMapping("/mygoal/")
public class MyGoalController {

	@GetMapping("auth")
	public String auth() {
		
		return "user.mygoal.auth";
	}
	
	  @GetMapping("detail")
	   public String detail() {
	      return "user.mygoal.detail";
	   }


	@GetMapping("cert/detail")
	public String certDetail() {
		
		return "user.mygoal.cert.detail";
	}
	@GetMapping("cert/list")
	public String certList() {
		
		return "user.mygoal.cert.list";
	}
	
	@GetMapping("list")
	public String list() {
		return "user.mygoal.list";

	}
}
