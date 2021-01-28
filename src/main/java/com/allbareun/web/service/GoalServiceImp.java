package com.allbareun.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allbareun.web.dao.GoalDao;
import com.allbareun.web.entity.Cycle;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalCategory;
import com.allbareun.web.entity.GoalView;
import com.allbareun.web.entity.Group;
import com.allbareun.web.entity.Participation;

@Service
public class GoalServiceImp implements GoalService {

	@Autowired
	private GoalDao goalDao;

	@Override
	public int insert(Goal goal, GoalCategory goalCategory, Cycle cycle, Participation participation, Group group) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Goal goal) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int update(Goal goal, GoalCategory goalCategory, Cycle cycle, Participation participation, Group group) {
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
	public List<GoalView> getViewList() {
		// TODO Auto-generated method stub
		return goalDao.getViewList();
	}

	@Override
	public List<GoalAllView> getAllViewList(int userId) {
		return goalDao.getAllViewList(userId);
	}
	
}