package com.realcoderz.service.department;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.realcoderz.business.bean.EmployeeBean;

/**
 * <h1>DepartmentEmployeeeService!</h1>
 * 
 * <p>This Service Interface is used to call the methods of Dao layer</p>
 * 
 * @author  Aman Srivastava
 * @version 1.0
 * @since   2021-05-28
 */

public interface DepartmentEmployeeService {
	
	/**
	   * This method is used to get a single employee
	   * @param employeeId
	   */
	public EmployeeBean getEmployee(int employeeId);

	/**
	   * This method is used to get all employees of a particular department
	   * @param departmentId
	   */
	public List<EmployeeBean> getAllEmployees(int departmentId);

}
