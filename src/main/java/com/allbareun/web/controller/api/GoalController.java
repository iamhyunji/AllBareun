package com.allbareun.web.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allbareun.web.entity.CertDetailView;
import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.GoalView;
import com.allbareun.web.service.GoalService;

@RestController("apiGoalController")
@RequestMapping("/api/goal/")
public class GoalController {

	@Autowired
	private GoalService service;

	@RequestMapping("list")
	public List<GoalView> list(
			@RequestParam(name="categories", defaultValue = "") String categories,
			@RequestParam(name="startDate", defaultValue="" ) String startDate,
			@RequestParam(name="endDate", defaultValue="") String endDate,
			@RequestParam(name="days", defaultValue = "") String days,
			@RequestParam(name="totalParticipants", defaultValue = "0") int totalParticipants,
			@RequestParam(name="query",defaultValue = "") String query,
			@RequestParam(name="count", defaultValue = "6") int count
			) {

		List<GoalView> list = service.getViewList(categories, startDate, endDate, days, totalParticipants, query,count,0);

		// color 변경
		for (int i=0; i<list.size(); i++) {
			GoalView gv = list.get(i); 
			String[] colors =  list.get(i).getCategoriesColor().split(",");			
			String[] categoryArr = list.get(i).getCategories().split(",");
			for(int j=0; j<categoryArr.length; j++)
				categoryArr[j] = "<span style=\"color:"+colors[j]+"; font-weight:bold;\">"+categoryArr[j]+"</span>";  

			String categoryStr = String.join(",", categoryArr);
			list.get(i).setCategories(categoryStr);
		}	

		return list;
	}

	@RequestMapping("scrollList")
	public List<GoalView> scrollList(@RequestParam(name="categories", defaultValue = "") String categories,
			@RequestParam(name="startDate", defaultValue="" ) String startDate,
			@RequestParam(name="endDate", defaultValue="") String endDate,
			@RequestParam(name="days", defaultValue = "") String days,
			@RequestParam(name="totalParticipants", defaultValue = "0") int totalParticipants,
			@RequestParam(name="query",defaultValue = "") String query,
			@RequestParam(name="count", defaultValue = "6") int count,
			@RequestParam(name="offset", defaultValue = "6") int offset
			) {

		List<GoalView> list = service.getViewList(categories, startDate, endDate, days, totalParticipants, query,count,offset);


		// color 변경
		for (int i=0; i<list.size(); i++) {
			GoalView gv = list.get(i); 
			String[] colors =  list.get(i).getCategoriesColor().split(",");			
			String[] categoryArr = list.get(i).getCategories().split(",");
			for(int j=0; j<categoryArr.length; j++)
				categoryArr[j] = "<span style=\"color:"+colors[j]+"; font-weight:bold;\">"+categoryArr[j]+"</span>";  

			String categoryStr = String.join(",", categoryArr);
			list.get(i).setCategories(categoryStr);
		}	

		return list;
		
	}

}
