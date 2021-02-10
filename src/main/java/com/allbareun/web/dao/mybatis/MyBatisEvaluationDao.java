package com.allbareun.web.dao.mybatis;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//github.com/cyon13/AllBareun.git
import com.allbareun.web.dao.EvaluationDao;
import com.allbareun.web.entity.EvaluationView;

@Repository
public class MyBatisEvaluationDao implements EvaluationDao{

	private EvaluationDao mapper;
	
	@Autowired
	public MyBatisEvaluationDao(SqlSession session) {
		mapper = session.getMapper(EvaluationDao.class);
	}

	@Override
	public List<EvaluationView> getReport(int uid) {
		// TODO Auto-generated method stub
		return mapper.getReport(uid);
	}

	@Override
	public List<EvaluationView> categoryChart(int uid) {
		// TODO Auto-generated method stub
		return mapper.categoryChart(uid);
	}

	@Override
	public List<EvaluationView> getDoneLineChart(int id, int uid) {
		// TODO Auto-generated method stub
		return mapper.getDoneLineChart(id,uid);
	}

//	@Override
//	public List<EvaluationView> getDoneBarChart(int id, int uid) {
//		// TODO Auto-generated method stub
//		return mapper.getDoneBarChart(id,uid);
//	}


	@Override
	public int insert(int userId, int goalId, int answer1, int answer2, int answer3, String explanation, int certificationId) {
		// TODO Auto-generated method stub
		return mapper.insert(userId, goalId, answer1, answer2, answer3, explanation, certificationId);
	}

	@Override
	public List<EvaluationView> getDoneBarChart(String startDate) {
		// TODO Auto-generated method stub
		return mapper.getDoneBarChart(startDate);
	}


	
}
