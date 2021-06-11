package com.realcoderz.dao.employee;

import java.util.List;

import com.realcoderz.business.bean.ComplianceBean;

/**
* <h1>EmployeeRLDao!</h1>
* 
* <p>This repository Interface is used to retrieve data of compliance from database</p>
* 
* @author  Vishal Gupta
* @version 1.0
* @since   2021-05-28
*/


public interface EmployeeRlDao {
	
	/**
	   * This method is used to get all compliance of a particular department from database
	   * @param departmentId
	   */
	public List<ComplianceBean> getAllCompliance(int departmentId);
}
