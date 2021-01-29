package com.allbareun.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allbareun.web.entity.Goal;
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
		// 임시 회원 아이디입니다. 추후 회원 아이디 정보 얻는 로직을 구현해주세요.
		int userId = 2;
		
		List<GoalAllView> list = service.getAllViewList(userId);
		model.addAttribute("list", list);
		
		return "user.mygoal.list";
	}
	
	@GetMapping("{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) {
		
		GoalAllView goalAllView = service.getAllView(id);
		model.addAttribute("g", goalAllView);
		
		return "user.mygoal.edit";
	}
	
	@PostMapping("{id}/edit")
	public String edit(@PathVariable("id") int id, GoalAllView goalAllView) {
		
		Goal origin = service.get(id);
		
		String mainImage = goalAllView.getMainImage();
		String title = goalAllView.getTitle();
		String explanation = goalAllView.getExplanation();
		
		if(mainImage != null)
			origin.setMainImage(mainImage);
		
		if(title != null)
			origin.setTitle(title);
		
		if(explanation != null)
			origin.setExplanation(explanation);
		
		service.update(origin, null, null, null, null);
		
		return "redirect:../list";
	}
	
}
