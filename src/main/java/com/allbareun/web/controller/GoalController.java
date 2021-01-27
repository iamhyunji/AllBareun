package com.allbareun.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goal/")
public class GoalController {
	//localhost:8080/goal/participate

		@GetMapping("participate")
		public String participate() {
			
			return "user.goal.participate";
		}
	
}
