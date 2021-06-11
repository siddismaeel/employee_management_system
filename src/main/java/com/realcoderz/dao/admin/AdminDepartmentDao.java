package com.realcoderz.dao.admin;

import java.util.List;

import com.realcoderz.business.bean.DepartmentBean;


/**
* <h1>AdminDepartmentDao!</h1>
* 
* <p>This repository Interface is used to persist or retrieve data of departments from database</p>
* 
* @author  Ismaeel Siddiqui
* @version 1.0
* @since   2021-05-28
*/

public interface AdminDepartmentDao {

	/**
	   * This method is used to get a single department object from database
	   * @param departmentId
	   */
	public DepartmentBean getdepartment(int departmentId);

	/**
	   * This method is used to get all departments from database
	   * @param No parameter
	   */
	
	public List<DepartmentBean> getAllDepartment();

	/**
	   * This method is used to save a new department into database
	   * @param departmentBean
	   */
	public DepartmentBean saveDepartment(DepartmentBean departmentBean);

	/*
	 * public DepartmentBean updateDepartment(DepartmentBean departmentBean);
	 * 
	 * public DepartmentBean deleteDepartment(DepartmentBean departmentBean);
	 */
	
}
