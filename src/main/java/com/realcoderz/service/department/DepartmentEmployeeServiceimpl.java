package com.realcoderz.service.department;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.dao.department.DepartmentEmployeeDao;
import com.realcoderz.service.admin.AdminEmployeeServiceImp;
/**
* <h1>DepartmentEmployeeServiceimpl</h1>
* 
* <p>This Service class is the implementation of {@link com.realcoderz.service.department.DepartmentEmployeeService.class} Interface is used to call the Dao layer</p>
* 
* @author  Aman Srivastava
* @version 1.0
* @since   2021-05-28
*/

@Service
public class DepartmentEmployeeServiceimpl implements DepartmentEmployeeService {
	
	private static final Logger LOGGER = Logger.getLogger(DepartmentEmployeeServiceimpl.class);


	@Autowired
	private DepartmentEmployeeDao departmentEmployeeDao;
	
	/**
	   * This method is used to get a single employee 
	   * @param employeeId
	   */
	@Override
	public EmployeeBean getEmployee(int employeeId) {
		LOGGER.info("starts getEmployee method");
		LOGGER.info("Ends getEmployee method");
		return departmentEmployeeDao.getEmployee(employeeId);
	}

	/**
	   * This method is used to get all employees of a particular department
	   * @param departmentId
	   * @return java.util.List<EmployeeBean>
	   * @throws java.lang.Exception
	   */
	@Override
	public List<EmployeeBean> getAllEmployees(int departmentId) {
		LOGGER.info("starts getAllEmployees method");
		LOGGER.info("Ends getAllEmployees method");
		return  departmentEmployeeDao.getAllEmployees(departmentId);
	}

	
	
	
	
}
