package com.allbareun.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.allbareun.web.entity.Cycle;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalCategory;
import com.allbareun.web.entity.GoalDetailView;
import com.allbareun.web.entity.GoalView;
import com.allbareun.web.entity.Group;
import com.allbareun.web.entity.Participation;
import com.allbareun.web.entity.User;
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
	
	// 2021.01.29.금
	@PostMapping("reg")
	public String reg(@RequestParam(name = "g-t") String title,
						@RequestParam(name = "g-ex") String explanation,
						@RequestParam(name = "g-sd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
						@RequestParam(name = "g-ed") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
						@RequestParam(name = "g-ps") boolean publicStatus,
						@RequestParam(name = "g-tp") int totalParticipants,
						@RequestParam(name = "g-gEx", required = false) String goodEx,
						@RequestParam(name = "g-bEx", required = false) String badEx,
						@RequestParam(name = "g-exEx", required = false) String exExplanation,
						@RequestParam(name = "gct-id") int[] goalCategoryTypeIds,
						@RequestParam(name = "d-id") int[] dayIds,
						@RequestParam(name = "g-m", required = false) int[] members) {

		Goal goal = new Goal(0, title, exExplanation, explanation, goodEx, badEx, endDate, startDate, publicStatus, null, 0, 2, totalParticipants, exExplanation);
		
		List<GoalCategory> gcList = new ArrayList<>();
		List<Cycle> cList = new ArrayList<>();
		List<Group> gList = new ArrayList<>();
		
		// 카테고리 : 최대 2개
		for(int i=0; i < goalCategoryTypeIds.length; i++)
			gcList.add(new GoalCategory(0, 0, goalCategoryTypeIds[i], i));
		
		// 인증 주기
		for(int i=0; i < dayIds.length; i++)
			cList.add(new Cycle(0, 0, dayIds[i]));
		
		// 지인 그룹 
		if(publicStatus == false && totalParticipants > 1)
			for(int i=0; i < members.length; i++) {
				Group member = new Group();
				member.setRequestDispatchUserId(2);
				member.setRequestReceiveUserId(members[i]);
				gList.add(member);
			}
		else
			gList = null;
		
		service.insert(goal, gcList, cList, gList);
		
		return "redirect:/mygoal/list";
	}
	
	 @RequestMapping("{id}")
	public String participate(Model model, @PathVariable(name="id") int id) {
		 
		 GoalDetailView detail = service.getDetailView(id);
		 List<User> profile = service.getProfile(id);

		
		 model.addAttribute("detail", detail);
		 model.addAttribute("profile", profile);

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
