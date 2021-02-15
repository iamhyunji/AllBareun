package com.allbareun.web.service;

import java.util.Date;
import java.util.List;

import com.allbareun.web.entity.Calendar;
import com.allbareun.web.entity.CertDetailView;
import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.Cycle;
import com.allbareun.web.entity.EvaluationView;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllParticipantsView;
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
	int delete(int goalId);
	Goal get(int id);

	// -------------------------- View --------------------------
	GoalAllView getAllView(int id);
	List<GoalAllView> getAllViewList(int userId, String status, String[] categories, int totalParticipants, int achievement, String query);
	
	List<GoalView> getViewList(String categories, String startDate, String endDate, String days, int totalParticipants, String query);
	List<GoalView> getViewList(String categories, String startDate, String endDate, String days, int totalParticipants,
			String query, int count,int offset);
	GoalDetailView getDetailView(int id);
	List<CertificationView> getAuthImages(int id);
	List<GoalAllParticipantsView> getProfile(int id);
	
	List<CertificationView> getCertViewListById(int goalId);
	List<CertificationView> getCertViewListById(int goalId, String name, String startDate, String endDate);
	String getParticipantsId(int goalId);
	List<String> getUserName(String ids);
	List<User> getUserProfile(String ids);
	CertDetailView getCertDetailView(int id);
	CertDetailView getPrev(int id,int goalId);
	CertDetailView getNext(int id,int goalId);
	int authImageInsert(int id,int goalId,String authImage);
	int deleteAuthImage(int id, int goalId, String fileName);
	int enter(Participation participation);
	int certAndEvalInsert(int goalId, int userId, String filePath, int answer1, int answer2, int answer3,String explanation);
	int getinfo(String email);
	int getUserIdByEmail(String name);
	int retryGoal(Goal goal, List<GoalCategory> gcList, List<Cycle> cList, List<Group> gList, int newGoalId);

	List<EvaluationView> getReport(int uid);
	List<EvaluationView> categoryChart(int uid);
	List<EvaluationView> getDoneLineChart(int id, int uid);
	//List<EvaluationView> getDoneBarChart(int id, int uid);
	int deleteGoalFromUser(Goal goal, List<GoalCategory> gcList, List<Cycle> cList, List<Group> gList);

	//List<CertificationView> getVideoImage(int id);

	List<String> getDays(int goalId);
	int makeGoal(int userId);
	boolean isValidUserByEamil(String email);
	User getUser(int id);
	Date getStartDate(int id);
	Date getEndDate(int id);
	//List<EvaluationView> getDoneBarChart(String startDate);
	Integer getVarChartCount(int id, int uid);
	List<EvaluationView> getDoneBarChart(int barChartCount, String startDate, int id);
	/* List<EvaluationView> getMyGoalLineChart(int id); */
	int getReportBarChartCount(int uid);
	//List<CertificationView> getVideoImage(int id, int userId);
	List<CertificationView> getVideoImage(int id);
	//List<CertificationView> getVideoImage(int id, int userId);
	List<GoalAllView> getInvitedList(int userId, String[] categories, String query);
	int rejectGoal(int goalId, int userId);
	int acceptGoal(int challengeGoalId, int userId);
	List<Calendar> getByUserId(Calendar cal);

}