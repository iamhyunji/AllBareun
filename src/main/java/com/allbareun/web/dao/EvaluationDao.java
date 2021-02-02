package com.allbareun.web.dao;

public interface EvaluationDao {



	int insert(int userId, int goalId, int answer1, int answer2, int answer3, String explanation, int certificationId);

}
