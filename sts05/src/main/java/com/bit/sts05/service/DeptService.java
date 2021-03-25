package com.bit.sts05.service;

import org.springframework.ui.Model;

import com.bit.sts05.model.entity.DeptVo;

public interface DeptService {

	// select는 결과를 화면에 보여줘야 하므로 model을 인자로 받음
	void selectAll(Model model);
	void selectOne(Model model, int key);
	void insertOne(DeptVo bean);
	void updateOne(DeptVo bean);
	void deleteOne(int key);
	
}