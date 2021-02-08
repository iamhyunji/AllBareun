package com.allbareun.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allbareun.web.dao.GoalDao;
import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalDetailView;
import com.allbareun.web.entity.GoalView;
import com.allbareun.web.entity.Participation;
import com.allbareun.web.entity.User;

@Repository
public class MyBatisGoalDao implements GoalDao {

	private GoalDao mapper;
	
	@Autowired
	public MyBatisGoalDao(SqlSession session) {
		mapper = session.getMapper(GoalDao.class);
	}

	@Override
	public int insert(Goal goal) {
		
		return mapper.insert(goal);
	}

	@Override
	public int update(Goal goal) {
		
		return mapper.update(goal);
	}
	
	public List<GoalView> getViewList(String categories, String startDate, String endDate, String days, int totalParticipants,
			String query,int count,int offset) {

		return mapper.getViewList(categories, startDate, endDate, days, totalParticipants, query, count, offset);
	}

	@Override
	public GoalDetailView getDetailView(int id) {
		// TODO Auto-generated method stub
		return mapper.getDetailView(id);
	}

	@Override
	public List<User> getProfile(int id) {
		// TODO Auto-generated method stub
		return mapper.getProfile(id);
	}

	@Override
	public List<CertificationView> getAuthImages(int id) {
		// TODO Auto-generated method stub
		return mapper.getAuthImages(id);
	}


	@Override
	public Goal get(int id) {

		return mapper.get(id);
	}

	@Override
	public List<GoalAllView> getAllViewList(int userId, String status, String[] categories, int totalParticipants, int achievement, String query) {

		return mapper.getAllViewList(userId, status, categories, totalParticipants, achievement, query);
	}


	@Override
	public List<GoalView> getViewList() {
		// TODO Auto-generated method stub
		return null;
	}



	/*
	 * @Override public int enter1(Participation participation) { // TODO
	 * Auto-generated method stub return mapper.enter(participation); }
	 */

	@Override
	public int enter(Participation participation) {
		// TODO Auto-generated method stub
		 return mapper.enter(participation);
	}
	@Override
	public Goal getLastInserted(int userId) {
		
		return mapper.getLastInserted(userId);
	}

	@Override
	public GoalAllView getAllView(int id) {
		
		return mapper.getAllView(id);
	}
	
	@Override
	public String getParticipantsId(int goalId) {
		// TODO Auto-generated method stub
		return mapper.getParticipantsId(goalId);
	}

	@Override
	public int getinfo(String email) {
		// TODO Auto-generated method stub
		return mapper.getinfo(email);
	}

//	@Override
//	public CertificationView getAuthImage(int id) {
//		// TODO Auto-generated method stub
//		return mapper.getAuthImage(id);
//	}

}
