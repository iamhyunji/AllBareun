package com.allbareun.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//localhost8080:/mypage/done/list
@Controller
@RequestMapping("/mypage/")
public class MyPageController {
	
	@GetMapping("done/list")
	public String doneList() {
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
