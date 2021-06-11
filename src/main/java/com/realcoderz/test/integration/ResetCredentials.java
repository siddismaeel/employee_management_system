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
import com.realcoderz.service.EmailService;
import com.realcoderz.service.resetCredentials.ResetCredentialService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:com/realcoderz/resources/cst-root-ctx.xml")
@Rollback(true)
@Transactional
public class ResetCredentials {
	
	@Autowired
	private ResetCredentialService resetCredentialService;
	@Autowired
	private EmailService emailService;
	
	@Before
	public void testMethodBeforeInterceptor() {
		System.out.println("starting a new test method");
	}
	@After
	public void testMethodAfterInterceptor() {
		System.out.println("End the Test Method....");
	}
	
	@Test
	public void TestGetEmployeeByEmail() throws Exception {
		
		EmployeeBean emp=resetCredentialService.getEmployeeByEmail("smlsidd@gmail.com");

	   junit.framework.Assert.assertTrue(emp != null);
	}

	
	@Test
	public void TestUpdatePassword() {
		LoginMasterBean login=new LoginMasterBean();
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean.setUserId(1005);
		employeeBean.setEmpId(118);
		employeeBean.setPassword("1234");
		//login.setPassword("1234");
		EmployeeBean emp=resetCredentialService.updatePassword(employeeBean);
		
		junit.framework.Assert.assertTrue(emp!=null);
	}
	
	@Test
	public void TestEmailService()
	{
		boolean email=emailService.sendEmail("Test", "Junit Testing", "smlsiddiqui6@gmail.com");
		junit.framework.Assert.assertTrue(true);
	}

}


