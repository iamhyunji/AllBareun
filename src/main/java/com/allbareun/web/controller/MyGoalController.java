package com.allbareun.web.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.allbareun.web.entity.CertDetailView;
import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.Goal;
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

	@GetMapping("{goalId}/auth")
	public String auth(@PathVariable(name = "goalId") int goalId, Principal principal, Model model) {
		List<String> days = service.getDays(goalId); // 인증 날짜 받아오기
		System.out.println(days);
		/*요일 구하기*/
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		String day ="";
		switch (dayOfWeek) {
		case 1:
			day = "일";
			break;
		case 2:
			day = "월";
			break;
		case 3:
			day = "화";
			break;
		case 4:
			day = "수";
			break;
		case 5:
			day = "목";
			break;
		case 6:
			day = "금";
			break;
		case 7:
			day = "토";
			break;
		}
		boolean matchDay = false;
		for (String d : days) {
			if(d.equals(day)) {
				matchDay = true;
				break;
			}
		}
		if(!matchDay)
			return "error";
		
		String ids = service.getParticipantsId(goalId); // 참가자 id 받아오기
		int userId = service.getUserIdByEmail(principal.getName());
		String[] idStr = ids.split(",");
		int[] id = Arrays.stream(idStr).mapToInt(Integer::parseInt).toArray();
		for (int i = 0; i < id.length; i++) {
			if (id[i] == userId) {
				Goal goal = service.get(goalId);
				model.addAttribute("g", goal);
				model.addAttribute("userId", userId);
				return "user.mygoal.auth";
			}
		}

		return "error";
	}

	@PostMapping("{goalId}/auth")
	public String insertAuth(@PathVariable(name = "goalId") int goalId, @RequestParam(name = "userId") int userId,
			@RequestParam(name = "resultFileName") String fileName, @RequestParam(name = "q1") int answer1,
			@RequestParam(name = "q2") int answer2, @RequestParam(name = "q3") int answer3,
			@RequestParam(name = "explanation") String explanation) {

		// System.out.printf("goalId:%d,userId:%d,fileName:%s",goalId,userId,fileName);
		LocalDate date = LocalDate.now(); // 현재날짜 받기

		String url = "/upload/auth/images/"+goalId+"/"+date+"/"+userId;
		String filePath = url +"/"+ fileName;
		int result = service.certAndEvalInsert(goalId,userId,filePath,answer1,answer2,answer3,explanation);
		return "redirect:/mygoal/cert/list/"+goalId;
	} 
	
	

	@PostMapping("{goalId}/auth/upload")
	@ResponseBody
	public String upload(@PathVariable(name = "goalId") int goalId, @RequestParam(name = "id") int id,
			MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {

		LocalDate date = LocalDate.now(); // 현재날짜 받기
		String url = "/upload/auth/images/" + goalId + "/" + date + "/" + id; // 파일이 저장될 경로 webapp/upload.. 폴더
		String realPath = request.getServletContext().getRealPath(url);
		System.out.println(realPath);

		File realPathFile = new File(realPath);
		if (!realPathFile.exists())
			realPathFile.mkdirs();

		String uploadedFilePath = realPath + File.separator + file.getOriginalFilename();
		File uploadedFile = new File(uploadedFilePath);

		file.transferTo(uploadedFile);

		String filePath = url + "/" + file.getOriginalFilename();

		// int result = service.authImageInsert(id,goalId, filePath);
		return "ok";
		// System.out.println("file uploaded");
		// System.out.println(file.getOriginalFilename());
	}

	@RequestMapping("{id}")
	public String participate(Model model, @PathVariable(name = "id") int id) {

		GoalDetailView detail = service.getDetailView(id);
		List<User> profile = service.getProfile(id);
		List<CertificationView> detailImage = service.getAuthImages(id);

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
	public String certDetail(@PathVariable(name = "goalId") int goalId, @PathVariable(name = "id") int id, Model model,
			Principal principal) {

		String ids = service.getParticipantsId(goalId); // 참가자 id 받아오기
		int userId = service.getUserIdByEmail(principal.getName());
		// System.out.println(userId);
		String[] idStr = ids.split(",");
		int[] idArr = Arrays.stream(idStr).mapToInt(Integer::parseInt).toArray();
		for (int i = 0; i < idArr.length; i++) {
			if (idArr[i] == userId) {
				CertDetailView detail = service.getCertDetailView(id);
				CertDetailView prev = service.getPrev(id, goalId);
				CertDetailView next = service.getNext(id, goalId);

				model.addAttribute("d", detail);
				model.addAttribute("prev", prev);
				model.addAttribute("next", next);
				return "user.mygoal.cert.detail";
			}
		}

		return "error";
	}

	@GetMapping("cert/list/{goalId}")
	public String certList(@PathVariable(name = "goalId") int goalId, Model model, Principal principal) {

		List<CertificationView> list = service.getCertViewListById(goalId);
		String ids = service.getParticipantsId(goalId); // 참가자 id 받아오기
		int userId = service.getUserIdByEmail(principal.getName());
		// System.out.println(userId);
		String[] idStr = ids.split(",");
		int[] id = Arrays.stream(idStr).mapToInt(Integer::parseInt).toArray();
		for (int i = 0; i < id.length; i++) {
			if (id[i] == userId) {
				List<User> profileInfo = service.getUserProfile(ids);
				List<String> nameInfo = service.getUserName(ids);
				model.addAttribute("list", list);
				model.addAttribute("profileInfo", profileInfo);
				model.addAttribute("nameInfo", nameInfo);
				model.addAttribute("g", goalId);
				return "user.mygoal.cert.list";
			}
		}
		return "error";

	}

	@GetMapping("list")
	public String list(@RequestParam(name = "del-goalId", required = false, defaultValue = "0") int goalId,
						@RequestParam(name = "sc", required = false) String[] categories,
						@RequestParam(name = "sp", required = false, defaultValue = "0") int totalParticipants,
						@RequestParam(name = "sa", required = false, defaultValue = "2") int achievement,
						@RequestParam(name = "q", required = false) String query,
						Model model, Principal principal) {

		int userId = service.getUserIdByEmail(principal.getName());
		List<GoalAllView> list = service.getAllViewList(userId, "present",  categories, totalParticipants, achievement, query);

		String dayOfWeek = "";
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(today);
	    int dayOfWeekNumber = cal.get(Calendar.DAY_OF_WEEK);
	    switch(dayOfWeekNumber) {
	    	case 1:
	    		dayOfWeek = "일";
	    		break;
	    	case 2:
	    		dayOfWeek = "월";
	    		break;
	    	case 3:
	    		dayOfWeek = "화";
	    		break;
	    	case 4:
	    		dayOfWeek = "수";
	    		break;
	    	case 5:
	    		dayOfWeek = "목";
	    		break;
	    	case 6:
	    		dayOfWeek = "금";
	    		break;
	    	case 7:
	    		dayOfWeek = "토";
	    		break;
	    }
	    
		model.addAttribute("list", list);
		model.addAttribute("today", today);
		model.addAttribute("day", dayOfWeek);

		return "user.mygoal.list";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) {

		GoalAllView goalAllView = service.getAllView(id);
		model.addAttribute("g", goalAllView);
		
//		System.out.println(goalAllView.getBadEx());

		return "user.mygoal.edit";
	}

	@PostMapping("{id}/edit")
	public String edit(@PathVariable("id") int id,
						@RequestParam(name = "g-mImg", defaultValue = "/images/default-image2.png") String mainImage,
						@RequestParam(name = "g-t") String title,
						@RequestParam(name = "g-ex") String explanation) {

		Goal origin = service.get(id);

		if (mainImage != null && !origin.getMainImage().equals(mainImage)) {
			String mainImagePath = "/upload/goal/" + id + "/" + mainImage;
			origin.setMainImage(mainImagePath);
		}

		if (title != null && !title.equals(""))
			origin.setTitle(title);

		if (explanation != null && !explanation.equals(""))
			origin.setExplanation(explanation);

		service.update(origin);

		return "redirect:../list";
	}

}
