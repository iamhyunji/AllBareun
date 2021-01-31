package com.allbareun.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allbareun.web.dao.GoalCategoryDao;
import com.allbareun.web.entity.GoalCategory;

@Repository
public class MyBatisGoalCategoryDao implements GoalCategoryDao {
	
	@Autowired
	private SqlSession session;

	@Override
	public int insert(GoalCategory goalCategory) {
		
		return session.getMapper(GoalCategoryDao.class).insert(goalCategory);
	}
	
	@Override
	public int update(GoalCategory goalCategory) {
		
		return session.getMapper(GoalCategoryDao.class).update(goalCategory);
	}
	
}
