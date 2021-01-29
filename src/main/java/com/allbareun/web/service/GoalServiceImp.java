package com.allbareun.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allbareun.web.dao.CertificationDao;
import com.allbareun.web.dao.GoalDao;
import com.allbareun.web.entity.Certification;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalView;

@Service
public class GoalServiceImp implements GoalService {

	@Autowired
	private GoalDao goalDao;
	
	@Autowired
	private CertificationDao certificationDao;

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
	public Goal get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoalView> getViewList(String categories, String startDate,String endDate, String days, int totalParticipants,
			String query) {
		// TODO Auto-generated method stub
		return goalDao.getViewList(categories, startDate, endDate, days, totalParticipants, query);
	}

	@Override
	public List<GoalAllView> getAllViewList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Certification> getCertListById(int goalId) {
		// TODO Auto-generated method stub
		return certificationDao.getCertListById(goalId);
	}




}