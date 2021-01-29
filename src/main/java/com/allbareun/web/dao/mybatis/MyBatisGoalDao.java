package com.allbareun.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allbareun.web.dao.GoalDao;
import com.allbareun.web.entity.Certification;
import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalDetailView;
import com.allbareun.web.entity.GoalView;
import com.allbareun.web.entity.User;

@Repository
public class MyBatisGoalDao implements GoalDao {

	private GoalDao mapper;
	
	@Autowired
	public MyBatisGoalDao(SqlSession session) {
		mapper = session.getMapper(GoalDao.class);
	}
	
	@Override
	public List<GoalView> getViewList() {
		// TODO Auto-generated method stub
		return mapper.getViewList();
	}

	@Override
	public GoalDetailView get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}

	@Override
	public List<User> getProfile(int id) {
		// TODO Auto-generated method stub
		return mapper.getProfile(id);
	}

	@Override
	public CertificationView getImage(int id) {
		// TODO Auto-generated method stub
		return mapper.getImage(id);
	}

}
