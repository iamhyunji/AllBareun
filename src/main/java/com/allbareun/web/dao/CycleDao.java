package com.allbareun.web.dao;

import com.allbareun.web.entity.Cycle;

public interface CycleDao {

	int insert(Cycle cycle);
	int delete(int goalId);

}
