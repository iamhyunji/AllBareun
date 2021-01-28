package com.allbareun.web.dao;

import java.util.List;

import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalView;


public interface GoalDao {
	
	List<GoalView> getViewList();
	List<GoalAllView> getAllViewList(int userId);
	
}
