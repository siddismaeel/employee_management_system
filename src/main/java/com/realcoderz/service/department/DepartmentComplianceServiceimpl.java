package com.realcoderz.service.department;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.business.bean.ComplianceBean;
import com.realcoderz.dao.admin.AdminComplianceDao;
import com.realcoderz.dao.department.DepartmentComplianceDao;
import com.realcoderz.service.admin.AdminEmployeeServiceImp;
/**
* <h1>DepartmentComplianceServiceimpl</h1>
* 
* <p>This Service class is the implementation of {@link com.realcoderz.service.department.DepartmentComplianceService.class} Interface is used to call the Dao layer</p>
* 
* @author  Aman Srivastava
* @version 1.0
* @since   2021-05-28
*/

@Service
public class DepartmentComplianceServiceimpl implements DepartmentComplianceService {

	private static final Logger LOGGER = Logger.getLogger(DepartmentComplianceServiceimpl.class);

	
	@Autowired
	private DepartmentComplianceDao departmentComplianceDao;
		
	/**
	   * This method is used to get all compliance of a particular department
	   * @param departmentId
	   */
	@Override
	public List<ComplianceBean> getAllCompliance(int departmentId)
	{
		LOGGER.info("starts getAllCompliance method");
		LOGGER.info("Ends getAllCompliance method");
		return departmentComplianceDao.getAllCompliance(departmentId);
	}

	@Override
	public ComplianceBean getCompliance(int complianceId) {
		LOGGER.info("starts getAllCompliance method");
		LOGGER.info("Ends getAllCompliance method");
		return departmentComplianceDao.getCompliance(complianceId);
	}
	
	
}
