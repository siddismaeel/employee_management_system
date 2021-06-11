package com.realcoderz.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.realcoderz.business.bean.DepartmentBean;
import com.realcoderz.model.Department;
import com.realcoderz.util.EntityConversion;

/**
* <h1>AdminDepartmentDaoImpl</h1>
* 
* <p>This repository class is implementation of {@link com.realcoderz.dao.admin.AdminDepartmentDao} is used to persist or retrieve data of departments from database</p>
* 
* @author  Ismaeel Siddiqui
* @version 1.0
* @since   2021-05-28
*/
@Repository
@Transactional("txManager")
public class AdminDepartmentDaoImpl implements AdminDepartmentDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private EntityConversion entityConversion;
	private static final Logger LOGGER = Logger.getLogger(AdminDepartmentDaoImpl.class);
	
	/**
	   * This method is used to get a single department object from database
	   * @param departmentId
	   */
	@Override
	public DepartmentBean getdepartment(int departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	   * This method is used to get all departments from database
	   * @param No parameter
	   */
	@Override
	public List<DepartmentBean> getAllDepartment() {

		LOGGER.info("starts getAllDepartment method");
		List<DepartmentBean> departments = new ArrayList<>();
		
		try {
			departments=new ArrayList<DepartmentBean>();
			
			List<Department> departmentEntity= (List<Department>) entityManager.createQuery("from Department").getResultList();
			
			for (Department entity:departmentEntity){
				DepartmentBean emp= entityConversion.entityToBean(entity);
				
				System.out.println("Department " + entity.getDeparmentName());
				departments.add(emp);
			}
			

		} catch (Exception exception) {

			LOGGER.info("throws getAllDepartment method " + exception);
			throw exception;
		}
		
		LOGGER.info("Ends getAllDepartment method");
		return departments;
	}

	/**
	   * This method is used to save a new department into database
	   * @param departmentBean
	   */
	@Override
	public DepartmentBean saveDepartment(DepartmentBean departmentBean) {
		
		
		LOGGER.info("starts saveDepartment method");
		try
		{
			Department dpartment = entityConversion.beanToEntity(departmentBean);
			entityManager.persist(dpartment);
			
			
		}
		catch(Exception e)
		{
			LOGGER.debug("throws saveDepartment method " + e);
			departmentBean = null;
			throw e;
		}
		
		LOGGER.info("Ends saveDepartment method");
		return departmentBean;
	}

	
	/*
	 * @Override public DepartmentBean updateDepartment(DepartmentBean
	 * departmentBean) { // TODO Auto-generated method stub return null; }
	 * 
	 * @Override public DepartmentBean deleteDepartment(DepartmentBean
	 * departmentBean) { // TODO Auto-generated method stub return null; }
	 */

}
