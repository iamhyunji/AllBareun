package com.allbareun.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.allbareun.web.dao.UserDao;
import com.allbareun.web.entity.User;

public class MyBatisUserDao implements UserDao{

	@Autowired
	private SqlSession session;
	private UserDao mapper;
	
	@Autowired
	public MyBatisUserDao(SqlSession session) {
		this.session = session;
		mapper = session.getMapper(UserDao.class);
	}
	
	
	@Override
	public int isValid(String email, String password) {
		// TODO Auto-generated method stub
		return mapper.isValid(email, password);
	}

	@Override
	public User get(String email, String password) {
		// TODO Auto-generated method stub
		return mapper.get(email, password);
	}

	@Override
	public String getEmail(String name, String phone) {
		// TODO Auto-generated method stub
		return mapper.getEmail(name, phone);
	}

	@Override
	public String getPassword(String email, String name, String phone) {
		// TODO Auto-generated method stub
		return mapper.getPassword(email, name, phone);
	}

}
