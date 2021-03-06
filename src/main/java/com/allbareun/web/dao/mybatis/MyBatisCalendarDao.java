package com.allbareun.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allbareun.web.dao.CalendarDao;
import com.allbareun.web.entity.Calendar;

@Repository
public class MyBatisCalendarDao implements CalendarDao {

	private CalendarDao mapper;
	
	@Autowired
	public MyBatisCalendarDao(SqlSession session) {
		mapper = session.getMapper(CalendarDao.class);
	}
	
	
	@Override
	public int insert(Calendar calendar) {
		// TODO Auto-generated method stub
		return mapper.insert(calendar);
	}

	@Override
	public int update(Calendar calendar) {
		// TODO Auto-generated method stub
		return mapper.update(calendar);
	}

	@Override
	public int delete(Calendar calendar) {
		// TODO Auto-generated method stub
		return mapper.delete(calendar);
	}


	@Override
	public List<Calendar> getByUserId(Calendar calendar) {
		// TODO Auto-generated method stub
		return mapper.getByUserId(calendar);
	}




}
