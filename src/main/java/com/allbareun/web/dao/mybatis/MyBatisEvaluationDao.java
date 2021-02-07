package com.allbareun.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allbareun.web.dao.CertificationDao;
import com.allbareun.web.dao.CycleDao;
import com.allbareun.web.dao.EvaluationDao;
import com.allbareun.web.entity.CertDetailView;
import com.allbareun.web.entity.Certification;
import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.Evaluation;
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

	@Override
	public List<EvaluationView> getDoneBarChart(int id, int uid) {
		// TODO Auto-generated method stub
		return mapper.getDoneBarChart(id,uid);
	}

	


}
