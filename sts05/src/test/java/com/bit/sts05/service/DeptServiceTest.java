package com.bit.sts05.service;

import static org.junit.Assert.*;

import java.util.Map;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.bit.sts05.model.entity.DeptVo;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
// 원래 이게 돼야하는데, servlet-context.xml에 정의되어 있는 스키마때문에 안 되네요.
// @ContextConfiguration(value = {"classpath:/applicationContext.xml",
//		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Rollback(value=true)
@Transactional // 을 테스트 코드에 붙이면 자동 롤백입니다. // 특정 메소드만 롤백을 안 하고 싶다면 해당 메소드에 롤백을 false로 주면 된다.
public class DeptServiceTest {

	@Inject
	DeptService deptService;
	DeptVo target;
	Model model;
	  
	@Before
	public void setUp() throws Exception {
		target = new DeptVo(90, "test", "test");
		model = new ExtendedModelMap();
	}

	@Test
	public void test1SelectAll() {
		try {
		deptService.selectAll(model);
		Map<String, Object> map = model.asMap();
		assertFalse(map.isEmpty());
		} catch (Exception e) {
			fail("not yet");
		}
	}

	@Test
	public void test4SelectOne() {
		deptService.selectOne(model, target.getDeptno());
		assertTrue(model.containsAttribute("bean")); // 불린타입으로 빈이 존재하면
	}

	@Test
	public void test2InsertOne() {
		try {
			deptService.insertOne(target);
			fail();
		}catch (Exception e) {
			
			
		}
	}

	@Test
	public void test3UpdateOne() {
		try {
		deptService.updateOne(target);
		}catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test5DeleteOne() {
		try {
		deptService.deleteOne(target.getDeptno());
		}catch (Exception e) {
			fail();
		}
	}

}
