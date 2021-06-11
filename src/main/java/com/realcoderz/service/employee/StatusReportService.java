package com.realcoderz.service.employee;

import java.util.List;

import com.realcoderz.business.bean.StatusReportBean;
import com.realcoderz.model.StatusReport;

/**
 * <h1>StatusReportService!</h1>
 * 
 * <p>This Service Interface is used to call the methods of Dao layer</p>
 * 
 * @author  Vishal Gupta
 * @version 1.0
 * @since   2021-05-28
 */

public interface StatusReportService {

	/**
	   * This method is used to get Status Report
	   * @param statusReportId
	   */
	public StatusReport getstatusReport(int statusReportId);

	/**
	   * This method is used to get all Status Reports  of a particular employee
	   * @param empId
	   */
	public List<StatusReportBean> getAllstatusReports(int empId);

	
	/**
	 * This method is used to save Status Report
	 * @param statusReportBean
	 */
	public boolean saveStatusReport(StatusReportBean statusReportBean);

	/**
	 * This method is used to update Status Report
	 * @param statusReport
	 */
	public boolean updateStatusReport(StatusReportBean statusReportBean);

	/**
	 * This method is used to delete Status Report
	 * @param statusReport
	 */
	
}
