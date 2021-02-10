package com.allbareun.web.dao;

import java.util.List;

import com.allbareun.web.entity.Calendar;

public interface CalendarDao {

	int insert(Calendar calendar);

	int update(Calendar calendar);

	int delete(Calendar calendar);

	List<Calendar> getByUserId(Calendar calendar);


}
