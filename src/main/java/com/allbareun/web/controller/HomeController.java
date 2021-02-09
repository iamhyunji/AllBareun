package com.allbareun.web.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
	public String reg(User user, HttpServletRequest request, Model model) {

		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		String encodePwd = pwdEncoder.encode(user.getPassword());
		user.setPassword(encodePwd);

		HttpSession session = request.getSession();
		String profile = (String) session.getAttribute("filePath");
		user.setProfile(profile);
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

	@PostMapping("reg/upload")
	@ResponseBody
	public String upload(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {

		int lastId = service.getLastId();
		int currentId = lastId+1;
		String url = "/upload/member/profile/" + currentId; // 파일이 저장될 경로 webapp/upload.. 폴더
		String realPath = request.getServletContext().getRealPath(url);
		System.out.println(realPath);

		File realPathFile = new File(realPath);
		if (!realPathFile.exists())
			realPathFile.mkdirs();

		String uploadedFilePath = realPath + File.separator + file.getOriginalFilename();
		File uploadedFile = new File(uploadedFilePath);

		file.transferTo(uploadedFile);

		String filePath = url + "/" + file.getOriginalFilename();

		HttpSession session = request.getSession();
		session.setAttribute("filePath", filePath);
		System.out.println(session);


		return "/common/reg";
		// System.out.println("file uploaded");
		// System.out.println(file.getOriginalFilename());
	}



	@RequestMapping("login")
	public String login()  {
		return "/common/login";
	}



	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}



	@RequestMapping("findId")
	public String findId() {

		return "/common/findId";
	}

	@PostMapping("findIdPage")
	public String findIdPage(
			@RequestParam(name = "name") String name,
			@RequestParam(name = "phone")String phone,
			Model model) {
		String email = service.getEmail(name, phone);
		model.addAttribute("name",name);
		model.addAttribute("email", email);


		return "/common/findIdPage";
	}


	@GetMapping("findPwd")
	public String findPwd() {

		return "/common/findPwd";
	}

	@PostMapping("findPwd")
	public String findPwd(
			@RequestParam(name = "email") String email,
			@RequestParam(name = "name") String name,
			@RequestParam(name = "phone") String phone,
			HttpServletRequest request) {
		int checkPwd = service.isValidPwd(email, name, phone);
		System.out.println(checkPwd);
		System.out.println(email);
		if(checkPwd == 1) {
			//여기서 받은 email을 changePwd로 넘기려면 어떻게 해야할까?
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			System.out.println(session);
		}//예외처리해야할거같은뎅...?그치?
		return "/common/changePwd";
	}

	@GetMapping("changePwd")
	public String changePwd() {
		return "/common/changePwd";
	}

	@PostMapping("changePwd")
	public String changePwd(
			@RequestParam(name = "pwd") String password, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		String encodePwd = pwdEncoder.encode(password);
		service.changePassword(email, encodePwd);
		System.out.println(session);
		System.out.println(email);
		System.out.println(password);
		return "redirect:/login";
	}


	//앞으로 만들 페이지
	//회원정보
	//	@RequestMapping("detail")
	//	public String detail() {
	//		
	//		return "home.user.mypage.detail";
	//	}
	//	//정보 수정 페이지
	//	@RequestMapping("editPage")
	//	public String editPage() {
	//		
	//		return "home.user.mypage.editPage";
	//	}
	//	//정보수정
	//	@RequestMapping("edit")
	//	public String edit() {
	//	
	//		return "redirect:/home/user/mypage/detail";
	//	}
	//	//회원삭제
	//	@RequestMapping("delete")
	//	public String delete() {
	//		
	//		return "redirect:/login";
	//	}

}
