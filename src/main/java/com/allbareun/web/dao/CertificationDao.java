package com.allbareun.web.dao;

import java.util.List;

import com.allbareun.web.entity.Certification;
import com.allbareun.web.entity.CertificationView;

public interface CertificationDao {




	List<CertificationView> getCertViewListById(int goalId, String name, String startDate, String endDate);


}
