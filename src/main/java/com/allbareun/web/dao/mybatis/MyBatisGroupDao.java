package com.allbareun.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allbareun.web.dao.GroupDao;
import com.allbareun.web.entity.Group;

@Repository
public class MyBatisGroupDao implements GroupDao {
	
	@Autowired
	SqlSession session;

	@Override
	public int insert(Group group) {
		
		return session.getMapper(GroupDao.class).insert(group);
	}
	
	@Override
	public int delete(int goalId, int userId) {

		return session.getMapper(GroupDao.class).delete(goalId, userId);
	}

}
