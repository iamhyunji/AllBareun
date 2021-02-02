package com.allbareun.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allbareun.web.dao.ParticipationDao;

@Repository
public class MyBatisParticipationDao implements ParticipationDao{
	
	@Autowired
	SqlSession session;

	@Override
	public int delete(int goalId, int userId) {
		
		return session.getMapper(ParticipationDao.class).delete(goalId, userId);
	}

}
