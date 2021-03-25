package com.bit.sts05.model;

import static org.junit.Assert.assertFalse;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class DeptDaoTest {
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void test() {
		assertFalse(0==sqlSession.selectList("com.bit.sts05.model.DeptDao.selectAll").size());
	}

}