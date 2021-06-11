package com.realcoderz.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.business.bean.StatusReportBean;
import com.realcoderz.dao.employee.EmployeeStatusReportDao;
import com.realcoderz.model.StatusReport;

/**
* <h1>StatusReportServiceImpl</h1>
* 
* <p>This Service class is the implementation of {@link com.realcoderz.service.employee.StatusReportService.class} Interface is used to call the Dao layer</p>
* 
* @author  Vishal Gupta
* @version 1.0
* @since   2021-05-28
*/

@Service
public class StatusreportServiceImpl implements StatusReportService {
	

	@Autowired
	private EmployeeStatusReportDao employeeStatusReport;

	/**
	   * This method is used to get Status Report
	   * @param statusReportId
	   */
	public StatusReport getstatusReport(int statusReportId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	   * This method is used to get all Status Reports  of a particular employee
	   * @param empId
	   */
	public List<StatusReportBean> getAllstatusReports(int empId) {
		// TODO Auto-generated method stub
		return employeeStatusReport.getAllStatus(empId);
	}

	/**
	 * This method is used to save Status Report
	 * @param statusReportBean
	 */
	public boolean saveStatusReport(StatusReportBean statusReportBean) {
		// TODO Auto-generated method stub
		return employeeStatusReport.saveComment(statusReportBean);
	}

	/**
	 * This method is used to update Status Report
	 * @param statusReport
	 */
	public boolean updateStatusReport(StatusReportBean statusReportBean) {
		
		return employeeStatusReport.editComment(statusReportBean);
	}

	
	

}
