package com.allbareun.web.service;

import java.util.List;

import com.allbareun.web.entity.Cycle;
import com.allbareun.web.entity.Goal;
import com.allbareun.web.entity.GoalAllView;
import com.allbareun.web.entity.GoalCategory;
import com.allbareun.web.entity.GoalView;
import com.allbareun.web.entity.Group;
import com.allbareun.web.entity.Participation;

public interface GoalService {

	int insert(Goal goal, GoalCategory goalCategory, Cycle cycle, Participation participation, Group group);
	int update(Goal goal, GoalCategory goalCategory, Cycle cycle, Participation participation, Group group);
	int delete(Goal goal);
	Goal get(int id);
	GoalAllView getAllView(int id);
	List<GoalView> getViewList();
	List<GoalAllView> getAllViewList(int userId);
	
}