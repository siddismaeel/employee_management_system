package com.realcoderz.util;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.realcoderz.business.bean.ComplianceBean;
import com.realcoderz.business.bean.DepartmentBean;
import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.business.bean.LoginMasterBean;
import com.realcoderz.business.bean.StatusReportBean;
import com.realcoderz.model.Compliance;
import com.realcoderz.model.Department;
import com.realcoderz.model.Employee;
import com.realcoderz.model.LoginMaster;
import com.realcoderz.model.StatusReport;
import com.realcoderz.service.admin.AdminDepartmentServiceImpl;

@Component
public class EntityConversion {

	private static final Logger LOGGER = Logger.getLogger(EntityConversion.class);
	
	//Bean to entity
	public  Department beanToEntity(DepartmentBean departmentBean)
	{
		LOGGER.info("starts beanToEntity method");
		Department department = new Department();
		
		if(departmentBean != null)
		{
			
			department.setDeparmentName(departmentBean.getDepartmentName());
			department.setDepartmentId(departmentBean.getDepartmentId());
			
		}
		 
		LOGGER.info("ends beanToEntity method");
		return department;
	}
	
	public  Employee beanToEntity(EmployeeBean employeeBean)
	{
		LOGGER.info("starts beanToEntity method");
		Employee employee = new Employee();
		LoginMaster loginMaster = new LoginMaster();
		Department department = new Department();
		
		if(employeeBean != null)
		{ 
			
			employee.setDob(employeeBean.getDob());
			employee.setEmail(employeeBean.getEmail());
			employee.setFirstName(employeeBean.getFirstName());
			employee.setLastName(employeeBean.getLastName());
			
			loginMaster.setUserId(employeeBean.getUserId());
			loginMaster.setPassword(employeeBean.getPassword());
			loginMaster.setRole(employeeBean.getRole());
			
			department.setDepartmentId(employeeBean.getDepartmentId());
			department.setDeparmentName(employeeBean.getDepartmentName());
			
			employee.setDepartment(department);
			employee.setLoginMaster(loginMaster);
			
			
		}
		
		LOGGER.info("ends beanToEntity method");
		return employee;
	}
	
	public  Compliance beanToEntity(ComplianceBean complianceBean)
	{
		LOGGER.info("starts beanToEntity method");
		Compliance compliance = new Compliance();
		Department  department = new Department();
		
		if(complianceBean != null)
		{
			compliance.setCreateDate(complianceBean.getCreateDate());
			compliance.setFileTitle(complianceBean.getFileTitle());
			compliance.setFilePath(complianceBean.getFilePath());
			compliance.setRlType(complianceBean.getRlType());
			compliance.setStatus(complianceBean.getStatus());
			department.setDepartmentId(complianceBean.getDepartmentId());
			department.setDeparmentName(complianceBean.getDepartmentName());
			
			compliance.setDepartment(department);
		}
		
		LOGGER.info("ends beanToEntity method");
		return compliance;
	}
	
	public  StatusReport beanToEntity(StatusReportBean statusReportBean)
	{
		LOGGER.info("starts beanToEntity method");
		StatusReport statusReport = new StatusReport();
		
		if(statusReportBean != null)
		{
			
			statusReport.setComments(statusReportBean.getComments());
			statusReport.setCreateDate(statusReportBean.getCommentDate());
			//Compliance detail
			Compliance compliance = new Compliance();
			compliance.setComplianceId(statusReportBean.getComplianceId());
			
			statusReport.setCompliance(compliance);
			//Employee details
			
			Employee employee = new Employee();
			employee.setEmail(statusReportBean.getEmail());
			employee.setDob(statusReportBean.getDob());
			employee.setEmpId(statusReportBean.getEmpId());
			employee.setFirstName(statusReportBean.getFirstName());
			employee.setLastName(statusReportBean.getLastName());
			
			/* Department details */
			
			Department department = new Department();
			department.setDepartmentId(statusReportBean.getDepartmentId());
			department.setDeparmentName(statusReportBean.getDepartmentName());
			
			//setting department to employee
			
			employee.setDepartment(department);
			
			//setting department to statusReport
			
			statusReport.setDepartment(department);
			
			//setting employee to status report
			
			statusReport.setEmployee(employee);
			
		}
		
		LOGGER.info("ends beanToEntity method");
		return statusReport;
	}
	
	public  LoginMaster beanToEntity(LoginMasterBean loginMasterBean)
	{
		LOGGER.info("starts beanToEntity method");
		LoginMaster  loginMaster = new LoginMaster();
		
		if(loginMasterBean != null)
		{
			loginMaster.setUserId(loginMasterBean.getUserId());
			loginMaster.setRole(loginMasterBean.getRole());
			loginMaster.setPassword(loginMasterBean.getPassword());
			
			
		}
		
		LOGGER.info("ends beanToEntity method");
		return  loginMaster;
	}
	
	//Entity to bean conversion
	


	
	
	public  DepartmentBean entityToBean(Department department)
	{
		LOGGER.info("starts entityToBean method");
		DepartmentBean departmentBean = new DepartmentBean();
		
		if(department != null)
		{
			
			departmentBean.setDepartmentName(department.getDeparmentName());
			departmentBean.setDepartmentId(department.getDepartmentId());
			
		}
		
		LOGGER.info("ends entityToBean method");
		return departmentBean;
	}
	
	public  EmployeeBean entityToBean(Employee employee)
	{
		LOGGER.info("starts entityToBean method");
		EmployeeBean employeeBean = new EmployeeBean();
		
		if(employee != null)
		{
			employeeBean.setEmpId(employee.getEmpId());
			employeeBean.setDob(employee.getDob());
			employeeBean.setEmail(employee.getEmail());
			employeeBean.setFirstName(employee.getFirstName());
			employeeBean.setLastName(employee.getLastName());
			if(employee.getDepartment() != null)
			{
				employeeBean.setDepartmentName(employee.getDepartment().getDeparmentName());
				employeeBean.setDepartmentId(employee.getDepartment().getDepartmentId());
			}
			
			 
			employeeBean.setUserId(employee.getLoginMaster().getUserId());
			employeeBean.setRole(employee.getLoginMaster().getRole());
			employeeBean.setPassword(employee.getLoginMaster().getPassword());
		}
		
		LOGGER.info("ends entityToBean method");
		return employeeBean;
	}
	
	public  ComplianceBean entityToBean(Compliance compliance)
	{
		LOGGER.info("starts entityToBean method");
			ComplianceBean complianceBean = new ComplianceBean();
			
		if(compliance != null)
		{
			complianceBean.setComplianceId(compliance.getComplianceId());
			complianceBean.setCreateDate(compliance.getCreateDate());
			complianceBean.setFileTitle(compliance.getFileTitle());
			complianceBean.setFilePath(compliance.getFilePath());
			complianceBean.setRlType(compliance.getRlType());
			complianceBean.setStatus(compliance.getStatus());
			complianceBean.setDepartmentId(compliance.getDepartment().getDepartmentId());
			complianceBean.setDepartmentName(compliance.getDepartment().getDeparmentName());
			
		} 
		
		LOGGER.info("ends entityToBean method");
		return complianceBean;
	}
	
	public  StatusReportBean entityToBean(StatusReport statusReport)
	{
		LOGGER.info("starts entityToBean method");
		StatusReportBean statusReportBean = new StatusReportBean();
		
		if(statusReport != null)
		{
			//Converting status report information
			statusReportBean.setComments(statusReport.getComments());
			statusReportBean.setCreateDate(statusReport.getCreateDate());
			statusReportBean.setStatusReportId(statusReport.getStatusReportId());
			
			//converting employee information
			
			if(statusReport.getEmployee() != null)
			{
				Employee employee = statusReport.getEmployee();
				statusReportBean.setEmpId(employee.getEmpId());
				statusReportBean.setDob(employee.getDob());
				statusReportBean.setEmail(employee.getEmail());
				statusReportBean.setFirstName(employee.getFirstName());
				statusReportBean.setLastName(employee.getLastName());
				statusReportBean.setEmail(employee.getEmail());
				
				
			}
			
			//setting  department information
			if(statusReport.getDepartment() != null)
			{
				Department department = statusReport.getDepartment();
				
				statusReportBean.setDepartmentId(department.getDepartmentId());
				statusReportBean.setDepartmentName(department.getDeparmentName());
			}
			
			
			//setting compliance information
			
			if(statusReport.getCompliance() != null)
			{
				Compliance compliance = statusReport.getCompliance();
				
				statusReportBean.setComplianceId(compliance.getComplianceId());
				statusReportBean.setFileTitle(compliance.getFileTitle());
				statusReportBean.setFilePath(compliance.getFilePath());
				statusReportBean.setCreateDate(compliance.getCreateDate());
				statusReportBean.setRlType(compliance.getRlType());
				statusReportBean.setStatus(compliance.getStatus());
				
			}
		}
		
		LOGGER.info("ends entityToBean method");
		return statusReportBean;
	}
	
	public  LoginMasterBean entityToBean(LoginMaster loginMaster)
	{
		LOGGER.info("starts entityToBean method");
		LoginMasterBean  loginMasterBean = new LoginMasterBean();
		
		if(loginMaster != null)
		{
			loginMasterBean.setUserId(loginMaster.getUserId());
			loginMasterBean.setRole(loginMaster.getRole());
			loginMasterBean.setPassword(loginMaster.getPassword());
			
			
		}
		
		LOGGER.info("ends entityToBean method");
		return  loginMasterBean;
	}
	

	
}