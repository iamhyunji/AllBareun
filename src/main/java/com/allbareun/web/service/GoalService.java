package com.allbareun.web.service;

import java.util.List;

import com.allbareun.web.entity.Goal;

public interface GoalService {

	int insert();
	Goal get(int id);
	List<Goal> getList();
}
