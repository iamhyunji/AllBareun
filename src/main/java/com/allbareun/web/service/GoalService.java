package com.allbareun.web.service;

import java.util.List;

import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalView;

public interface GoalService {

	int insert(Goal goal);
	int update(Goal goal);
	int delete(Goal goal);
	Goal get(int id);
	List<GoalView> getViewList();
	List<GoalAllView> getAllViewList();
	
}