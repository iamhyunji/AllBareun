package com.allbareun.web.dao;

import java.util.Date;
import java.util.List;

import com.allbareun.web.entity.Certification;
import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalDetailView;
import com.allbareun.web.entity.GoalView;
import com.allbareun.web.entity.User;


public interface GoalDao {
	
	List<GoalView> getViewList(String categories, String startDate, String endDate, String days, int totalParticipants, String query);
	GoalDetailView getDetailView(int id);
	List<User> getProfile(int id);
	CertificationView getAuthImage(int id);
	Goal get(int id);

}
