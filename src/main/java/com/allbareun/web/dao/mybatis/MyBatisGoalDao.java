package com.allbareun.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allbareun.web.dao.GoalDao;
import com.allbareun.web.entity.Cycle;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalCategory;
import com.allbareun.web.entity.GoalView;
import com.allbareun.web.entity.Group;
import com.allbareun.web.entity.Participation;

@Repository
public class MyBatisGoalDao implements GoalDao {

	private GoalDao mapper;
	
	@Autowired
	public MyBatisGoalDao(SqlSession session) {
		mapper = session.getMapper(GoalDao.class);
	}
	
	@Override
	public int update(Goal goal) {
		
		return mapper.update(goal);
	}
	
	@Override
	public Goal get(int id) {

		return mapper.get(id);
	}
	
	@Override
	public GoalAllView getAllView(int id) {
		
		return mapper.getAllView(id);
	}
	
	@Override
	public List<GoalView> getViewList() {
		// TODO Auto-generated method stub
		return mapper.getViewList();
	}

	@Override
	public List<GoalAllView> getAllViewList(int userId) {
		return mapper.getAllViewList(userId);
	}

}
