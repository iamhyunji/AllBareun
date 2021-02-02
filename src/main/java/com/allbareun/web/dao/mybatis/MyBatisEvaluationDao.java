package com.allbareun.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allbareun.web.dao.CycleDao;
import com.allbareun.web.dao.EvaluationDao;
import com.allbareun.web.dao.GoalDao;
import com.allbareun.web.entity.Cycle;

@Repository
public class MyBatisEvaluationDao implements EvaluationDao {

	private EvaluationDao mapper;
	
	
	@Autowired
	public MyBatisEvaluationDao(SqlSession session) {
		mapper = session.getMapper(EvaluationDao.class);
	}



	@Override
	public int insert(int userId, int goalId, int answer1, int answer2, int answer3, String explanation, int certificationId) {
		// TODO Auto-generated method stub
		return mapper.insert(userId, goalId, answer1, answer2, answer3, explanation, certificationId);
	}
	
}
