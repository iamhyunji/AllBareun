package com.allbareun.web.service;

import java.util.Date;
import java.util.List;

import com.allbareun.web.entity.Certification;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalView;

public interface GoalService {

	int insert(Goal goal);
	int update(Goal goal);
	int delete(Goal goal);
	Goal get(int id);
	List<GoalView> getViewList(String categories, String startDate, String endDate, String days, int totalParticipants, String query);

	List<GoalAllView> getAllViewList();
	List<Certification> getCertListById(int goalId);
	
}