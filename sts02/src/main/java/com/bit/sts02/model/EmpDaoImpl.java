package com.bit.sts02.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.bit.sts02.model.entity.EmpVo;

public class EmpDaoImpl implements EmpDao {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;

	@Override
	public List<EmpVo> selectAll() {
		return sqlMapClientTemplate.queryForList("emp.selectAll");
	}

	@Override
	public EmpVo selectOne(int empno) {
		return (EmpVo) sqlMapClientTemplate.queryForObject("emp.selectOne", empno);
	}

	@Override
	public void insertOne(EmpVo bean) {
		sqlMapClientTemplate.insert("emp.insertOne", bean);
	}

	@Override
	public int updateOne(EmpVo bean) {
		return sqlMapClientTemplate.update("emp.updateOne", bean);
	}

	@Override
	public int deleteOne(int empno) {
		return sqlMapClientTemplate.delete("emp.deleteOne", empno);
	}

}
