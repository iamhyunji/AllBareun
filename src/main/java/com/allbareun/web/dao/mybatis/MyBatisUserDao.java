package com.allbareun.web.dao.mybatis;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allbareun.web.dao.UserDao;
import com.allbareun.web.entity.User;

@Repository
public class MyBatisUserDao implements UserDao{

	private UserDao mapper;
	
	@Autowired
	public MyBatisUserDao(SqlSession session) {
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

	@Override
	public int idCheck(String query) {
		// TODO Auto-generated method stub
		return mapper.idCheck(query);
	}



	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getUserId(String email) {
		
		return mapper.getUserId(email);
	}


	@Override
	public int isValidId(String name, String phone) {
		// TODO Auto-generated method stub
		return mapper.isValidId(name, phone);
	}


	@Override
	public int isValidPwd(String email, String name, String phone) {
		// TODO Auto-generated method stub
		return mapper.isValidPwd(email, name, phone);
	}


	@Override
	public int changePassword(String email, String password) {
		// TODO Auto-generated method stub
		return mapper.changePassword(email, password);
	}


	@Override
	public User getUser(String email, String name, String phone) {
		// TODO Auto-generated method stub
		return mapper.getUser(email, name, phone);
	}


	@Override
	public User getUserByEamil(String email) {
		
		return mapper.getUserByEamil(email);
	}


	@Override
	public User getuserById(int id) {
		
		return mapper.getuserById(id);
	}
	
	public int getLastId() {
		// TODO Auto-generated method stub
		return mapper.getLastId();
	}




}
