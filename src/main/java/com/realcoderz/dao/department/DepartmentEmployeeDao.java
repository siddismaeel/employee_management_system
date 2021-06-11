package com.realcoderz.dao.department;

import java.util.List;

import com.realcoderz.business.bean.EmployeeBean;

/**
* <h1>DepartmentEmployeeDao</h1>
* 
* <p>This repository Interface is used to persist or retrieve data of Employees from database</p>
* 
* @author  Aman Srivastava
* @version 1.0
* @since   2021-05-28
*/

public interface DepartmentEmployeeDao {
	
	/**
	   * This method is used to get a single employee object from database
	   * @param employeeId
	   * @return comp.realcoderz.business.bean.EmployeeBean
	   * @throws java.lang.Exception
	   */
	public EmployeeBean getEmployee(int employeeId);

	/**
	   * This method is used to get all employees objects of a particular department from database
	   * @param departmentId
	   * @return java.util.List<EmployeeBean>
	   * @throws java.lang.Exception
	   */
	public List<EmployeeBean> getAllEmployees(int departmentId);
	
}
