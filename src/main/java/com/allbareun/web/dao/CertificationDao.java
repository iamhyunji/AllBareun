package com.allbareun.web.dao;

import java.util.List;

import com.allbareun.web.entity.Certification;

public interface CertificationDao {

	List<Certification> getCertListById(int goalId);

}
