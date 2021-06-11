package com.realcoderz.dao.department;

import java.util.List;

import com.realcoderz.business.bean.ComplianceBean;

/**
* <h1>DepartmentComplianceDao!</h1>
* 
* <p>This repository Interface is used to persist or retrieve data of compliance from database</p>
* 
* @author  Aman Srivastava
* @version 1.0
* @since   2021-05-28
*/

public interface DepartmentComplianceDao {

	/**
	   * This method is used to get all compliance of a particular department by department Id  from database
	   * @param departmentId
	   */
	public List<ComplianceBean> getAllCompliance(int departmentId);

	/**
	   * This method is used to get a of a particular department by compliance Id  from database
	   * @param complianceId
	   * @return ComplianceBean
	   * @exception java.lang.Exception
	   */
	public ComplianceBean getCompliance(int complianceId);
	
}
