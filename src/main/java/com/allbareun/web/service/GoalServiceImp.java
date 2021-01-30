package com.allbareun.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allbareun.web.dao.GoalCategoryDao;
import com.allbareun.web.dao.CertificationDao;
import com.allbareun.web.dao.GoalDao;
import com.allbareun.web.dao.UserDao;
import com.allbareun.web.entity.Cycle;
import com.allbareun.web.entity.CertDetailView;
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
	private CertificationDao certificationDao;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public int insert(Goal goal, GoalCategory goalCategory, Cycle cycle, Participation participation, Group group) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int update(Goal goal, GoalCategory goalCategory, Cycle cycle, Participation participation, Group group) {
		int result = 0;
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
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<CertificationView> getCertViewListById(int goalId) {
		// TODO Auto-generated method stub
		return certificationDao.getCertViewListById(goalId,null,null,null);
	}

	@Override
	public List<CertificationView> getCertViewListById(int goalId, String name, String startDate, String endDate) {
		// TODO Auto-generated method stub
		return certificationDao.getCertViewListById(goalId,name,startDate,endDate);
	}
	
	@Override
	public String getParticipantsId(int goalId) {
		// TODO Auto-generated method stub
		return goalDao.getParticipantsId(goalId);
	}


	@Override
	public List<String> getUserProfile(String ids) {
		List<String> list = new ArrayList<String>();
		
		String[] idStr = ids.split(","); 
		int[] id = Arrays.stream(idStr).mapToInt(Integer::parseInt).toArray();
		for(int i=0; i<id.length; i++) {
			User user = userDao.getById(id[i]);
			String profile = user.getProfile();
			list.add(profile);
		}
		return list;
	}
	@Override
	public List<String> getUserName(String ids) {
		List<String> list = new ArrayList<String>();

		String[] idStr = ids.split(","); 
		int[] id = Arrays.stream(idStr).mapToInt(Integer::parseInt).toArray();
		for(int i=0; i<id.length; i++) {
			User user = userDao.getById(id[i]);
			String name = user.getName();
			list.add(name);
		}
		return list;
	}

	@Override
	public CertDetailView getCertDetailView(int id) {
		// TODO Auto-generated method stub
		return certificationDao.getCertDetailView(id);
	}

	@Override
	public CertDetailView getPrev(int id,int goalId) {
		// TODO Auto-generated method stub
		return certificationDao.getPrev(id,goalId);
	}

	@Override
	public CertDetailView getNext(int id,int goalId) {
		// TODO Auto-generated method stub
		return certificationDao.getNext(id,goalId);
	}



}