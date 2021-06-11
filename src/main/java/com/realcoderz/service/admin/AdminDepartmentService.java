package com.realcoderz.service.admin;

import java.util.Map;

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
public interface AdminDepartmentService {

	/**
	   * This method is used to get a single department 
	   * @param departmentId
	   */
	public DepartmentBean getdepartment(int departmentId);
	
	/**
	   * This method is used to get all departments from database
	   * @param No parameter
	   */
	public Map<Integer, DepartmentBean> getAllDepartment();

	/**
	 * This method is used to save a new department 
	 * @param departmentBean
	 */
	public DepartmentBean saveDepartment(DepartmentBean departmentBean);

	public DepartmentBean updateDepartment(DepartmentBean departmentBean);

	public DepartmentBean deleteDepartment(DepartmentBean departmentBean);



}
