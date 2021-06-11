package com.realcoderz.service.department;

import java.util.List;

import com.realcoderz.business.bean.StatusReportBean;

/**
 * <h1>DepartmentStatusReportService!</h1>
 * 
 * <p>This Service Interface is used to call the methods of Dao layer</p>
 * 
 * @author  Aman Srivastava
 * @version 1.0
 * @since   2021-05-28
 */

public interface DepartmentStatusReportService {
	
	/**
	   * This method is used to get all Status Report  of a particular department
	   * @param departmentId
	   */
	public List<StatusReportBean> getAllStatusReport(int departmentId);
	
	/**
	   * This method is used to update Status Report
	   * @param statusReportBean
	   */
	public boolean updateStatusReport(StatusReportBean statusReportBean);
	
	/**
	 * This method is used to save Status Report
	 * @param statusReportBean
	 */
	public boolean saveStatusReport(StatusReportBean statusReportBean);
}
