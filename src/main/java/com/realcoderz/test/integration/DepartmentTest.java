package com.realcoderz.test.integration;

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
import com.realcoderz.service.department.DepartmentComplianceService;
import com.realcoderz.service.department.DepartmentEmployeeService;
import com.realcoderz.service.department.DepartmentStatusReportService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/realcoderz/resources/cst-root-ctx.xml")
@Rollback(true)
@Transactional
public class DepartmentTest {

	@Autowired
	private DepartmentComplianceService departmentComplianceService;
	@Autowired
	private DepartmentEmployeeService departmentEmployeeService;
	@Autowired
	private DepartmentStatusReportService departmentStatusReportService;

	@Before
	public void testMethodBeforeInterceptor() {
		System.out.println("Starting a new Test Method..");
	}

	@After
	public void testMethodAfterInterceptor() {
		System.out.println("End the Test Method..");
	}

	@Test
	public void testgetAllCompliance() throws Exception {

		List<ComplianceBean> complianceList = departmentComplianceService.getAllCompliance(139);

		Assert.assertTrue(complianceList != null);
	}

	@Test
	public void testgetEmployee() throws Exception {

	EmployeeBean employeeBean = departmentEmployeeService.getEmployee(98);
	Assert.assertTrue(employeeBean != null);
	}
	
	@Test
	public void testgetAllEmployees() throws Exception {

		List<EmployeeBean> employeeBeanList = departmentEmployeeService.getAllEmployees(138);
		Assert.assertTrue(employeeBeanList != null);
	}
	
	@Test
	public void testgetStatusReport() throws Exception {
		List<StatusReportBean> statusReportBeanList = departmentStatusReportService.getAllStatusReport(77);
		Assert.assertTrue(statusReportBeanList != null);
	}
	
	@Test
	public void testupdateStatusReport() throws Exception{
	 StatusReportBean statusReportBean = new StatusReportBean();
	 statusReportBean.setStatusReportId(250);
	 statusReportBean.setCreateDate(new Date());
	 statusReportBean.setComments("testing Junit");
	 boolean status = departmentStatusReportService.updateStatusReport(statusReportBean);
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
		boolean status = departmentStatusReportService.saveStatusReport(statusReportBean);
		assertTrue(status != false);
	}
	/*
	 * @Test public void getComplianceTest() { ComplianceBean compliance =
	 * departmentComplianceService.getCompliance(210);
	 * 
	 * Assert.assertTrue(compliance != null); }
	 */
}
