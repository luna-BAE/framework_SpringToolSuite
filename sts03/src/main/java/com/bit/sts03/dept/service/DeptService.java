package com.bit.sts03.dept.service;

import java.sql.SQLException;

import org.springframework.ui.Model;

import com.bit.sts03.dept.model.entity.DeptVo;

public interface DeptService {

	void setModelList(Model model) throws SQLException;

	void setModelBean(Model model, int deptno) throws SQLException;

	void addBean(DeptVo bean) throws SQLException;

	void updateBean(DeptVo bean) throws SQLException;

	void delete(int deptno) throws SQLException;

}