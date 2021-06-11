package com.realcoderz.dao.employee;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.realcoderz.business.bean.ComplianceBean;
import com.realcoderz.model.Compliance;
import com.realcoderz.util.EntityConversion;

/**
* <h1>EmployeeRLDaoDaoimp</h1>
* 
* <p>This repository class is the implementation of {@link com.realcoderz.dao.employee.EmployeeRlDao.class} Interface is used to retrieve data of compliance of a particular department from database</p>
* 
* @author  Vishal Gupta
* @version 1.0
* @since   2021-05-28
*/

@Repository
@SuppressWarnings("unchecked")
@Transactional("txManager")


public class EmployeeRlDaoImp implements EmployeeRlDao{
	@Autowired
	EntityConversion entityConversion;
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	   * This method is used to get all compliance of a particular department from database
	   * @param departmentId
	   */
	@Override
	public List<ComplianceBean> getAllCompliance(int departmentId) {
		List<ComplianceBean> listComplianceBean = null;
	//	System.out.println(departmentId);
	
		try {
			listComplianceBean = new ArrayList<ComplianceBean>();
			Query query = entityManager.createQuery("from Compliance c where c.department.departmentId =" + departmentId);
			List<Compliance> listComplianceEntity = query.getResultList();
			for(Compliance entity: listComplianceEntity) {
				ComplianceBean cmp = entityConversion.entityToBean(entity);
			//	System.out.println(cmp.getDetails());
			
				listComplianceBean.add(cmp);
			}
		
			
			
			
		}
		catch (Exception exception) {
	
			throw exception;
		}
		return listComplianceBean;
	}

}
