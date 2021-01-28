package com.allbareun.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.service.GoalService;


//localhost:8080/mygoal/detail
@Controller
@RequestMapping("/mygoal/")
public class MyGoalController {
	
	@Autowired
	private GoalService service;

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
	public String list(Model model) {
		List<GoalAllView> list = service.getAllViewList();
		model.addAttribute("list", list);
		
		return "user.mygoal.list";
	}
}
