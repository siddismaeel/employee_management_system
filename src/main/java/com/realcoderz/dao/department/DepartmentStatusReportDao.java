package com.realcoderz.dao.department;

import java.util.List;

import com.realcoderz.business.bean.StatusReportBean;

/**
* <h1>DepartmentStatusReportDao</h1>
* 
* <p>This repository Interface is used to persist or retrieve Status Report from database</p>
* 
* @author  Aman Srivastava
* @version 1.0
* @since   2021-05-28
*/
public interface DepartmentStatusReportDao {
	
	/**
	   * This method is used to get all Status Report objects of a particular department from database
	   * @param departmentId
	   * @return java.util.List<StatusReportBean>
	   * @throws java.lang.Exception
	   */
	public List<StatusReportBean> getAllStatusReport(int departmentId);
	
	/**
	   * This method is used to edit comment of a particular employee from database
	   * @param statusReportBean
	   * @return java.util.List<StatusReportBean>
	   * @throws java.lang.Exception
	   */
	public boolean editComment(StatusReportBean statusReportBean);
	
	/**
	 * This method is used to save comment of a particular employee from database
	 * @param statusReportBean
	 * @return java.util.List<StatusReportBean>
	 * @throws java.lang.Exception
	 */
	public boolean saveComment(StatusReportBean statusReportBean);

}
