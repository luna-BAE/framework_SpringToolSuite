package com.bit.sts04;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationContextTest {

	ApplicationContext context;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		context = new GenericXmlApplicationContext("classpath:/applicationContext.xml");
	}

	@Test
	public void testDataSource() {
		assertNotNull(context.getBean(DataSource.class));
	}

}