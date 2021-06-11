package com.realcoderz.dao.admin;

import java.util.List;

import com.realcoderz.business.bean.ComplianceBean;
import com.realcoderz.business.bean.DepartmentBean;
import com.realcoderz.business.bean.StatusReportBean;


/**
* <h1>AdminComplianceDao!</h1>
* 
* <p>This repository Interface is used to persist or retrieve data of compliance from database</p>
* 
* @author  Ismaeel Siddiqui
* @version 1.0
* @since   2021-05-28
*/

public interface AdminComplianceDao {
	
	/* public ComplianceBean getCompliance(int complianceId); */

	/**
	   * This method is used to get all compliance from database
	   * @param No parameter
	   */
	public List<ComplianceBean> getAllCompliance();

	/**
	   * This method is used to save a new compliance into database
	   * @param ComplianceBean
	   */
	public Integer saveCompliance(ComplianceBean complianceBean);

	/*
	 * public Integer updateCompliance(ComplianceBean complianceBean);
	 * 
	 * public Integer deleteCompliance(ComplianceBean complianceBean);
	 */
	/**
	   * This method is used to update as close an existing compliance into database
	   * @param ComplianceBean
	   */
	public Integer closeCompliance(ComplianceBean complianceBean);
	
	/**
	   * This method is used to get all Status reports of particular department from database
	   * @param departmentID
	   */
	public List<StatusReportBean> getStatusReportByDepartment(Integer departmentId);

	/**
	 * This method is used to close Compliance
	 * @param complianceId
	 * @return List<StatusReportBean>
	 */
	public List<StatusReportBean> getStusReport(int complianceId);

	
	public ComplianceBean getCompliance(int complianceId);

}
