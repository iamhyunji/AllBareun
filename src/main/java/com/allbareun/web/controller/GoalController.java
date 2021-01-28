package com.allbareun.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allbareun.web.entity.Cycle;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalCategory;
import com.allbareun.web.entity.GoalView;
import com.allbareun.web.service.GoalServiceImp;


@Controller
@RequestMapping("/goal/")
public class GoalController {
	
	@Autowired
	private GoalServiceImp service;

	@PostMapping("reg")
	public String reg(Goal goal, GoalCategory goalCategory, Cycle cycle) {
		
		return "user.goal.reg";
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
