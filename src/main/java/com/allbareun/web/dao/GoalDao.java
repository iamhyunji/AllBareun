package com.allbareun.web.dao;

import java.util.List;

import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalDetailView;
import com.allbareun.web.entity.GoalView;
import com.allbareun.web.entity.Participation;
import com.allbareun.web.entity.User;


public interface GoalDao {

	int insert(Goal goal);
	int update(Goal goal);	
	Goal get(int id);
	
	// -------------------------- View --------------------------
	GoalDetailView getDetailView(int id);
	GoalAllView getAllView(int id);
	List<GoalView> getViewList();
	List<GoalAllView> getAllViewList(int userId, String status, String[] categories, int totalParticipants, int achievement, String query);
	List<User> getProfile(int id);
	List<CertificationView> getAuthImages(int id);
	int enter(Participation participation);
	//CertificationView getAuthImage(int id);
	String getParticipantsId(int goalId);

	Goal getLastInserted(int userId);
	int getinfo(String email);
	List<GoalView> getViewList(String categories, String startDate, String endDate, String days, int totalParticipants,
			String query, int count,int offset);
	int makeGoal(int userId);
	int delete(int goalId);

}
