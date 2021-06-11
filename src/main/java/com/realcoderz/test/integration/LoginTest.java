package com.realcoderz.test.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.business.bean.LoginMasterBean;
import com.realcoderz.service.login.LoginEmployeeService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/realcoderz/resources/cst-root-ctx.xml")
@Rollback(true)
@Transactional
public class LoginTest {

	@Autowired
	private LoginEmployeeService loginEmployeeService;

	@Before
	public void testMethodBeforeInterceptor() {
		System.out.println("Starting a new Test Method..");
	}

	@After
	public void testMethodAfterInterceptor() {
		System.out.println("End the Test Method..");
	}

	@Test
	public void testgetLoginMasterByUserId() throws Exception {

		LoginMasterBean loginBean = loginEmployeeService.getLoginMasterByUserId(1005);

		Assert.assertTrue(loginBean != null);
	}

	@Test
	public void testgetEmployeeByUserId() throws Exception {

		EmployeeBean employeeBean = loginEmployeeService.getEmployeeByUserId(1005);
		Assert.assertTrue(employeeBean != null);
	}

}
