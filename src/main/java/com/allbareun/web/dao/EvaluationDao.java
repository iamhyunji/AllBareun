package com.allbareun.web.dao;

import java.util.Date;
import java.util.List;

import com.allbareun.web.entity.CertDetailView;
import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.Evaluation;
import com.allbareun.web.entity.EvaluationView;

public interface EvaluationDao {

	 List<EvaluationView> getReport(int uid);
	List<EvaluationView> categoryChart(int uid);
	List<EvaluationView> getDoneLineChart(int id, int uid);
	//List<EvaluationView> getDoneBarChart(int id, int uid);

	int insert(int userId, int goalId, int answer1, int answer2, int answer3, String explanation, int certificationId);

	//List<EvaluationView> getDoneBarChart(String startDate);
	List<EvaluationView> getDoneBarChart(int varChartCount, String startDate, String endDate, int id, int month);
	List<EvaluationView> getMyGoalLineChart(int id);
	List<EvaluationView> getDoneBar(int barChartCount, String startDate, String endDate, int id);
	
	List<EvaluationView> getVarChartCount(int id, int uid);
}


	
