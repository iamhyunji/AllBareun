package com.allbareun.web.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allbareun.web.dao.CalendarDao;

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

}
