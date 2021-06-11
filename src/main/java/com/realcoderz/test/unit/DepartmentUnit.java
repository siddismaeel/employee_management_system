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
import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.business.bean.StatusReportBean;
import com.realcoderz.dao.department.DepartmentComplianceDao;
import com.realcoderz.dao.department.DepartmentEmployeeDao;
import com.realcoderz.dao.department.DepartmentStatusReportDao;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/realcoderz/resources/cst-root-ctx.xml")
@Rollback(true)
@Transactional
public class DepartmentUnit {
	@Autowired
	private DepartmentComplianceDao departmentComplianceDao;
	@Autowired
	private DepartmentEmployeeDao departmentEmployeeDao;
	@Autowired
	private DepartmentStatusReportDao departmentStatusReportDao;

	@Before
	public void testMethodBeforeInterceptor() {
		System.out.println("Starting a new Test Method..");
	}

	@After
	public void testMethodAfterInterceptor() {
		System.out.println("End the Test Method..");
	}

	@Test
	public void testgetAllCompliance() {
		List<ComplianceBean> allCompliance = departmentComplianceDao.getAllCompliance(22);
		assertTrue(allCompliance != null);
	}

	@Test
	public void testgetEmployee() {
		EmployeeBean employeeBean = departmentEmployeeDao.getEmployee(260);
		assertTrue(employeeBean != null);
	}

	@Test
	public void testgetAllEmployee() {
		List<EmployeeBean> employeeBean = departmentEmployeeDao.getAllEmployees(260);
		assertTrue(employeeBean != null);
	}

	@Test
	public void testgetAllStatusReport() {
		List<StatusReportBean> statusReportBean = departmentStatusReportDao.getAllStatusReport(260);
		assertTrue(statusReportBean != null);

	}
	
	@Test
	public void testupdateStatusReport() throws Exception{
	 StatusReportBean statusReportBean = new StatusReportBean();
	 statusReportBean.setStatusReportId(250);
	 statusReportBean.setCreateDate(new Date());
	 statusReportBean.setComments("testing Junit");
	 boolean status = departmentStatusReportDao.editComment(statusReportBean);
	 assertTrue(status != false);
	}
	
	@Test
	public void testsaveComment() throws Exception {
		StatusReportBean statusReportBean = new StatusReportBean();
		statusReportBean.setCreateDate(new Date());
		statusReportBean.setComments("testing");
		statusReportBean.setComplianceId(5);
		statusReportBean.setDepartmentId(4);
		statusReportBean.setEmpId(6);
		boolean status = departmentStatusReportDao.saveComment(statusReportBean);
		assertTrue(status != false);
	}
	
	
	/*
	 * @Test public void getComplianceTest() { ComplianceBean compliance =
	 * departmentComplianceDao.getCompliance(210);
	 * 
	 * Assert.assertTrue(compliance != null); }
	 */
}
