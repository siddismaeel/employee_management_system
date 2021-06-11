package com.realcoderz.test.integration;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import com.realcoderz.business.bean.DepartmentBean;
import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.business.bean.StatusReportBean;
import com.realcoderz.exceptions.RLNotSubmitted;
import com.realcoderz.service.admin.AdminComplianceService;
import com.realcoderz.service.admin.AdminDepartmentService;
import com.realcoderz.service.admin.AdminEmployeeService;
import com.realcoderz.util.IDGenerator;

import junit.framework.Assert;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:com/realcoderz/resources/cst-root-ctx.xml")
@Rollback(true)
@Transactional
public class AdminTest {
	
	@Autowired
	private AdminEmployeeService adminService;
	@Autowired
	private AdminDepartmentService adminDepartmentService;
	
	@Autowired  
	private AdminComplianceService adminComplianceService;
	
	@Before
	public void testMethodBeforeInterceptor() {
		System.out.println("Starting a new Test Method..");
	}
	
	@After
	public void testMethodAfterInterceptor() {
		System.out.println("End the Test Method..");
	}
	 
	@Test
	public void testFindAllEmployee() throws Exception {
		Collection<EmployeeBean> empList = adminService.getAllEmployees();
		Assert.assertTrue(empList != null);
	}
	 
	@Test
	public void testFindEmployee() throws Exception {
		EmployeeBean employee = adminService.getEmployee(118);
		Assert.assertTrue(employee != null);
	}
	
	@Test
	public void testUpdateEmployeet() throws Exception {
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setFirstName("Ismaeel");
		employeeBean.setEmpId(118);
		Integer empId = adminService.updateEmployee(employeeBean, null);
		Assert.assertTrue(empId != 0);
	}
	
	@Test
	public void testDeleteEmployeet() throws Exception {
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setFirstName("kashif");
		employeeBean.setEmpId(246);
		Integer empId = adminService.deleteEmloyee(employeeBean, null);
		Assert.assertTrue(empId != 0);
	}
	  
	@SuppressWarnings("deprecation")
	@Test
	public void testSaveEmployeet() throws Exception {
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setFirstName("kashif");
		employeeBean.setLastName("Siddiqui");
		employeeBean.setDob(new Date("25/08/1990"));
		employeeBean.setEmail("smlsiddiqui6@gmail.com");
		employeeBean.setPassword(IDGenerator.generatePassword());
		employeeBean.setDepartmentName("IT");
		employeeBean.setDepartmentId(97);
		employeeBean.setRole("HOD");
		
		Integer empId = adminService.saveEmployee(employeeBean, null);
		Assert.assertTrue(empId != 0);
	}
	
	
	// Department test
	
	@Test
	public void testGetAllDepartment() throws Exception {
		
		Map<Integer, DepartmentBean> allDepartment = adminDepartmentService.getAllDepartment();
		Assert.assertTrue(allDepartment != null);
	}
	
	@Test
	public void testSaveDepartment() throws Exception {

		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDepartmentName("IT");
		DepartmentBean saveDepartment = adminDepartmentService.saveDepartment(departmentBean);
		Assert.assertTrue(saveDepartment != null);
	}
	
	
	//Compliance test
	
	@Test
	public void testGetAllCompliance() throws Exception {
		
		List<ComplianceBean> allCompliance = adminComplianceService.getAllCompliance();
		Assert.assertTrue(allCompliance != null);
	}
	
	@Test
	public void testSaveCompliance()
	{
		ComplianceBean complianceBean = new ComplianceBean();
		complianceBean.setCreateDate(new Date());
		complianceBean.setDepartmentId(139);
		complianceBean.setDepartmentName("IT");
		//complianceBean.setDetails("Test Details");
		complianceBean.setRlType("Test rl type");
		
		Integer saveCompliance = adminComplianceService.saveCompliance(complianceBean);
		Assert.assertTrue(saveCompliance != 0);
	}
	
	
	@Test 
	public void closeComplianceTest()
	{
ComplianceBean complianceBean = new ComplianceBean();
		
		complianceBean.setComplianceId(211);
		complianceBean.setStatus("CLOSED");
		Integer closeCompliance = 0;;
		try {
			closeCompliance = adminComplianceService.closeCompliance(complianceBean);
		} catch (RLNotSubmitted e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertTrue(closeCompliance != 0);
		
	}
	
	@Test
	public void getStatusReportTest()
	{
		List<StatusReportBean> statusReportByDepartment = adminComplianceService.getStatusReport(211);
		
		assertTrue( statusReportByDepartment != null);
	}
}
