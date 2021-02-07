package com.allbareun.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allbareun.web.dao.GoalCategoryDao;
import com.allbareun.web.dao.CertificationDao;
import com.allbareun.web.dao.CycleDao;
import com.allbareun.web.dao.EvaluationDao;
import com.allbareun.web.dao.GoalDao;
import com.allbareun.web.dao.GroupDao;
import com.allbareun.web.dao.ParticipationDao;
import com.allbareun.web.dao.UserDao;
import com.allbareun.web.entity.Cycle;
import com.allbareun.web.entity.Evaluation;
import com.allbareun.web.entity.EvaluationView;
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
	private GoalCategoryDao goalCategoryDao;
	@Autowired
	private CycleDao cycleDao;
	@Autowired
	private GroupDao groupDao;
	@Autowired
	private ParticipationDao participationDao;
	
	@Autowired
	private CertificationDao certificationDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private EvaluationDao evaluationDao;
	
	@Override
	@Transactional
	public int insert(Goal goal, List<GoalCategory> gcList, List<Cycle> cList, List<Group> gList) {
		
		int result = 0;
		goalDao.insert(goal);
		
		Goal insertedGoal = goalDao.getLastInserted(goal.getUserId());
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
		
		return result;
	}

	@Override
	public int update(Goal goal) {
		
		int result = 0;
		goalDao.update(goal);
		result++;
		
		return result;
		
	}
	
	@Override
	public int retryGoal(Goal goal, List<GoalCategory> gcList, List<Cycle> cList, List<Group> gList) {
		int result = 0;
		
		int goalId = goal.getId();
		int userId = goal.getUserId();
		
		Goal origin = goalDao.get(goalId);
		boolean originPub = origin.getPublicStatus();
		int originTotalParticipants = origin.getTotalParticipants();
		
		
		
		// -------------------------- 전처리 --------------------------
		// 개인
		if(!originPub && originTotalParticipants == 1 || userId == origin.getUserId()) {
			goal.setUserId(0);
			goalDao.update(goal);
		}
		// 지인 그룹
		else if (!originPub && originTotalParticipants > 1) {
			groupDao.delete(goalId, userId);
			
			if(gList != null) {
				String originUserIds = goalDao.getAllView(goalId).getParticipantIds();
				String[] stringIds = originUserIds.split(",");
				int[] ids = new int[stringIds.length];
				
				for(int i=0; i < stringIds.length; i++)
					ids[i] = Integer.parseInt(stringIds[i]);
				
				for(Group g : gList) {
					int newUserId = g.getRequestReceiveUserId();				
					if(IntStream.of(ids).anyMatch(x -> x == newUserId))
						groupDao.delete(goalId, newUserId);
				}
			}
		}
		// 익명 그룹
		else if (originPub && originTotalParticipants > 1)
			participationDao.delete(goalId, userId);
		
		
		
		// -------------------------- 후처리 --------------------------
		if(goal.getUserId() == 0)
			goal.setUserId(userId);
		
		this.insert(goal, gcList, cList, gList);
		
		
		
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
	public List<CertificationView> getAuthImages(int id) {
		// TODO Auto-generated method stub
		return goalDao.getAuthImages(id);
	}
//	////////////////////////////////////////////////

	@Override
	public Goal get(int id) {
		
		return goalDao.get(id);
	}

	@Override
	public List<GoalAllView> getAllViewList(int userId, String status) {
		
		return goalDao.getAllViewList(userId, status);
	}

	@Override
	public GoalAllView getAllView(int id) {
		
		return goalDao.getAllView(id);
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

	@Override
	public int authImageInsert(int id,int goalId,String authImage) {
		// TODO Auto-generated method stub
		return certificationDao.insert(id,goalId,authImage);
	}

	@Override
	public int deleteAuthImage(int id, int goalId, String fileName) {
		// TODO Auto-generated method stub
		return certificationDao.deleteAuthImage(id,goalId,fileName);
	}



	public int enter(Participation participation) {
		return goalDao.enter(participation);
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getinfo(String email) {
		// TODO Auto-generated method stub
		return goalDao.getinfo(email);
	}
	public int getUserIdByEmail(String email) {
		
		return userDao.getUserId(email);
	}

	@Override
	public List<EvaluationView> getReport(int uid) {
		// TODO Auto-generated method stub
		return evaluationDao.getReport(uid);
	}

	@Override
	public List<EvaluationView> categoryChart(int uid) {
		// TODO Auto-generated method stub
		return evaluationDao.categoryChart(uid);
	}

	@Override
	public List<EvaluationView> getDoneLineChart(int id, int uid) {
		// TODO Auto-generated method stub
		return evaluationDao.getDoneLineChart(id,uid);
	}

	@Override
	public List<EvaluationView> getDoneBarChart(int id, int uid) {
		// TODO Auto-generated method stub
		return evaluationDao.getDoneBarChart(id,uid);
	}

}