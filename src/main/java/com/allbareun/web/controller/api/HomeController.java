package com.allbareun.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allbareun.web.entity.Calendar;
import com.allbareun.web.service.CalendarService;
import com.google.gson.Gson;

@RestController("apiHomeController")
@RequestMapping("/api/home/")
public class HomeController {
	
	@Autowired
	CalendarService service;
	
	@GetMapping("get")
	public List<Calendar> calendarGet(@RequestParam(name="userId") int userId) {
		Calendar cal = new Calendar();
		cal.setUserId(userId);
		List<Calendar> list = service.getByUserId(cal);
		return list;
	}	
	@PostMapping("post")
	public String calendarInsert(@RequestBody Calendar calendar) {
		int result = service.insert(calendar);
		return "ok";
	}
	
	@PutMapping("put/{userId}")
	public String calendarUpdate(@RequestBody Calendar calendar,@PathVariable(name="userId") int userId ) {
		int result = service.update(calendar);
		return "ok";
	}
	
	@DeleteMapping("del")
	public String calendarDelete(@RequestBody Calendar calendar) {
		System.out.println("나 불렀어?");
		int result = service.delete(calendar);
		return "ok";
	}
	

}
