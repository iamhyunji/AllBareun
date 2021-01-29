package com.allbareun.web.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.allbareun.web.entity.GoalView;
import com.allbareun.web.service.GoalServiceImp;


@Controller
@RequestMapping("/goal/")
public class GoalController {
	
	@Autowired
	private GoalServiceImp service;

	@GetMapping("participate")
	public String participate() {

		return "user.goal.participate";
	}

	@GetMapping("list")
	public String list(
			@RequestParam(name="categories", defaultValue = "") String categories,
			@RequestParam(name="startDate", defaultValue="" ) String startDate,
			@RequestParam(name="endDate", defaultValue="") String endDate,
			@RequestParam(name="days", defaultValue = "") String days,
			@RequestParam(name="count", defaultValue = "0") int totalParticipants,
			@RequestParam(name="query",defaultValue = "") String query,
			Model model) {
		System.out.printf("categories:%s startDate:%s endDate:%s days:%s count:%d query:%s \n",categories, startDate, endDate, days, totalParticipants, query);
		List<GoalView> list = service.getViewList(categories, startDate, endDate, days, totalParticipants, query);
		
		
		// color 변경
		for (int i=0; i<list.size(); i++) {
			GoalView gv = list.get(i); 
			String[] colors =  list.get(i).getCategoriesColor().split(",");			
			String[] categoryArr = list.get(i).getCategories().split(",");
			for(int j=0; j<categoryArr.length; j++)
				categoryArr[j] = "<span style=\"color:"+colors[j]+"; font-weight:bold;\">"+categoryArr[j]+"</span>";  
			
			String categoryStr = String.join(",", categoryArr);
			list.get(i).setCategories(categoryStr);
		}
		
		model.addAttribute("list", list);
		
		return "common.goal.list";
	}
}
