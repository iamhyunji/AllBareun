package com.allbareun.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allbareun.web.dao.GoalDao;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalView;

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
	public Goal get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
