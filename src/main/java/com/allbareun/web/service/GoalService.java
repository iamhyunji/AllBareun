package com.allbareun.web.service;

import java.util.List;

import com.allbareun.web.entity.Cycle;
import com.allbareun.web.entity.Evaluation;
import com.allbareun.web.entity.EvaluationView;
import com.allbareun.web.entity.CertDetailView;
import com.allbareun.web.entity.Certification;
import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalCategory;
import com.allbareun.web.entity.GoalDetailView;
import com.allbareun.web.entity.GoalView;
import com.allbareun.web.entity.Group;
import com.allbareun.web.entity.Participation;
import com.allbareun.web.entity.User;

public interface GoalService {

	int insert(Goal goal, List<GoalCategory> gcList, List<Cycle> cList, List<Group> gList);
	int update(Goal goal);
	int delete(Goal goal);
	Goal get(int id);

	// -------------------------- View --------------------------
	GoalAllView getAllView(int id);
	List<GoalAllView> getAllViewList(int userId, String status);
	
	List<GoalView> getViewList(String categories, String startDate, String endDate, String days, int totalParticipants, String query);
	
	GoalDetailView getDetailView(int id);
	List<CertificationView> getAuthImages(int id);
	List<User> getProfile(int id);
	
	List<CertificationView> getCertViewListById(int goalId);
	List<CertificationView> getCertViewListById(int goalId, String name, String startDate, String endDate);
	String getParticipantsId(int goalId);
	List<String> getUserName(String ids);
	List<String> getUserProfile(String ids);
	CertDetailView getCertDetailView(int id);
	CertDetailView getPrev(int id,int goalId);
	CertDetailView getNext(int id,int goalId);
	int authImageInsert(int id,int goalId,String authImage);
	int deleteAuthImage(int id, int goalId, String fileName);
	int enter(Participation participation);
	int getinfo(String email);
	int getUserIdByEmail(String name);
	int retryGoal(Goal goal, List<GoalCategory> gcList, List<Cycle> cList, List<Group> gList);
	List<EvaluationView> getReport(int uid);
	List<EvaluationView> categoryChart(int uid);
	List<EvaluationView> getDoneLineChart(int id, int uid);
	List<EvaluationView> getDoneBarChart(int id, int uid);
}