package com.allbareun.web.dao;

import java.util.List;

import com.allbareun.web.entity.Certification;
import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalDetailView;
import com.allbareun.web.entity.GoalView;
import com.allbareun.web.entity.User;


public interface GoalDao {
	
	// ======================================= View ==========================================
	List<GoalView> getViewList();
	GoalDetailView get(int id);
	List<User> getProfile(int id);
	CertificationView getImage(int id);

}
