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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.allbareun.web.entity.Calendar;
import com.allbareun.web.entity.CertDetailView;
import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.EvaluationView;
import com.allbareun.web.service.GoalService;
import com.google.gson.Gson;

@RestController("apiMyGoalController")
@RequestMapping("/api/mygoal/")
public class MyGoalController {
	
	@Autowired
	private GoalService service;
	
	@RequestMapping("cert/list/{id}")
	public List<CertificationView> certList(
			@PathVariable(name = "id") int id,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "startDate", defaultValue = "") String startDate,
			@RequestParam(name = "endDate", defaultValue = "") String endDate
			) {
		List<CertificationView>  list = service.getCertViewListById(id,name,startDate,endDate);
		
		
		return list;
	}
	@RequestMapping("cert/{goalId}/detail/{id}")
	public List<Integer> certList(
			@PathVariable(name = "id") int id,
			@PathVariable(name = "goalId") int goalId
			) {
		CertDetailView  detail = service.getCertDetailView(id);
		List<Integer> list = new ArrayList<Integer>();
		list.add(detail.getAnswer1());
		list.add(detail.getAnswer2());
		list.add(detail.getAnswer3());
		
		
		return list;
	}
	
	@RequestMapping("{goalId}/auth/delete")
	public String authImageDelete(
			@PathVariable(name = "goalId") int goalId,
			@RequestParam(name = "id") int id,
			@RequestParam(name = "fileName") String fileName,
			HttpServletRequest request
			) {
		
		//int result = service.deleteAuthImage(id,goalId,fileName); // db에서 삭제
		LocalDate date = LocalDate.now(); // 현재날짜 받기
		String url = "/upload/auth/images/"+goalId+"/"+date+"/"+id; // 파일이 저장될 경로 webapp/upload.. 폴더
	      String realPath = request.getServletContext().getRealPath(url);
	      System.out.println(realPath); 
	      
	      File realPathFile = new File(realPath+"/"+fileName);
	      if(realPathFile.exists())
	         realPathFile.delete(); // 파일 삭제
		return "ok11";
	}
	
	@GetMapping("list")
	public List<Calendar> weeklyList(Principal principal) {
		int userId = service.getUserIdByEmail(principal.getName());
		Calendar cal = new Calendar();
		cal.setUserId(userId);
		List<Calendar> list = service.getByUserId(cal);
		
		return list;
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
}
