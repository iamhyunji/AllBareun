package com.allbareun.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allbareun.web.dao.UserDao;
import com.allbareun.web.entity.User;

@Repository
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
	public boolean isValid(String email, String password) {
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


	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return mapper.insert(user);
	}


	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return mapper.update(user);
	}


	@Override
	public int delete(User user) {
		// TODO Auto-generated method stub
		return mapper.delete(user);
	}


	
	@Override
	public User getById(int id) {
		// TODO Auto-generated method stub
		return mapper.getById(id);
	}

}
