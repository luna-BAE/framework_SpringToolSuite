package com.bit.sts04.model;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bit.sts04.model.entity.DeptVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class DeptDaoTest {
	
	DeptVo target;

	@Autowired
	DeptDao deptDao;

	@Before
	public void setUp() throws Exception {
		target = new DeptVo(82, "test", "test");
	}
	
	@After
	public void tearDown() throws Exception {
		try {
				deptDao.insertOne(target);
		} catch (Exception e) {
		}
	}

//	@Test
//	public void testDataSource() {
//		// assertNotNull(dataSource);
//	}
	
	@Test
	public void testSelectAll() {
		assertNotNull(deptDao.selectAll());
		assertFalse(deptDao.selectAll().size()==0);
	}

	@Test
	public void testSelectOne() {
		
		assertEquals(target, deptDao.selectOne(target.getDeptno()));
	}

	@Test
	public void testInsertOne() {
		try {
			deptDao.insertOne(target);
			fail("not yet implemented");
		} catch (Exception e) {
		}
	}

	@Test
	public void testUpdateOnd() {
		assertEquals(1, deptDao.updateOnd(target));
	}

	@Test
	public void testDeleteOne() {
		assertEquals(1, deptDao.deleteOne(target.getDeptno()));
	}

}
