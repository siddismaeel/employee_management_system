package com.realcoderz.dao.admin;

import java.util.List;

import com.realcoderz.business.bean.DepartmentBean;
import com.realcoderz.business.bean.EmployeeBean;


/**
* <h1>AdminEmployeeDao</h1>
* 
* <p>This repository Interface is used to persist or retrieve data of Employees from database</p>
* 
* @author  Ismaeel Siddiqui
* @version 1.0
* @since   2021-05-28
*/

public interface AdminEmployeeDao {

	
	/**
	   * This method is used to get a single employee object from database
	   * @param employeeId
	   * @return comp.realcoderz.business.bean.EmployeeBean
	   * @throws java.lang.Exception
	   */
	public EmployeeBean getEmployee(int employeeId);

	/**
	   * This method is used to get all employees objects from database
	   * @param No parameter
	   * @return java.util.List<EmployeeBean>
	   * @throws java.lang.Exception
	   */
	public List<EmployeeBean> getAllEmployees();
	
	/**
	   * This method is used to save a new employee object into database
	   * @param employeeBean
	   * @return employee ID as Integer 
	   * @throws java.lang.Exception
	   */
	public Integer saveEmployee(EmployeeBean employeeBean);

	/**
	   * This method is used to update an existing employee object into database
	   * @param employeeBean
	   * @return employee ID as Integer
	   * @throws java.lang.Exception
	   */
	public Integer updateEmployee(EmployeeBean employeeBean);

	/**
	   * This method is used to delete an existing employee object from database
	   * @param employeeBean
	   * @return employee ID as Integer
	   * @throws java.lang.Exception
	   */
	public Integer deleteEmloyee(EmployeeBean employeeBean);

	/**
	   * This method is used to get all existing employee objects from database
	   * @param No param
	   * @return List<EmployeeBean>
	   * @throws java.lang.Exception
	   */
	public List<EmployeeBean> getEmployeesByDepartment(int departmentId);

}
