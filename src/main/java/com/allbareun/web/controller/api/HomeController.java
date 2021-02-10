package com.allbareun.web.controller.api;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.allbareun.web.service.CalendarService;

@RestController("apiHomeController")
@RequestMapping("/api/home/")
public class HomeController {
	
	@Autowired
	CalendarService service;
	
	@PostMapping("post")
	public String calendarInsert(@RequestBody Calendar calendar) {
		int result = service.insert(calendar);
		return "ok";
	}
	
	@PutMapping("put")
	public String calendarUpdate(@RequestBody Calendar calendar) {
		int result = service.update(calendar);
		return "ok";
	}
	
	@DeleteMapping("del")
	public String calendarDelete(@RequestBody Calendar calendar) {
		int result = service.delete(calendar);
		return "ok";
	}
}
