package com.realcoderz.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.business.bean.ComplianceBean;
import com.realcoderz.dao.employee.EmployeeRlDao;
/**
* <h1>DepartmentComplianceServiceimpl</h1>
* 
* <p>This Service class is the implementation of {@link com.realcoderz.service.employee.ComplianceService.class} Interface is used to call the Dao layer</p>
* 
* @author  Vishal Gupta
* @version 1.0
* @since   2021-05-28
*/

@Service
public class ComplianceServiceImpl implements ComplianceService{
	@Autowired
	private EmployeeRlDao employeeRlDao;

	/**
	   * This method is used to get all compliance of a particular department
	   * @param departmentId
	   */
	public List<ComplianceBean> getAllCompliance(int departmentId) {
		// TODO Auto-generated method stub
	
		return employeeRlDao.getAllCompliance(departmentId);
	}


}
