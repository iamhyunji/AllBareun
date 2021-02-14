package com.allbareun.web.controller.api;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allbareun.web.entity.CertDetailView;
import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.GoalAllParticipantsView;
import com.allbareun.web.service.GoalService;

@RestController("apiMyPageController")
@RequestMapping("/api/mypage/")
public class MyPageController {
	
	@Autowired
	private GoalService service;
	
	@RequestMapping("done/{id}")
	public  List<CertificationView> getImage(@PathVariable(name = "id") int id) {
		
		List<GoalAllParticipantsView> profile = service.getProfile(id);
		List<CertificationView> videoImage = service.getVideoImage(id);
		// List<CertificationView> videoImage = service.getVideoImage(id);
		
//		
//		for (int i = 0; i < profile.size(); i++) {
//			// System.out.println(profile.get(i).getUserName());
//			
//			List<CertificationView> videoImage = service.getVideoImage(id, profile.get(i).getUserId());
//			 String[] a = new String[videoImage.size()];
//			for (= 0; j < videoImage.size(); j++) {
//				System.out.println(videoImage.get(j).getName() + videoImage.get(j).getAuthImage());
//				a[j] =  videoImage.get(j).getAuthImage();
//			}
//			
//		}
		return videoImage;
	}
	
	
	
	@RequestMapping("profile/{id}")
	public  List<GoalAllParticipantsView> getProfile(@PathVariable(name = "id") int id) {
		
		List<GoalAllParticipantsView> profile = service.getProfile(id);

		return profile;
	}
}
