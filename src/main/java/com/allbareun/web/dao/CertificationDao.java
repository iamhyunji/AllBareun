package com.allbareun.web.dao;

import java.util.List;

import com.allbareun.web.entity.CertDetailView;
import com.allbareun.web.entity.Certification;
import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.EvaluationView;
import com.allbareun.web.entity.Participation;

public interface CertificationDao {


	int insert(int id, int goalId,String authImage);


	List<CertificationView> getCertViewListById(int goalId, String name, String startDate, String endDate);

	CertDetailView getCertDetailView(int id);

	CertDetailView getPrev(int id,int goalId);

	CertDetailView getNext(int id,int goalId);


	int deleteAuthImage(int id, int goalId, String fileName);


	Certification getLast(int userId, int goalId);


	//List<CertificationView> getVideoImage(int id);


	Integer getVarChartCount(int id, int uid);


	int getReportBarChartCount(int uid);


	List<CertificationView> getVideoImage(int id);


	//List<CertificationView> getVideoImage(int id, int userId);





}
