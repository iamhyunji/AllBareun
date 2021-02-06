package com.allbareun.web.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.allbareun.web.entity.Cycle;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalCategory;
import com.allbareun.web.entity.GoalDetailView;
import com.allbareun.web.entity.Group;
import com.allbareun.web.entity.User;
import com.allbareun.web.service.GoalService;

//localhost:8080/mypage/done/list
@Controller
@RequestMapping("/mypage/")
public class MyPageController {

	@Autowired
	private GoalService service;

	@GetMapping("done/list")
	public String doneList(@RequestParam(name = "del-goalId", required = false, defaultValue = "0") int goalId,
							@RequestParam(name = "sc", required = false) String[] categories,
							@RequestParam(name = "sp", required = false, defaultValue = "0") int totalParticipants,
							@RequestParam(name = "sa", required = false, defaultValue = "2") int achievement,
							@RequestParam(name = "q", required = false) String query,
							Model model, Principal principal) {

		int userId = service.getUserIdByEmail(principal.getName());
		List<GoalAllView> list = service.getAllViewList(userId, "done",  categories, totalParticipants, achievement, query);
		model.addAttribute("list", list);

		// Delete Goal From User
		if (goalId != 0) {
			Goal goal = service.get(goalId);
			goal.setUserId(userId);
			service.deleteGoalFromUser(goal, null, null, null);

			return "redirect:./list";
		}

		return "user.mypage.done.list";
	}

	@GetMapping("done/{id}/retry")
	public String doneRetry(@PathVariable(name = "id") int id, Model model) {

		GoalAllView retryGoal = service.getAllView(id);
		model.addAttribute("rg", retryGoal);

		return "user.mypage.done.retry";
	}

	@PostMapping("done/{id}/retry")
	public String doneRetry(@RequestParam(name = "g-i") int id,
			@RequestParam(name = "g-mImg", defaultValue = "/images/default-image2.png") String mainImage,
			@RequestParam(name = "g-t") String title, @RequestParam(name = "g-ex") String explanation,
			@RequestParam(name = "g-sd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
			@RequestParam(name = "g-ed") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate,
			@RequestParam(name = "g-ps") boolean publicStatus, @RequestParam(name = "g-c") int count,
			@RequestParam(name = "g-tp") int totalParticipants,
			@RequestParam(name = "g-gEx", required = false) String goodEx,
			@RequestParam(name = "g-bEx", required = false) String badEx,
			@RequestParam(name = "g-exEx", required = false) String exExplanation,
			@RequestParam(name = "gct-id") int[] goalCategoryTypeIds, @RequestParam(name = "d-id") int[] dayIds,
			@RequestParam(name = "g-m", required = false) int[] members, Principal principal) {
		int userId = service.getUserIdByEmail(principal.getName());
		Goal goal = new Goal(id, title, explanation, mainImage, goodEx, badEx, endDate, startDate, publicStatus, null,
				count, userId, totalParticipants, exExplanation);

		List<GoalCategory> gcList = new ArrayList<>();
		List<Cycle> cList = new ArrayList<>();
		List<Group> gList = new ArrayList<>();

		// 카테고리 : 최대 2개
		for (int i = 0; i < goalCategoryTypeIds.length; i++)
			gcList.add(new GoalCategory(0, 0, goalCategoryTypeIds[i], i));

		// 인증 주기
		for (int i = 0; i < dayIds.length; i++)
			cList.add(new Cycle(0, 0, dayIds[i]));

		// 지인 그룹
		if (publicStatus == false && totalParticipants > 1)
			for (int i = 0; i < members.length; i++) {
				Group member = new Group();
				member.setRequestDispatchUserId(userId);
				member.setRequestReceiveUserId(members[i]);
				gList.add(member);
			}
		else
			gList = null;

		service.retryGoal(goal, gcList, cList, gList);

		return "redirect:/mygoal/list";
	}

	@GetMapping("done/{id}")
	public String doneDetail(Model model, @PathVariable(name = "id") int id) {
		GoalDetailView detail = service.getDetailView(id);
		List<User> profile = service.getProfile(id);

		model.addAttribute("detail", detail);
		model.addAttribute("profile", profile);

		return "user.mypage.done.detail";
	}

	@GetMapping("report/result")
	public String reportResult(Model model, @PathVariable(name = "userId") int id, Principal principal) {
		// Model model, @PathVariable(name="id") int id
		// List<> profile = service.getProfile(id);
		// model.addAttribute("detail", detail);

		return "user.mypage.report.result";
	}

}
