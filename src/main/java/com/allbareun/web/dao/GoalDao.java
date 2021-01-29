package com.allbareun.web.dao;

import java.util.Date;
import java.util.List;

import com.allbareun.web.entity.GoalView;


public interface GoalDao {
	
	List<GoalView> getViewList(String categories, String startDate, String endDate, String days, int totalParticipants, String query);
}
