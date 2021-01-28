package com.allbareun.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.service.GoalService;

//localhost:8080/mypage/done/list
@Controller
@RequestMapping("/mypage/")
public class MyPageController {
	
	@Autowired
	private GoalService service;
	
	@GetMapping("done/list")
	public String doneList(Model model) {
		// 임시 회원 아이디입니다. 추후 회원 아이디 정보 얻는 로직을 구현해주세요.
		int userId = 1;
		
		List<GoalAllView> list = service.getAllViewList(userId);
		model.addAttribute("list", list);
		
		return "user.mypage.done.list";
	}
	
	@GetMapping("done/detail")
	public String doneDetail() {
		return "user.mypage.done.detail";
	}
	
	@GetMapping("report/result")
	public String reportResult() {
		return "user.mypage.report.result";
	}
	
}
