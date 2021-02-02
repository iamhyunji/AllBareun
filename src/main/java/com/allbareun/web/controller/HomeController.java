package com.allbareun.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.allbareun.web.dao.UserDao;
import com.allbareun.web.entity.User;
import com.allbareun.web.service.UserService;
import com.allbareun.web.service.UserServiceImp;

@Controller
@RequestMapping("/")
public class HomeController{

	@Autowired
	private UserService service;
	
	
	public HomeController() {
		
}
	
	@RequestMapping("index")
	public String index() {
		
		return "home.index";
	}
	
	@GetMapping("reg")
	public String reg() {		

		return "common/reg";
	}
	
	@PostMapping("reg")
	public String reg(User user,Model model) {
		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
	      String encodePwd = pwdEncoder.encode(user.getPassword());
	      user.setPassword(encodePwd);
		int result = service.insert(user);
			
		return "redirect:login";
	}

	@PostMapping("checkDuplicate")
	@ResponseBody
	public Map<String, Object> checkDuplicate(String checkKey){
		Map<String, Object> map = new HashMap<>();
		int checkResult = service.idCheck(checkKey);
		map.put("checkResult", checkResult);
		
		return map;
	}
	
	
	@RequestMapping("login")
	public String login()  {
		System.out.println("로그인 성공");
		return "/common/login";
	}


	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
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
