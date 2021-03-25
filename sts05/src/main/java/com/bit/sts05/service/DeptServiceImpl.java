package com.bit.sts05.service;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.bit.sts05.model.DeptDao;
import com.bit.sts05.model.entity.DeptVo;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class DeptServiceImpl implements DeptService {

	// 오토와이어와 같지만 자바 외부 라이브러리라서 어디서든 쓸 수 있음, 오토와이어는 스프링에서만 쓸 수 있음, 인젝트는 스프링이 아니어도 동작
	@Inject
	SqlSession sqlSession;
	String dao = DeptDao.class.toString();
	
	@Override
	public void selectAll(Model model) {
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		model.addAttribute("list", deptDao.selectAll());

	}

	@Override
	public void selectOne(Model model, int key) {
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		model.addAttribute("bean", deptDao.selectOne(key));

	}

	@Override
	public void insertOne(DeptVo bean) {
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		deptDao.insertOne(bean);

	}

	@Override
	public void updateOne(DeptVo bean) {
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		deptDao.updateOne(bean);

	}

	@Override
	public void deleteOne(int key) {
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		deptDao.deleteOne(key);

	}

}
