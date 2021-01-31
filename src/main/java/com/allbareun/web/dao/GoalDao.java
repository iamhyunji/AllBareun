package com.allbareun.web.dao;

import java.util.Date;
import java.util.List;

import com.allbareun.web.entity.Cycle;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalCategory;
import com.allbareun.web.entity.Certification;
import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalDetailView;
import com.allbareun.web.entity.GoalView;
import com.allbareun.web.entity.Group;
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
	List<GoalAllView> getAllViewList(int userId);
	List<GoalView> getViewList(String categories, String startDate, String endDate, String days, int totalParticipants, String query);
	List<User> getProfile(int id);
	CertificationView getAuthImage(int id);

	Goal getLastInserted(int userId);

}
