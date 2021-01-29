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

import com.allbareun.web.entity.Certification;
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
	
	  @GetMapping("detail")
	   public String detail() {
	      return "user.mygoal.detail";
	   }


	@GetMapping("cert/detail")
	public String certDetail() {
		
		return "user.mygoal.cert.detail";
	}
	@GetMapping("cert/list/{id}")
	public String certList(@PathVariable("id") int goalId ,Model model) {
		
		List<Certification> list = service.getCertListById(goalId);
		for (Certification certification : list) {
			System.out.println(certification);
		}
		model.addAttribute("list", list);
		
		return "user.mygoal.cert.list";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		List<GoalAllView> list = service.getAllViewList();
		model.addAttribute("list", list);
		
		return "user.mygoal.list";
	}
}
