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
import com.realcoderz.business.bean.DepartmentBean;
import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.business.bean.StatusReportBean;
import com.realcoderz.dao.admin.AdminComplianceDao;
import com.realcoderz.dao.admin.AdminDepartmentDao;
import com.realcoderz.dao.admin.AdminEmployeeDao;
import com.realcoderz.util.IDGenerator;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:com/realcoderz/resources/cst-root-ctx.xml")
@Rollback(true)
@Transactional
public class AdminUnit {
	
	@Autowired
	private AdminEmployeeDao adminEmployeedao;
	@Autowired
	private AdminDepartmentDao adminDepartmentdao;
	
	@Autowired  
	private AdminComplianceDao adminCompliancedao;
	
	@Before
	public void testMethodBeforeInterceptor() {
		System.out.println("Starting a new Test Method..");
	}
	
	@After
	public void testMethodAfterInterceptor() {
		System.out.println("End the Test Method..");
	}
	
	//Testing for admin employeeDAo
	
	@Test
	public void getAllEmployeeTest()
	{
		List<EmployeeBean> allEmployees = adminEmployeedao.getAllEmployees();
		
		assertTrue(allEmployees != null);
	}
	
	@Test
	public void getEmployeeTest()
	{
		EmployeeBean employee = adminEmployeedao.getEmployee(1005);
		
		assertTrue(employee != null);
	}
	
	/* Test method to save employee */
	@Test
	public void saveEmployeeTest()
	{
		EmployeeBean employeeBean = new EmployeeBean();
		
		employeeBean.setDob(new Date("25/08/1990"));
		employeeBean.setEmail("smlsiddiqui6@gmail.com");
		employeeBean.setPassword(IDGenerator.generatePassword());
		employeeBean.setDepartmentName("IT");
		employeeBean.setDepartmentId(97);
		employeeBean.setRole("HOD");
		
		Integer savedEmployee = adminEmployeedao.saveEmployee(employeeBean);
		
		assertTrue(savedEmployee != null);
	}
	
	/* Test Method to update employee */
	@Test
	public void updateEmployeeTest()
	{
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setFirstName("Ismaeel");
		employeeBean.setEmpId(118);
		Integer empId = adminEmployeedao.updateEmployee(employeeBean);
		Assert.assertTrue(empId != 0);
	}
	
	/* Test method to delete employee */
	
	@Test
	public void deleteEmloyeeTest()
	{
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean.setFirstName("kashif");
		employeeBean.setEmpId(118);
		Integer empId = adminEmployeedao.deleteEmloyee(employeeBean);
		Assert.assertTrue(empId != 0);
	}
	
	/* Test method to get all employees by department */
	@Test
	public void getEmployeesByDepartmentTest()
	{
		List<EmployeeBean> allEmployees = adminEmployeedao.getEmployeesByDepartment(139);

		assertTrue(allEmployees != null);
	}
	
	//Testing for admin employeeDAo
	
	/* method for testing getAllCompliance method */
	
	@Test
	public void getAllComplianceTest()
	{
		List<ComplianceBean> allCompliance = adminCompliancedao.getAllCompliance();
		Assert.assertTrue(allCompliance != null);
	}
	
	/* Testing for saveCompilance method */
	
	@Test
	public void saveComplianceTest()
	{
		ComplianceBean complianceBean = new ComplianceBean();
		complianceBean.setCreateDate(new Date());
		complianceBean.setDepartmentId(139);
		complianceBean.setDepartmentName("IT");
		//complianceBean.setDetails("Test Details");
		complianceBean.setRlType("Test rl type");
		
		Integer saveCompliance = adminCompliancedao.saveCompliance(complianceBean);
		Assert.assertTrue(saveCompliance != 0);
	}
	
	/* Testing for closeCompliance method */
	@Test
	public void closeComplianceTest()
	{
		ComplianceBean complianceBean = new ComplianceBean();
		
		complianceBean.setComplianceId(210);
		complianceBean.setStatus("CLOSED");
		Integer closeCompliance = adminCompliancedao.closeCompliance(complianceBean);
		
		assertTrue(closeCompliance != 0);
		
	}
	
	/* Testing for getStatusReportByDepartment method */
	
	@Test
	public void getStatusReportByDepartmentTest()
	{
		List<StatusReportBean> statusReportByDepartment = adminCompliancedao.getStatusReportByDepartment(139);
		
		assertTrue( statusReportByDepartment != null);
	}
	
	
	@Test
	public void getStatusReportTest()
	{
		List<StatusReportBean> statusReportByDepartment = adminCompliancedao.getStusReport(211);
		
		assertTrue( statusReportByDepartment != null);
	}
	
	//AdminDepartmentDao test
	
	/* testing method for getAllDepartment() */
	@Test
	public void  getAllDepartmentTest()
	{
		List<DepartmentBean> allDepartment = adminDepartmentdao.getAllDepartment();
		assertTrue(allDepartment.size() > 0);
	}
	
	
	
	
	
}
