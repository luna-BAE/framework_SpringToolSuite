package com.bit.sts03.dept.model;

import java.sql.SQLException;
import java.util.List;

public interface DeptDao<T> {

	List<T> selectAll() throws SQLException;
	T selectOne(int key) throws SQLException;
	void insertOne(T t) throws SQLException;
	int updateOne(T t) throws SQLException;
	int deleteOne(int key) throws SQLException;
	
	
}
