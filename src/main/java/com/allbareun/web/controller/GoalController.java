package com.allbareun.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalView;
import com.allbareun.web.service.GoalServiceImp;


@Controller
@RequestMapping("/goal/")
public class GoalController {
	
	@Autowired
	private GoalServiceImp service;

	@GetMapping("reg")
	public String reg() {
		
		return "user.goal.reg";
	}
	
	@PostMapping("reg")
	public String reg(@RequestParam("startDate") String startDate, Goal goal) {

		System.out.println(startDate);
		
		return "";
	}
	
	@GetMapping("participate")
	public String participate() {

		return "user.goal.participate";
	}

	@GetMapping("list")
	public String list(Model model) {
		
		List<GoalView> list = service.getViewList();
		model.addAttribute("list", list);
		
		for (GoalView goal : list) {
			System.out.println(goal);
		}
		return "common.goal.list";
	}
}
