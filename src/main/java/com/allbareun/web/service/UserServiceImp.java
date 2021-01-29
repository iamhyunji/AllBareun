package com.allbareun.web.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.allbareun.web.dao.UserDao;
import com.allbareun.web.entity.User;

public class UserServiceImp implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public boolean isValid(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User get(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmail(String name, String phone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword(String email, String name, String phone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(User user) {
		// TODO Auto-generated method stub
		return 0;
	}
	


}
