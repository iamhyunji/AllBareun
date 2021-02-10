package com.allbareun.web.service;

import java.util.List;

import com.allbareun.web.entity.Calendar;

public interface CalendarService {

	int insert(Calendar calendar);
	int update(Calendar calendar);
	int delete(Calendar calendar);
	List<Calendar> getByUserId(Calendar cal);

}
