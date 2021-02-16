package com.allbareun.web.controller.api;

import java.io.File;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
import com.allbareun.web.entity.EvaluationView;
import com.allbareun.web.entity.GoalAllParticipantsView;
import com.allbareun.web.entity.GoalDetailView;
import com.allbareun.web.service.GoalService;

@RestController("apiMyPageController")
@RequestMapping("/api/mypage/")
public class MyPageController {

	@Autowired
	private GoalService service;

	@RequestMapping("done/{id}")
	public List<CertificationView> getImage(@PathVariable(name = "id") int id) {

		List<GoalAllParticipantsView> profile = service.getProfile(id);
		List<CertificationView> videoImage = service.getVideoImage(id);

		return videoImage;
	}

	@RequestMapping("profile/{id}")
	public List<GoalAllParticipantsView> getProfile(@PathVariable(name = "id") int id) {

		List<GoalAllParticipantsView> profile = service.getProfile(id);

		return profile;
	}

	@RequestMapping("barChart/{id}")
	public List<List<EvaluationView>> getBarChart(@PathVariable(name = "id") int id, Principal principal) {

		String email = principal.getName(); // 로그인 인증 정보가 갖고와짐
		int uid = service.getinfo(email);
		Date beforStartDate = service.getStartDate(id);
		Date beforEndDate = service.getEndDate(id);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String startDate = simpleDateFormat.format(beforStartDate);
		String endDate = simpleDateFormat.format(beforEndDate);

		List<EvaluationView> barChartCount = service.getVarChartCount(id, uid);
		//List<EvaluationView> list = null;
		List<List<EvaluationView>> list = new ArrayList<List<EvaluationView>>();
		for (int j = 0; j < barChartCount.size(); j++) {
			List<EvaluationView> barChart = service.getDoneBar(barChartCount.get(j).getCount(), startDate, endDate, id);
			List<EvaluationView> barChartTotal = service.getDoneBarChart(barChartCount.get(j).getCount(), startDate, endDate, id,
					barChart.get(j).getMonth());
			
			list.add(barChartTotal);
			//System.out.println(barChartTotal);
			
		}
		//System.out.println(list);
		System.out.println(list);
		return list;
	}

	@RequestMapping("lineChart/{id}")
	public List<EvaluationView> getLineChart(@PathVariable(name = "id") int id, Principal principal) {
		String email = principal.getName(); // 로그인 인증 정보가 갖고와짐
		int uid = service.getinfo(email);
		List<EvaluationView> lineChart = service.getDoneLineChart(id, uid);

		return lineChart;
	}
	
	@RequestMapping("report/lineChart")
	public List<EvaluationView> getReportLineChart( Principal principal) {
		
		String email = principal.getName(); // 로그인 인증 정보가 갖고와짐
		int uid = service.getinfo(email);
		List<EvaluationView> evaluation = service.getReport(uid);
		

		return evaluation;
	}
	
	@RequestMapping("report/radarChart")
	public List<EvaluationView> getReportRadarChart( Principal principal) {
		String email = principal.getName(); // 로그인 인증 정보가 갖고와짐
		int uid = service.getinfo(email);
		List<EvaluationView> categoryChart = service.categoryChart(uid);

		return categoryChart;
	}

}
