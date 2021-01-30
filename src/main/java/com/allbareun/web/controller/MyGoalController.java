package com.allbareun.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.CertDetailView;
import com.allbareun.web.entity.Certification;
import com.allbareun.web.entity.CertificationView;
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

	
	@PostMapping("auth/upload")
	@ResponseBody
	public String upload(MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException {
		
		String url = "/upload"; // 파일이 저장될 경로 webapp/upload 폴더
	      String realPath = request.getServletContext().getRealPath(url);
	      System.out.println(realPath); 
	      
	      File realPathFile = new File(realPath);
	      if(!realPathFile.exists())
	         realPathFile.mkdirs();
	      
	      String uploadedFilePath = realPath + File.separator + file.getOriginalFilename();
	      File uploadedFile = new File(uploadedFilePath);
	      
	      file.transferTo(uploadedFile);
		
		return "ok";
		//System.out.println("file uploaded");
		//System.out.println(file.getOriginalFilename());
	}
	
	@RequestMapping("{id}")
	public String participate(Model model, @PathVariable(name = "id") int id) {

		GoalDetailView detail = service.getDetailView(id);
		List<User> profile = service.getProfile(id);
		CertificationView detailImage = service.getAuthImage(id);


		 model.addAttribute("detail", detail);
		 model.addAttribute("profile", profile);
		 model.addAttribute("detailImage", detailImage);
		

		return "user.mygoal.detail";
		
		/*
		 * select C.*,G.id goalId, U.name,U.profile from Certification C left join Goal
		 * G on G.id = C.goalId left join User U on U.id = C.userId where goalId = 3;
		 */
	}

	@GetMapping("cert/{goalId}/detail/{id}")
	public String certDetail(
			@PathVariable(name="goalId") int goalId,
			@PathVariable(name="id") int id,
			Model model) {

		CertDetailView detail = service.getCertDetailView(id);
		CertDetailView prev = service.getPrev(id,goalId);
		CertDetailView next = service.getNext(id,goalId);
		
		model.addAttribute("d", detail);
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);

		return "user.mygoal.cert.detail";
	}

	@GetMapping("cert/list/{goalId}")
	public String certList(@PathVariable(name = "goalId") int goalId ,Model model) {
		
		List<CertificationView> list = service.getCertViewListById(goalId);
		String ids = service.getParticipantsId(goalId); // 참가자 id 받아오기
		List<String> profileInfo = service.getUserProfile(ids);
		List<String> nameInfo = service.getUserName(ids);
		
		
		model.addAttribute("list", list);
		model.addAttribute("profileInfo", profileInfo);
		model.addAttribute("nameInfo", nameInfo);
		
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
