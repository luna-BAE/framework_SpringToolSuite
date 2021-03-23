package com.bit.sts03.dept.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.sts03.dept.model.DeptDao;
import com.bit.sts03.dept.model.entity.DeptVo;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	DeptDao<DeptVo> deptDao;

	@Override
	public void setModelList(Model model) throws SQLException{
		// selectAll
		model.addAttribute("list", deptDao.selectAll());
	}
	
	@Override
	public void setModelBean(Model model, int deptno) throws SQLException {
		// selectOne & updateOne(+1)
		model.addAttribute("bean", deptDao.selectOne(deptno));
	}
	
	@Override
	public void addBean(DeptVo bean) throws SQLException { // 이 메소드들은 인자가 필요
		deptDao.insertOne(bean);
	}
	
	@Override
	public void updateBean(DeptVo bean) throws SQLException {
		deptDao.updateOne(bean);
	}
	
	@Override
	public void delete(int deptno) throws SQLException {
		deptDao.deleteOne(deptno);
	}
	
}
