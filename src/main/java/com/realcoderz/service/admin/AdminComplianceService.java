package com.realcoderz.service.admin;

import java.util.List;

import com.realcoderz.business.bean.ComplianceBean;
import com.realcoderz.business.bean.StatusReportBean;
import com.realcoderz.exceptions.RLNotSubmitted;

/**
 * <h1>AdminComplianceService!</h1>
 * 
 * <p>This Service Interface is used to call the methods of Dao layer</p>
 * 
 * @author  Ismaeel Siddiqui
 * @version 1.0
 * @since   2021-05-28
 */

public interface AdminComplianceService {
	
	public ComplianceBean getCompliance(int complianceId);


	/**
	   * This method is used to get all compliance 
	   * @param No parameter
	   */
	public List<ComplianceBean> getAllCompliance();

	
	/**
	 * This method is used to save Compliance
	 * @param complianceBean
	 */
	public Integer saveCompliance(ComplianceBean complianceBean);

	public Integer updateCompliance(ComplianceBean complianceBean);

	public Integer deleteCompliance(ComplianceBean complianceBean);

	/**
	 * This method is used to close Compliance
	 * @param complianceBean
	 */
	public Integer closeCompliance(ComplianceBean complianceBean) throws RLNotSubmitted;
	
	/**
	 * This method is used to close Compliance
	 * @param complianceId
	 * @return List<StatusReportBean>
	 */
	public List<StatusReportBean> getStatusReport(int complianceId);
}
