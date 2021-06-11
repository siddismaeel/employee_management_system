package com.realcoderz.service.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.business.bean.StatusReportBean;
import com.realcoderz.dao.department.DepartmentStatusReportDao;

/**
 * <h1>DepartmentStatusReportServiceimpl</h1>
 * 
 * <p>
 * This Service class is the implementation of
 * {@link com.realcoderz.service.department.DepartmentStatusReportService.class}
 * Interface is used to call the Dao layer
 * </p>
 * 
 * @author Aman Srivastava
 * @version 1.0
 * @since 2021-05-28
 */
@Service
public class DepartmentStatusReportserviceimpl implements DepartmentStatusReportService {

	@Autowired
	private DepartmentStatusReportDao departmentStatusReportDao;

	/**
	 * This method is used to get all Status Report of a particular department
	 * 
	 * @param departmentId
	 * @return java.util.List<StatusReportBean>
	 * @throws java.lang.Exception
	 */
	@Override
	public List<StatusReportBean> getAllStatusReport(int departmentId) {
		return departmentStatusReportDao.getAllStatusReport(departmentId);
	}

	/**
	 * This method is used to update Status Report of a particular department
	 * 
	 * @param statusReportBean
	 * @return java.util.List<StatusReportBean>
	 * @throws java.lang.Exception
	 */
	@Override
	public boolean updateStatusReport(StatusReportBean statusReportBean) {

		return departmentStatusReportDao.editComment(statusReportBean);
	}

	/**
	 * This method is used to save Status Report of a particular department
	 * 
	 * @param statusReportBean
	 * @return java.util.List<StatusReportBean>
	 * @throws java.lang.Exception
	 */
	@Override
	public boolean saveStatusReport(StatusReportBean statusReportBean) {

		return departmentStatusReportDao.saveComment(statusReportBean);
	}
}
