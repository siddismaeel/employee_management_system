package com.realcoderz.dao.employee;

import java.util.List;

import com.realcoderz.business.bean.StatusReportBean;
/**
* <h1>EmployeeStatusReportDao!</h1>
* 
* <p>This repository Interface is used to save comment and retrieve all status of particular employee from database</p>
* 
* @author  Vishal Gupta
* @version 1.0
* @since   2021-05-28
*/
public interface EmployeeStatusReportDao {
	
	/**
	   * This method is used to get all status of a particular employee from database
	   * @param empId
	   */
	public List<StatusReportBean> getAllStatus(int empId);
	
	/**
	   * This method is used to save the comment
	   * @param statusReportBean
	   */
	public boolean saveComment(StatusReportBean statusReportBean);

	/**
	   * This method is used to edit the comment
	   * @param statusReportBean
	   */
	public boolean editComment(StatusReportBean statusReportBean);
}
