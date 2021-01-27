package com.allbareun.web.service;

import java.util.List;

import com.allbareun.web.entity.Goal;

public interface MyGoalService {
	int insert(Goal goal);
	Goal get(int id);
	int update(Goal goal);
	List<Goal> getList();
}
