package com.allbareun.web.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allbareun.web.dao.UserDao;
import com.allbareun.web.entity.User;

@Service
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
		return userDao.getEmail(name, phone);
	}

	@Override
	public String getPassword(String email, String name, String phone) {
		// TODO Auto-generated method stub
		return userDao.getPassword(email, name, phone);
	}

	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return userDao.insert(user);
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

	@Override
	public int idCheck(String query) {
		// TODO Auto-generated method stub
		return userDao.idCheck(query);
	}
	
	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		session.invalidate();
	}

	@Override
	public int isValidId(String name, String phone) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int isValidPwd(String email, String name, String phone) {
		// TODO Auto-generated method stub
		return userDao.isValidPwd(email, name, phone);
	}

	@Override
	public int changePassword(String email, String password) {
		// TODO Auto-generated method stub
		return userDao.changePassword(email, password);
	}

	@Override
	public User getUser(String email, String name, String phone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLastId() {
		// TODO Auto-generated method stub
		return userDao.getLastId();
	}

	

	

	

	
	


}
