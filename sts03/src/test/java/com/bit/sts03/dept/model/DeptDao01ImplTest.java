package com.bit.sts03.dept.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.bit.sts03.dept.model.entity.DeptVo;

/*
 * �� �׽�Ʈ�� ��� �޼ҵ��� ������ ���Ŀ� �ٷ� �ѹ�Ǵ� ��Ȳ
 * �׽�Ʈ ���ҽ��� �ִ� applicationContext.xml�� auto commit�� false�� �����صξ��� ����
 * ������ ���� �����ͺ��̽��� ������ �ִ� ���� �ƴ�
 * ���� ���� �����ͺ��̽��� ������ �־�� �ȵǴ� ��
 */
public class DeptDao01ImplTest {
	
	DeptDao<DeptVo> deptDao;
	
	static DeptVo target;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		target = new DeptVo(90, "test", "test");
	}

	@Before
	public void setUp() throws Exception {
		ApplicationContext context;
		context = new GenericXmlApplicationContext("classpath:/applicationContext.xml");
		deptDao = context.getBean(DeptDao.class);
		DataSource dataSource = context.getBean(DataSource.class);
		((org.apache.commons.dbcp.BasicDataSource)dataSource).setDefaultAutoCommit(false);
	}

	@Test
	public void testSelectAll() throws SQLException {
		assertNotNull(deptDao.selectAll());
	}

	@Test
	public void testSelectOne() throws SQLException {
		assertEquals(target,deptDao.selectOne(target.getDeptno()));
	}

	@Test
	public void testInsertOne() throws Exception {
		
		try {
			deptDao.insertOne(target);
			fail("�Է� ����");
			} catch (Exception e) {
		}
	}

	@Test
	public void testUpdateOne() throws SQLException {
		DeptVo edit = new DeptVo(target.getDeptno(), "edit", "edit");
		assertSame(1,deptDao.updateOne(edit));
	}

	@Test
	public void testDeleteOne() throws SQLException {
		assertSame(1,deptDao.deleteOne(target.getDeptno()));
	}

}
