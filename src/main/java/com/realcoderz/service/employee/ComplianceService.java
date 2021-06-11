package com.realcoderz.service.employee;

import java.util.List;

import com.realcoderz.business.bean.ComplianceBean;

/**
 * <h1>ComplianceService!</h1>
 * 
 * <p>This Service Interface is used to call the methods of Dao layer</p>
 * 
 * @author  Vishal Gupta
 * @version 1.0
 * @since   2021-05-28
 */

public interface ComplianceService {

	//public Compliance getCompliance(int complianceId);

	/**
	   * This method is used to get all compliance of a particular department
	   * @param departmentId
	   */
	public List<ComplianceBean> getAllCompliance(int departmentId);

	//public boolean saveCompliance(Compliance compliance);

	//public boolean updateCompliance(Compliance compliance);

	//public boolean deleteCompliance(Compliance compliance);
}
