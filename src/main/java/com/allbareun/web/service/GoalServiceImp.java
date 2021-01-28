package com.allbareun.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allbareun.web.dao.GoalDao;
import com.allbareun.web.entity.Goal;

@Service
public class GoalServiceImp implements GoalService {

	@Autowired
	private GoalDao goalDao;
	


	@Override
	public int insert() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Goal get(int id) {
		// TODO Auto-generated method stub
		return goalDao.get(id);
	}
	
	public List<Goal> getList() {
		return goalDao.getList();
	}
}
