package com.allbareun.web.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.converters.StringArrayConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.Cycle;
import com.allbareun.web.entity.Evaluation;
import com.allbareun.web.entity.EvaluationView;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllParticipantsView;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalCategory;
import com.allbareun.web.entity.GoalDetailView;
import com.allbareun.web.entity.GoalView;
import com.allbareun.web.entity.Group;
import com.allbareun.web.entity.Participation;
import com.allbareun.web.entity.User;
import com.allbareun.web.service.GoalService;

//localhost:8080/mypage/done/list
@Controller
@RequestMapping("/mypage/")
public class MyPageController<E> {

	@Autowired
	private GoalService service;

	@GetMapping("done/list")
	public String doneList(@RequestParam(name = "del-goalId", required = false, defaultValue = "0") int goalId,
			@RequestParam(name = "sc", required = false) String[] categories,
			@RequestParam(name = "sp", required = false, defaultValue = "0") int totalParticipants,
			@RequestParam(name = "sa", required = false, defaultValue = "2") int achievement,
			@RequestParam(name = "q", required = false) String query, Model model, Principal principal) {

		int userId = service.getUserIdByEmail(principal.getName());
		List<GoalAllView> list = service.getAllViewList(userId, "done", categories, totalParticipants, achievement,
				query);
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
	public String doneDetail(@PathVariable(name = "id") int id, Principal principal, Model model) {

		String email = principal.getName(); // 로그인 인증 정보가 갖고와짐
		int uid = service.getinfo(email);
		Date beforStartDate = service.getStartDate(id);
		Date endDate = service.getEndDate(id);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String startDate = simpleDateFormat.format(beforStartDate);

		// System.out.println(startDate);

		List<EvaluationView> lineChart = service.getDoneLineChart(id, uid);
		// System.out.println(lineChart);

		int barChartCount = service.getVarChartCount(id, uid);
		/*
		 * if (barChartCount == null) { barChartCount = 0; }
		 */

		// System.out.println(barChartCount.size());
		List<EvaluationView> barChartTotal = service.getDoneBarChart(barChartCount, startDate, id);

		System.out.println(barChartCount);
		GoalDetailView detail = service.getDetailView(id);
		List<GoalAllParticipantsView> profile = service.getProfile(id);
		// List<CertificationView> videoImage = service.getVideoImage(id);
		
		
	
		for (int i = 0; i < profile.size(); i++) {
			// System.out.println(profile.get(i).getUserName());
			
			/*
			 * List<CertificationView> videoImage = service.getVideoImage(id,
			 * profile.get(i).getUserId()); String[] a = new String[videoImage.size()]; for
			 * (int j = 0; j < videoImage.size(); j++) {
			 * System.out.println(videoImage.get(j).getName() +
			 * videoImage.get(j).getAuthImage()); a[j] = videoImage.get(j).getAuthImage();
			 * model.addAttribute("a", a); }
			 */
			
		}
		


		model.addAttribute("detail", detail);
		model.addAttribute("profile", profile);
		model.addAttribute("lineChart", lineChart);
		// model.addAttribute("videoImage", videoImage);
		model.addAttribute("barChartTotal", barChartTotal);

		// model.addAttribute("varChartCount", varChartCount);
		/*
		 * System.out.println(barChartTotal); System.out.println(barChartCount);
		 */
		return "user.mypage.done.detail";
	}

	@GetMapping("report/result")
	public String reportResult(Principal principal, Model model) {

		String email = principal.getName(); // 로그인 인증 정보가 갖고와짐
		int uid = service.getinfo(email);
		List<EvaluationView> evaluation = service.getReport(uid);
		List<EvaluationView> categoryChart = service.categoryChart(uid);

		int reportBarChartCount = service.getReportBarChartCount(uid);
		/*
		 * if (reportBarChartCount == null) { reportBarChartCount = 0; }
		 */
		model.addAttribute("reportBarChartCount", reportBarChartCount);
		System.out.println(reportBarChartCount);

//		 SELECT GC.goalCategoryTypeId, GCT.title,
//	       sum(answer1+answer2+answer3)
//	  FROM Evaluation E left join GoalCategory GC on E.goalId = GC.goalId
//	  left join GoalCategoryType GCT on GCT.id = GC.goalCategoryTypeId
//	 GROUP BY GC.goalCategoryTypeId;

		model.addAttribute("evaluation", evaluation);
		model.addAttribute("categoryChart", categoryChart);
		for (int i = 0; i < categoryChart.size(); i++)
			System.out.println(categoryChart.get(i).getCategoryTitle() + categoryChart.get(i).getCategorySum());

		return "user.mypage.report.result";
	}

}
