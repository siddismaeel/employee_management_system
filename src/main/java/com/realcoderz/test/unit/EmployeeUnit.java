package com.realcoderz.test.unit;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.realcoderz.business.bean.ComplianceBean;
import com.realcoderz.business.bean.StatusReportBean;
import com.realcoderz.dao.employee.EmployeeRlDao;
import com.realcoderz.dao.employee.EmployeeStatusReportDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:com/realcoderz/resources/cst-root-ctx.xml")
@Rollback(true)
@Transactional
public class EmployeeUnit {
	@Autowired
	EmployeeRlDao employeeRlDao;
	
	@Autowired
	EmployeeStatusReportDao employeeStatusReportDao;
	
	@Before
	public void testMethodBeforeInterceptor() {
		System.out.println("Starting a new Test Method..");
	}
	
	@After
	public void testMethodAfterInterceptor() {
		System.out.println("End the Test Method..");
	}
	
	@Test
	public void getAllCompliance()
	{
	
		List<ComplianceBean> listComplianceBean  = employeeRlDao.getAllCompliance(2);
		
		assertTrue(listComplianceBean != null);
	}
	
	@Test
	public void  getAllStatus() {
		
		List<StatusReportBean> listStatusReportBean = employeeStatusReportDao.getAllStatus(2);
		assertTrue(listStatusReportBean != null);
	}
	
	@Test
	public void testeditStatusReport() throws Exception{
	 StatusReportBean statusReportBean = new StatusReportBean();
	 statusReportBean.setStatusReportId(250);
	 statusReportBean.setCreateDate(new Date());
	 statusReportBean.setComments("testing Junit");
	 boolean status = employeeStatusReportDao.editComment(statusReportBean);
	 assertTrue(status != false);
	}
	
	@Test
	public void saveComment()
	{
		StatusReportBean statusReportBean = new StatusReportBean();
		statusReportBean.setCreateDate(new Date());
		statusReportBean.setEmpId(2);
		statusReportBean.setComplianceId(2);
		statusReportBean.setDepartmentId(2);
		statusReportBean.setComments("unit testing");
		boolean status = employeeStatusReportDao.saveComment(statusReportBean);
		assertTrue(status != false);
	}
	
}