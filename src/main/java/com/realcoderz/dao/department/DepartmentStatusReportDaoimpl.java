package com.realcoderz.dao.department;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.realcoderz.business.bean.ComplianceBean;
import com.realcoderz.business.bean.StatusReportBean;
import com.realcoderz.model.Compliance;
import com.realcoderz.model.StatusReport;
import com.realcoderz.util.EntityConversion;

/**
* <h1>DepartmentStatusReportDaoimpl</h1>
* 
* <p>This repository class is the implementation of {@link com.realcoderz.dao.department.DepartmentStatusReportDao.class} Interface is used to persist or retrieve data of compliance of a particular department from database</p>
* 
* @author  Aman Srivastava
* @version 1.0
* @since   2021-05-28
*/

@Repository
@SuppressWarnings("unchecked")
@Transactional("txManager")
public class DepartmentStatusReportDaoimpl implements DepartmentStatusReportDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private EntityConversion entityConversion;
	
	/**
	   * This method is used to get all Status Report objects of a particular department from database
	   * @param departmentId
	   * @return java.util.List<StatusReportBean>
	   * @throws java.lang.Exception
	   */
	@Override
	public List<StatusReportBean> getAllStatusReport(int departmentId) {
		List<StatusReportBean> statusReportBean = null;
		try {
			statusReportBean = new ArrayList<StatusReportBean>();
			Query query = entityManager.createQuery("from StatusReport s where s.department.departmentId=" + departmentId);
			List<StatusReport> statusReport = query.getResultList();

			for(StatusReport entity : statusReport) {
				StatusReportBean com = entityConversion.entityToBean(entity);

				System.out.println(com.getComments());
				statusReportBean.add(com);
			}

		}catch(Exception e) {
			throw e;
		}
		return statusReportBean;
	}

	/**
	   * This method is used to edit Comments of a particular department from database
	   * @param statusReportBean
	   * @return java.util.List<StatusReportBean>
	   * @throws java.lang.Exception
	   */
	@Override
	public boolean editComment(StatusReportBean statusReportBean) {
		boolean status = false;
		try {
			StatusReport statusReport = entityManager.find(StatusReport.class,statusReportBean.getStatusReportId() );
			statusReport.setComments(statusReportBean.getComments());
			statusReport.setCreateDate( statusReportBean.getCreateDate());
			entityManager.merge(statusReport);
			status = true;
		}catch(Exception ex) {
			throw ex;
		}
		return status;
	}
	
	/**
	 * This method is used to save Comments of a particular department from database
	 * @param statusReportBean
	 * @return java.util.List<StatusReportBean>
	 * @throws java.lang.Exception
	 */
	@Override
	public boolean saveComment(StatusReportBean statusReportBean) {
		StatusReport statusReport = entityConversion.beanToEntity(statusReportBean);
		System.out.println("hello");
		System.out.println(statusReport.getComments());
		System.out.println(statusReport.getCompliance());
		boolean status = false;
		try {
			
			entityManager.persist(statusReport);
			status = true;
		}catch(Exception exception) {
			throw exception;
		
		}
		return status;
		
	}
}
