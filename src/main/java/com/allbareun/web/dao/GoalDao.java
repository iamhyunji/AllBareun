package com.allbareun.web.dao;

import java.util.List;

import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalView;


public interface GoalDao {

	Goal get(int id);
	List<GoalView> getViewList();
}
