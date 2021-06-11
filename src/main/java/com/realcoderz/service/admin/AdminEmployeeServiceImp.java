package com.realcoderz.service.admin;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.business.bean.DepartmentBean;
import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.dao.admin.AdminEmployeeDao;
import com.realcoderz.exceptions.EmployeeAgeException;
import com.realcoderz.util.DateCalculation;

/**
* <h1>AdminEmployeeServiceImp</h1>
* 
* <p>This Service class is implementation of {@link com.realcoderz.service.admin.AdminEmployeeService} Interface is used to call the Dao layer</p>
* 
* @author  Ismaeel Siddiqui
* @version 1.0
* @since   2021-05-28
*/

@Service
public class AdminEmployeeServiceImp implements AdminEmployeeService {

	@Autowired
	private AdminEmployeeDao adminEmployeeDao;
	private static final Logger LOGGER = Logger.getLogger(AdminEmployeeServiceImp.class);
	
	/**
	   * This method is used to get a single employee 
	   * @param employeeId
	   */
	@Override
	public EmployeeBean getEmployee(int employeeId) {
		LOGGER.info("starts getEmployee method");
		LOGGER.info("Ends getEmployee method");
		return adminEmployeeDao.getEmployee(employeeId);
	}
	
	/**
	   * This method is used to get all employees
	   * @param No parameter
	   * @return java.util.List<EmployeeBean>
	   * @throws java.lang.Exception
	   */
	@Override
	public List<EmployeeBean> getAllEmployees() {
		LOGGER.info("starts getAllEmployees method");
		LOGGER.info("Ends getAllEmployees method");
		
		return  adminEmployeeDao.getAllEmployees();
	}
	
	/**
	   * This method is used to save a new employee 
	   * @param employeeBean, departmentBean
	   * @return employee ID as Integer 
	   * @throws java.lang.Exception
	   */
	@Override 
	public Integer saveEmployee(EmployeeBean employeeBean, DepartmentBean departmentBean) throws EmployeeAgeException {
		
		LOGGER.info("starts saveEmployee method");
		
		long age = DateCalculation.getAge(employeeBean.getDob());
		
		if(age < 25)
		{
			throw new EmployeeAgeException();
		}
		
		LOGGER.info("Ends saveEmployee method");
		return adminEmployeeDao.saveEmployee(employeeBean);
	}
	
	/**
	   * This method is used to update an existing employee 
	   * @param employeeBean, departmentBean
	   * @return employee ID as Integer
	   * @throws java.lang.Exception
	   */
	@Override
	public Integer updateEmployee(EmployeeBean employeeBean, DepartmentBean departmentBean) {
		
		LOGGER.info("starts updateEmployee method");
		LOGGER.info("Ends updateEmployee method");
		return adminEmployeeDao.updateEmployee(employeeBean);
	}
	
	/**
	   * This method is used to delete an existing employee 
	   * @param employeeBean, departmentBean
	   * @return employee ID as Integer
	   * @throws java.lang.Exception
	   */
	@Override
	public Integer deleteEmloyee(EmployeeBean employeeBean, DepartmentBean departmentBean) {
		LOGGER.info("starts deleteEmployee method");
		LOGGER.info("Ends deleteEmployee method");
		return adminEmployeeDao.deleteEmloyee(employeeBean);
	}

}
