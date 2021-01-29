package com.allbareun.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allbareun.web.dao.GoalDao;
import com.allbareun.web.entity.Certification;
import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalDetailView;
import com.allbareun.web.entity.GoalView;
import com.allbareun.web.entity.User;

@Service
public class GoalServiceImp implements GoalService {

	@Autowired
	private GoalDao goalDao;

	@Override
	public int insert(Goal goal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Goal goal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Goal goal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GoalDetailView get(int id) {
		// TODO Auto-generated method stub
		return goalDao.get(id);
	}

	@Override
	public List<GoalView> getViewList() {
		// TODO Auto-generated method stub
		return goalDao.getViewList();
	}

	@Override
	public List<GoalAllView> getAllViewList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getProfile(int id) {
		// TODO Auto-generated method stub
		return goalDao.getProfile(id);
	}

	@Override
	public CertificationView getImage(int id) {
		// TODO Auto-generated method stub
		return goalDao.getImage(id);
	}

	
	
}