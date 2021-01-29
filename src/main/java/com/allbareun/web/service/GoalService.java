package com.allbareun.web.service;

import java.util.List;

import com.allbareun.web.entity.Certification;
import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalDetailView;
import com.allbareun.web.entity.GoalView;
import com.allbareun.web.entity.User;

public interface GoalService {

	int insert(Goal goal);
	int update(Goal goal);
	int delete(Goal goal);
	
	//=========view======================================
	
	GoalDetailView get(int id);
	List<GoalView> getViewList();
	List<GoalAllView> getAllViewList();
	CertificationView getImage(int id);
	List<User> getProfile(int id);
	
}