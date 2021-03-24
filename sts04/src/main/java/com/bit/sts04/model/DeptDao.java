package com.bit.sts04.model;

import java.util.List;

import com.bit.sts04.model.entity.DeptVo;

public interface DeptDao {

	List<DeptVo> selectAll();

	DeptVo selectOne(int key);

	void insertOne(DeptVo bean);

	int updateOnd(DeptVo bean);

	int deleteOne(int key);

}