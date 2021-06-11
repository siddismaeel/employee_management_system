package com.realcoderz.service.department;

import java.util.List;

import com.realcoderz.business.bean.ComplianceBean;

/**
 * <h1>DepartmentComplianceService!</h1>
 * 
 * <p>This Service Interface is used to call the methods of Dao layer</p>
 * 
 * @author  Aman Srivastava
 * @version 1.0
 * @since   2021-05-28
 */
public interface DepartmentComplianceService {
	
	/**
	   * This method is used to get all compliance of a particular department
	   * @param departmentId
	   */
	public List<ComplianceBean> getAllCompliance(int departmentId);
	
	public ComplianceBean getCompliance(int complianceId);
}

