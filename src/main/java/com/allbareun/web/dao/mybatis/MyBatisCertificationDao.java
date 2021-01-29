package com.allbareun.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.allbareun.web.dao.CertificationDao;
import com.allbareun.web.entity.Certification;

@Repository
public class MyBatisCertificationDao implements CertificationDao {

	private CertificationDao mapper;
	
	@Autowired
	public MyBatisCertificationDao(SqlSession session) {
		mapper = session.getMapper(CertificationDao.class);
	}

	@Override
	public List<Certification> getCertListById(int goalId) {
		// TODO Auto-generated method stub
		return mapper.getCertListById(goalId);
	}




}
