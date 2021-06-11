package com.realcoderz.service.admin;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.business.bean.ComplianceBean;
import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.business.bean.StatusReportBean;
import com.realcoderz.dao.admin.AdminComplianceDao;
import com.realcoderz.dao.admin.AdminEmployeeDao;
import com.realcoderz.exceptions.RLNotSubmitted;

/**
* <h1>AdminComplianceServiceImpl</h1>
* 
* <p>This Service class is the implementation of {@link com.realcoderz.service.admin.AdminComplianceService.class} Interface is used to call the Dao layer</p>
* 
* @author  Ismaeel Siddiqui
* @version 1.0
* @since   2021-05-28
*/

@Service
public class AdminComplianceServiceImpl implements AdminComplianceService{

	@Autowired
	private AdminComplianceDao adminComplianceDao;
	@Autowired
	private AdminEmployeeDao adminEmployeeDao;
	
	private static final Logger LOGGER = Logger.getLogger(AdminComplianceServiceImpl.class);
	
	@Override
	public ComplianceBean getCompliance(int complianceId) {
		
		return adminComplianceDao.getCompliance(complianceId);
		
	}
	
	/**
	   * This method is used to get all compliance 
	   * @param No parameter
	   */
	@Override
	public List<ComplianceBean> getAllCompliance() {
		LOGGER.info("starts getAllCompliance method");
		LOGGER.info("Ends getAllCompliance method");
		return adminComplianceDao.getAllCompliance();
	}
	
	/**
	   * This method is used to save a new compliance 
	   * @param ComplianceBean
	   */
	@Override
	public Integer saveCompliance(ComplianceBean complianceBean) {
		LOGGER.info("starts saveCompliance method");
		LOGGER.info("Ends saveCompliance method");
		return adminComplianceDao.saveCompliance(complianceBean);
	}

	@Override
	public Integer updateCompliance(ComplianceBean complianceBean) {
		LOGGER.info("starts updateCompliance method");
		LOGGER.info("Ends updateCompliance method");
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer deleteCompliance(ComplianceBean complianceBean) {
		LOGGER.info("starts deleteCompliance method");
		LOGGER.info("Ends deleteCompliance method");
		// TODO Auto-generated method stub
		return 0;
	}
 
	
	/**
	 * This method is used to close a compliance 
	 * @param ComplianceBean
	 */
	@Override
	public Integer closeCompliance(ComplianceBean complianceBean) throws RLNotSubmitted{
		
		List<StatusReportBean> statusReports = adminComplianceDao.getStatusReportByDepartment(complianceBean.getDepartmentId());
		
		List<EmployeeBean> employees = adminEmployeeDao.getEmployeesByDepartment(complianceBean.getDepartmentId());
		
		System.out.println(employees);
		System.out.println(statusReports);
		 
		List<Integer> complianceEmpIds = statusReports.stream().map(e-> e.getEmpId()).collect(Collectors.toList());
		List<Integer> employeesEmpIds = employees.stream().map(e-> e.getEmpId()).collect(Collectors.toList());
		
		
		
		if(! employeesEmpIds.equals(complianceEmpIds))
		{
			throw  new RLNotSubmitted();
			
		}
		
		Integer closeCompliance = adminComplianceDao.closeCompliance(complianceBean);
		
		return closeCompliance;
	}

	@Override
	public List<StatusReportBean> getStatusReport(int complianceId) {
		
		return adminComplianceDao.getStusReport(complianceId);
	}

	
	
}
