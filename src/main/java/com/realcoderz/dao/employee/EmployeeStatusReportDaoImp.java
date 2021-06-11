package com.realcoderz.dao.employee;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.realcoderz.business.bean.StatusReportBean;
import com.realcoderz.model.StatusReport;
import com.realcoderz.util.EntityConversion;

/**
* <h1>EmployeeRLDaoDaoimp</h1>
* 
* <p>This repository class is the implementation of {@link com.realcoderz.dao.employee.EmployeeStatusReportDao.class} Interface is used to save comment and retrieve all status of particular employee from database</p>
* 
* @author  Vishal Gupta
* @version 1.0
* @since   2021-05-28
*/

@Repository
@SuppressWarnings("unchecked")
@Transactional("txManager")
public class EmployeeStatusReportDaoImp implements EmployeeStatusReportDao {@Autowired
	EntityConversion entityConversion;

	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	   * This method is used to get all status of a particular employee from database
	   * @param empId
	   */
	@Override
	public List<StatusReportBean> getAllStatus(int empId) {
		List<StatusReportBean> listStatusReportBean = null;
		try {
			
			listStatusReportBean = new ArrayList<StatusReportBean>();
			Query query = entityManager.createQuery("from StatusReport w where w.employee.empId =" + empId);
			List<StatusReport> listStatusReportEntity = query.getResultList();
			for(StatusReport entity: listStatusReportEntity) {
				StatusReportBean srp =  entityConversion.entityToBean(entity);
				//System.out.println(srp.getComments());
				
				listStatusReportBean.add(srp);
			}
		}catch(Exception exception) {
			throw exception;
		}
		
		return listStatusReportBean;
	}
	
	/**
	   * This method is used to save the comment
	   * @param statusReportBean
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
	/**
	   * This method is used to edit the comment
	   * @param statusReportBean
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
}
