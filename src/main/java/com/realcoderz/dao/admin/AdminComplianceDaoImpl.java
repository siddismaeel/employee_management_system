package com.realcoderz.dao.admin;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.realcoderz.business.bean.ComplianceBean;
import com.realcoderz.business.bean.StatusReportBean;
import com.realcoderz.model.Compliance;
import com.realcoderz.model.Department;
import com.realcoderz.model.StatusReport;
import com.realcoderz.util.EntityConversion;


/**
* <h1>AdminComplianceDaoImpl</h1>
* 
* <p>This repository class is the implementation of {@link com.realcoderz.dao.admin.AdminComplianceDao.class} Interface is used to persist or retrieve data of compliance from database</p>
* 
* @author  Ismaeel Siddiqui
* @version 1.0
* @since   2021-05-28
*/

@Repository
@SuppressWarnings("unchecked")
@Transactional("txManager")
public class AdminComplianceDaoImpl implements AdminComplianceDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private EntityConversion entityConversion;
	private static final Logger LOGGER = Logger.getLogger(AdminComplianceDaoImpl.class);
	
	
	/*
	 * @Override public ComplianceBean getCompliance(int complianceId) { // TODO
	 * Auto-generated method stub return null; }
	 */

	/**
	   * This method is used to get all compliance from database
	   * @param No parameter
	   */
	@Override
	public List<ComplianceBean> getAllCompliance() {

		LOGGER.info("starts getAllCompliance method");
		List<ComplianceBean> complianceList = null;

		try {

			complianceList = new ArrayList<ComplianceBean>();

			List<Compliance> allCompliance = (List<Compliance>) entityManager.createQuery("from Compliance")
					.getResultList();

			for (Compliance entity : allCompliance) {

				ComplianceBean com = entityConversion.entityToBean(entity);

				complianceList.add(com);
			}

		} catch (Exception exception) {

			LOGGER.debug("throws getAllCompliance method " + exception);
			throw exception;
		}
		
		LOGGER.info("Ends getAllCompliance method");
		return complianceList;

	}


	/**
	   * This method is used to save a new compliance into database
	   * @param ComplianceBean
	   */
	@Override
	public Integer saveCompliance(ComplianceBean complianceBean) {


		LOGGER.info("starts saveCompliance method");
		Integer complianceId = 0;
		
		Compliance compliance =  entityConversion.beanToEntity(complianceBean);		
		compliance.setStatus("OPEN");
		System.out.println("From dao----------------------->");
		System.out.println(compliance.getFileTitle());
		System.out.println(compliance.getRlType());
		System.out.println(compliance.getComplianceId());
		System.out.println(compliance.getCreateDate());
		System.out.println(compliance.getDepartment().getDeparmentName());
		System.out.println(compliance.getDepartment().getDepartmentId());
		
		 
		try {
			Department department = entityManager.find(Department.class, compliance.getDepartment().getDepartmentId());
			
			compliance.setDepartment(null);
			entityManager.persist(compliance);
			
			compliance.setDepartment(department);
			complianceId = compliance.getComplianceId();;
		} catch (Exception exception) {
			LOGGER.debug("throws saveCompliance method " + exception);
			throw exception;
		}
		
		
		LOGGER.info("Ends saveCompliance method");
		return complianceId;
		
	
	}

	/*
	 * @Override public Integer updateCompliance(ComplianceBean complianceBean) { //
	 * TODO Auto-generated method stub return 0; }
	 * 
	 * @Override public Integer deleteCompliance(ComplianceBean complianceBean) { //
	 * TODO Auto-generated method stub return 0; }
	 */

	/**
	   * This method is used to update as close an existing compliance into database
	   * @param ComplianceBean
	   */
	@Override
	public Integer closeCompliance(ComplianceBean complianceBean) {
		
		Integer id = 0;
		
		
		try {
			
			Compliance compliance = (Compliance) entityManager.createQuery("from Compliance c where c.complianceId = " + complianceBean.getComplianceId()).getSingleResult();
			compliance.setStatus("CLOSED");
			 System.out.println("Closed compliance method called--------------------------------------------------------->");
			id = compliance.getComplianceId();
		
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return id;
	}
	
	/**
	   * This method is used to get all Status reports of particular department from database
	   * @param departmentID
	   */
	@Override
	public List<StatusReportBean> getStatusReportByDepartment(Integer departmentId) {
		
		LOGGER.info("starts saveCompliance method");
		List<StatusReportBean> statusReportBean = null;
		
		
		
		try {
			
			Query query = entityManager.createQuery("from StatusReport s where s.department.departmentId = " + departmentId);
		List<StatusReport> statusReports =	query.getResultList();
			statusReportBean = new ArrayList<StatusReportBean>();
			
			
			for(StatusReport status: statusReports)
			{
				StatusReportBean statusBean = entityConversion.entityToBean(status);
				
				statusReportBean.add(statusBean);
			}
			
		} catch (Exception exception) {
			LOGGER.debug("throws saveCompliance method " + exception);
			throw exception;
		}
		
		
		LOGGER.info("Ends saveCompliance method");
		return statusReportBean;
	}


	/**
	 * This method is used to get Status Report
	 * @param complianceId
	 * @return StatusReportBean
	 */
	@Override
	public List<StatusReportBean> getStusReport(int complianceId) {
		
		List<StatusReportBean> statusReportBeans = null;
		
		try
		{
			List<StatusReport> statusReports = (List<StatusReport>)entityManager.createQuery("from StatusReport s where s.compliance.complianceId = " + complianceId)
					.getResultList();
			
			statusReportBeans = new ArrayList<StatusReportBean>();
			
			
			for(StatusReport report: statusReports)
			{
				StatusReportBean bean = entityConversion.entityToBean(report);
				
				statusReportBeans.add(bean);
			}
			
		
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return statusReportBeans;
	}


	@Override
	public ComplianceBean getCompliance(int complianceId) {
		
		
		ComplianceBean complianceBean = null;
		
		
		try
		{
			Compliance compliance = entityManager.find(Compliance.class, complianceId);
			
			complianceBean = entityConversion.entityToBean(compliance);
		}
		catch(Exception e)
		{
			throw  e;
		}
		
		return complianceBean;
		
	}
	
	

}


