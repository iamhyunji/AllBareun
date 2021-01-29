package com.allbareun.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allbareun.web.entity.Certification;
import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalDetailView;
import com.allbareun.web.entity.User;
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

	@RequestMapping("{id}")
	public String participate(Model model, @PathVariable(name = "id") int id) {

		GoalDetailView detail = service.get(id);
		List<User> profile = service.getProfile(id);
		CertificationView detailImage = service.getImage(id);


		 model.addAttribute("detail", detail);
		 model.addAttribute("profile", profile);
		 model.addAttribute("detailImage", detailImage);
		

		return "user.mygoal.detail";
		
		/*
		 * select C.*,G.id goalId, U.name,U.profile from Certification C left join Goal
		 * G on G.id = C.goalId left join User U on U.id = C.userId where goalId = 3;
		 */
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
