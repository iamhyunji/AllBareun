package com.allbareun.web.dao;

import java.util.List;

import com.allbareun.web.entity.Cycle;

public interface CycleDao {

	int insert(Cycle cycle);

	List<String> getDays(int goalId);

}
