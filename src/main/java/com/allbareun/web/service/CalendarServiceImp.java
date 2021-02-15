package com.allbareun.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allbareun.web.dao.CalendarDao;
import com.allbareun.web.entity.Calendar;

@Service
public class CalendarServiceImp implements CalendarService{

	@Autowired
	CalendarDao calendarDao;
	
	@Override
	public int insert(Calendar calendar) {
		// TODO Auto-generated method stub
		return calendarDao.insert(calendar);
	}

	@Override
	public int update(Calendar calendar) {
		// TODO Auto-generated method stub
		return calendarDao.update(calendar);
	}

	@Override
	public int delete(Calendar calendar) {
		// TODO Auto-generated method stub
		return calendarDao.delete(calendar);
	}

	@Override
	public List<Calendar> getByUserId(Calendar calendar) {
		// TODO Auto-generated method stub
		return calendarDao.getByUserId(calendar);
	}



}
