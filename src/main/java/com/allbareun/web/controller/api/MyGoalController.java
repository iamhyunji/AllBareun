package com.allbareun.web.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.service.GoalService;

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
		System.out.printf("%d,%s,%s,%s\n",id,name,startDate,endDate);
		List<CertificationView>  list = service.getCertViewListById(id,name,startDate,endDate);
		for (CertificationView c : list) {
			System.out.println(c);
		}
		
		
		return list;
	}
	
}
