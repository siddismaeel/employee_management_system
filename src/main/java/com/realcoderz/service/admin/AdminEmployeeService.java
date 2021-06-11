package com.realcoderz.service.admin;

import java.util.List;

import com.realcoderz.business.bean.DepartmentBean;
import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.exceptions.EmployeeAgeException;
/**
* <h1>AdminEmployeeService</h1>
* 
* <p>This Service Interface is used to call the Dao layer</p>
* 
* @author  Ismaeel Siddiqui
* @version 1.0
* @since   2021-05-28
*/

public interface AdminEmployeeService {
	
	/**
	   * This method is used to get a single employee 
	   * @param employeeId
	   * @return comp.realcoderz.business.bean.EmployeeBean
	   * @throws java.lang.Exception
	   */
	public EmployeeBean getEmployee(int employeeId);

	/**
	   * This method is used to get all employees
	   * @param No parameter
	   * @return java.util.List<EmployeeBean>
	   * @throws java.lang.Exception
	   */
	public List<EmployeeBean> getAllEmployees();
	
	/**
	   * This method is used to save a new employee 
	   * @param employeeBean, departmentBean
	   * @return employee ID as Integer 
	   * @throws java.lang.Exception
	   */
	public Integer saveEmployee(EmployeeBean employeeBean, DepartmentBean departmentBean) throws EmployeeAgeException;
	
	/**
	   * This method is used to update an existing employee 
	   * @param employeeBean, departmentBean
	   * @return employee ID as Integer
	   * @throws java.lang.Exception
	   */
	public Integer updateEmployee(EmployeeBean employeeBean, DepartmentBean departmentBean);
	
	/**
	   * This method is used to delete an existing employee
	   * @param employeeBean, departmentBean
	   * @return employee ID as Integer
	   * @throws java.lang.Exception
	   */
	public Integer deleteEmloyee(EmployeeBean employeeBean, DepartmentBean departmentBean);
	
}
