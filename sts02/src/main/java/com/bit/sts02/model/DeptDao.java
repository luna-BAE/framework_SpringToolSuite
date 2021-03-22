package com.bit.sts02.model;

import java.util.List;

import com.bit.sts02.model.entity.DeptVo;

public interface DeptDao {

	List<DeptVo> selectAll(); // 전체 조회
	
	DeptVo selectOne(int deptno); // 특정 레코드 조회
	
	void insertOne(DeptVo bean); // 레코드 삽입
	
	int updateOne(DeptVo bean); // 레코드 수정
	
	int deleteOne(int deptno); // 특정 레코드 삭제
	
}
