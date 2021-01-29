package com.allbareun.web.controller;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.allbareun.web.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController extends HttpServlet{

	private UserService service;
//	public HomeController() {
//	service = new UserService();
//}
	
	@RequestMapping("index")
	public String index() {
		
		return "home.index";
	}
	
	
	@RequestMapping("login")
	public String login() {
		
		return "common/login";
	}
	
	
	@RequestMapping("reg")
	public String reg(
		//service.insert();
		@RequestParam(name="email", defaultValue = "") String email,
		@RequestParam(name="password", defaultValue = "") String password,
		@RequestParam(name="name", defaultValue = "") String name,
		@RequestParam(name="gender", defaultValue = "") String gender,
		@RequestParam(name="age", defaultValue = "") int age,
		@RequestParam(name="phone", defaultValue = "") String phone,
		@RequestParam(name="profile", defaultValue = "") String profile,
		Model model) {
		System.out.printf("email:%s, password:%s, name:%s, gender:%s, age:%s, phone:%s, profile:%s", email,password, name,gender,age, phone,profile);
		return "common/reg";
	}
	
	
	@RequestMapping("findId")
	public String findId() {
		
		return "common/findId";
	}
	
	
	@RequestMapping("findPwd")
	public String findPwd() {
		
		return "common/findPwd";
	}

	
}
