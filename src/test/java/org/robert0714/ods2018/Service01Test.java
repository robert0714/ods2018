package org.robert0714.ods2018;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Service01Test {
	private Service01 service;

	@Before
	public void setUp() throws Exception {
		service = new Service01();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDemo01() throws Exception {
		service.demo01();;
	}

}
