package com.allbareun.web.service;

import java.util.List;

import com.allbareun.web.entity.Goal;

public interface MyPageService {
	Goal get(int id);
	List<Goal> getList();
	int delete(Goal goal);
	int update(Goal goal);
}
