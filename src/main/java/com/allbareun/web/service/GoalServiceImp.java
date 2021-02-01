package com.allbareun.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allbareun.web.dao.GoalCategoryDao;
import com.allbareun.web.dao.CertificationDao;
import com.allbareun.web.dao.CycleDao;
import com.allbareun.web.dao.GoalDao;
import com.allbareun.web.dao.GroupDao;
import com.allbareun.web.entity.Cycle;
import com.allbareun.web.entity.Certification;
import com.allbareun.web.entity.CertificationView;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalCategory;
import com.allbareun.web.entity.GoalDetailView;
import com.allbareun.web.entity.GoalView;
import com.allbareun.web.entity.Group;
import com.allbareun.web.entity.Participation;
import com.allbareun.web.entity.User;

@Service
public class GoalServiceImp implements GoalService {

	@Autowired
	private GoalDao goalDao;
	@Autowired
	GoalCategoryDao goalCategoryDao;
	@Autowired
	CycleDao cycleDao;
	@Autowired
	GroupDao groupDao;
	
	@Autowired
	private CertificationDao certificationDao;

	@Override
	@Transactional
	public int insert(Goal goal, List<GoalCategory> gcList, List<Cycle> cList, List<Group> gList) {
		
		int result = 0;
		goalDao.insert(goal);
		
		Goal insertedGoal = goalDao.getLastInserted(2);
		int goalId = insertedGoal.getId();
		
		// 카테고리
		for(GoalCategory gc : gcList) {
			gc.setGoalId(goalId);
			goalCategoryDao.insert(gc);
		}
		
		// 인증 주기
		for(Cycle c : cList) {
			c.setGoalId(goalId);
			cycleDao.insert(c);
		}
		
		// 지인 그룹
		if(gList != null)
			for(Group g : gList) {
				g.setGoalId(goalId);
				groupDao.insert(g);
			}
				
		result++;
		
		return 0;
	}

	@Override
	public int update(Goal goal) {
		
		int result = 0;
		goalDao.update(goal);
		result++;
		
		return result;
		
	}
	
	@Override
	public int updateRetryGoal(Goal goal, List<GoalCategory> gcList, List<Cycle> cList, List<Group> gList) {
		int result = 0;
		int goalId = goal.getId();
		Goal origin = goalDao.get(goalId);
		
		// 카테고리
		if(gcList != null) {
			goalCategoryDao.delete(goalId);
			
			for(GoalCategory gc : gcList) {
				gc.setGoalId(goalId);
				goalCategoryDao.insert(gc);
			}
		}
		
		// 인증 주기
		if(cList != null) {
			cycleDao.delete(goalId);
			
			for(Cycle c : cList) {
				c.setGoalId(goalId);
				cycleDao.insert(c);
			}
		}
		
		// 지인 그룹
		if ((origin.getPublicStatus() == false && origin.getCount() > 1)
				|| gList != null) {
			groupDao.delete(goalId);
		
			for (Group g : gList) {
				g.setGoalId(goalId);
				groupDao.insert(g);
			}
		}
		
		// 익명 그룹
		if ((origin.getPublicStatus() && origin.getCount() > 1)) {
			groupDao.delete(goalId);

			for (Group g : gList) {
				g.setGoalId(goalId);
				groupDao.insert(g);
			}
		}
		
		goalDao.update(goal);
		result++;
		
		return result;
	}

	@Override
	public int delete(Goal goal) {
		// TODO Auto-generated method stub
		return 0;
	}

	public GoalDetailView getDetailView(int id) {
		// TODO Auto-generated method stub
		return goalDao.getDetailView(id);
	}

	@Override
	public List<GoalView> getViewList(String categories, String startDate,String endDate, String days, int totalParticipants,
			String query) {
		// TODO Auto-generated method stub
		return goalDao.getViewList(categories, startDate, endDate, days, totalParticipants, query);
	}



	@Override
	public List<Certification> getCertListById(int goalId) {
		// TODO Auto-generated method stub
		return certificationDao.getCertListById(goalId);
	}




	public List<User> getProfile(int id) {
		// TODO Auto-generated method stub
		return goalDao.getProfile(id);
	}

	@Override
	public CertificationView getAuthImage(int id) {
		// TODO Auto-generated method stub
		return goalDao.getAuthImage(id);
	}
//	////////////////////////////////////////////////

	@Override
	public Goal get(int id) {
		
		return goalDao.get(id);
	}

	@Override
	public List<GoalAllView> getAllViewList(int userId) {
		return goalDao.getAllViewList(userId);
	}

	@Override
	public GoalAllView getAllView(int id) {
		
		return goalDao.getAllView(id);
	}
	
}