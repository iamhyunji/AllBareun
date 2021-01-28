package com.allbareun.web.dao;

import com.allbareun.web.entity.User;

public interface UserDao {

	int isValid(String email, String password);
	User get(String email, String password);
	String getEmail(String name, String phone);
	String getPassword(String email, String name, String phone);

}
