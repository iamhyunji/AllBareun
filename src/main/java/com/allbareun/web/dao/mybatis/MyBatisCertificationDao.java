package com.allbareun.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allbareun.web.dao.CertificationDao;
import com.allbareun.web.entity.CertDetailView;
import com.allbareun.web.entity.Certification;
import com.allbareun.web.entity.CertificationView;

@Repository
public class MyBatisCertificationDao implements CertificationDao {

	private CertificationDao mapper;
	
	@Autowired
	public MyBatisCertificationDao(SqlSession session) {
		mapper = session.getMapper(CertificationDao.class);
	}



	@Override
	public List<CertificationView> getCertViewListById(int goalId, String name, String startDate, String endDate) {
		// TODO Auto-generated method stub
		return mapper.getCertViewListById(goalId,name,startDate,endDate);
	}



	@Override
	public CertDetailView getCertDetailView(int id) {
		// TODO Auto-generated method stub
		return mapper.getCertDetailView(id);
	}



	@Override
	public CertDetailView getPrev(int id,int goalId) {
		// TODO Auto-generated method stub
		return mapper.getPrev(id,goalId);
	}



	@Override
	public CertDetailView getNext(int id,int goalId) {
		// TODO Auto-generated method stub
		return mapper.getNext(id,goalId);
	}



	@Override
	public int insert(int id, int goalId,String authImage) {
		// TODO Auto-generated method stub
		return mapper.insert(id,goalId,authImage);
	}



	@Override
	public int deleteAuthImage(int id, int goalId, String fileName) {
		// TODO Auto-generated method stub
		return mapper.deleteAuthImage(id, goalId, fileName);
	}



	@Override
	public Certification getLast(int userId, int goalId) {
		// TODO Auto-generated method stub
		return mapper.getLast(userId, goalId);
	}



	@Override
	public List<CertificationView> getVideoImage(int id) {
		// TODO Auto-generated method stub
		return mapper.getVideoImage(id);
	}


}
