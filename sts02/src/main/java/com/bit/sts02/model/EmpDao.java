package com.bit.sts02.model;

import java.util.List;

import com.bit.sts02.model.entity.EmpVo;

public interface EmpDao {

	List<EmpVo> selectAll();
	
	EmpVo selectOne(int empno);
	
	void insertOne(EmpVo bean);
	
	int updateOne(EmpVo bean);
	
	int deleteOne(int empno);
	
}
