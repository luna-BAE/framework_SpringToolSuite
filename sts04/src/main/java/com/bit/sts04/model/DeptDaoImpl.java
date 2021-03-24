package com.bit.sts04.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.sts04.model.entity.DeptVo;

@Repository
public class DeptDaoImpl implements DeptDao {

	@Autowired
	SqlSession session;
	
	@Override
	public List<DeptVo> selectAll(){
		return session.selectList("dept.selectAll");
	}
	
	@Override
	public DeptVo selectOne(int key) {
		return session.selectOne("dept.selectOne", key);
	}
	
	@Override
	public void insertOne(DeptVo bean) {
		session.insert("dept.insertOne", bean);
	}
	
	@Override
	public int updateOnd(DeptVo bean) {
		return session.update("dept.updateOne", bean);
	}
	
	@Override
	public int deleteOne(int key) {
		return session.delete("dept.deleteOne", key);
	}
}
