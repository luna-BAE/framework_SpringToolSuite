package com.bit.sts02.model;

import java.util.List;

import com.bit.sts02.model.entity.DeptVo;

public interface DeptDao {

	List<DeptVo> selectAll(); // ��ü ��ȸ
	
	DeptVo selectOne(int deptno); // Ư�� ���ڵ� ��ȸ
	
	void insertOne(DeptVo bean); // ���ڵ� ����
	
	int updateOne(DeptVo bean); // ���ڵ� ����
	
	int deleteOne(int deptno); // Ư�� ���ڵ� ����
	
}
