package com.allbareun.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allbareun.web.dao.CertificationDao;
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




}
