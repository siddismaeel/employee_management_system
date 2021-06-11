package com.realcoderz.dao.department;

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
import com.realcoderz.dao.admin.AdminComplianceDaoImpl;
import com.realcoderz.model.Compliance;
import com.realcoderz.util.EntityConversion;
/**
* <h1>DepartmentComplianceDaoimpl</h1>
* 
* <p>This repository class is the implementation of {@link com.realcoderz.dao.department.DepartmentComplianceDao.class} Interface is used to persist or retrieve data of compliance of a particular department from database</p>
* 
* @author  Aman Srivastava
* @version 1.0
* @since   2021-05-28
*/

@Repository
@SuppressWarnings("unchecked")
@Transactional("txManager")
public class DepartmentComplianceDaoimpl implements DepartmentComplianceDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private EntityConversion entityConversion;
	private static final Logger LOGGER = Logger.getLogger(DepartmentComplianceDaoimpl.class);
	
	
	/**
	   * This method is used to get all compliance of a particular department by department Id  from database
	   * @param departmentId
	   */
	@Override
	public List<ComplianceBean> getAllCompliance(int departmentId) {
		LOGGER.info("starts getAllCompliance method");
		List<ComplianceBean> complianceList = null;
		
		try {
			System.out.println("inside dao");
			complianceList = new ArrayList<ComplianceBean>();
			
			Query query = entityManager.createQuery("from Compliance c where c.department.departmentId=" + departmentId);
			List<Compliance> allCompliance = query.getResultList();
			for (Compliance entity : allCompliance) {

				ComplianceBean com = entityConversion.entityToBean(entity);
				
				complianceList.add(com);
				System.out.println(entity.getFileTitle());
				System.out.println(entity.getRlType());
			}

		} catch (Exception exception) {
			
			LOGGER.debug("throws getAllCompliance method " + exception);
			throw exception;
		}
		LOGGER.info("Ends getAllCompliance method");
		return complianceList;

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
			throw e;
		}
		
		return complianceBean;
	}
	
	
}
