package com.realcoderz.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.business.bean.DepartmentBean;
import com.realcoderz.dao.admin.AdminDepartmentDao;
import com.realcoderz.dao.admin.AdminDepartmentDaoImpl;
/**
* <h1>AdminDepartmentServiceImpl</h1>
* 
* <p>This Service class is implementation of {@link com.realcoderz.service.admin.AdminDepartmentService} is used to call the Dao layer</p>
* 
* @author  Ismaeel Siddiqui
* @version 1.0
* @since   2021-05-28
*/
@Service
public class AdminDepartmentServiceImpl implements AdminDepartmentService {

	@Autowired
	private AdminDepartmentDao adminDepartmentDao;
	private static final Logger LOGGER = Logger.getLogger(AdminDepartmentServiceImpl.class);
	
	/**
	   * This method is used to get a single department 
	   * @param departmentId
	   */
	@Override
	public DepartmentBean getdepartment(int departmentId) {
		// TODO Auto-generated method stub
		return null;
	}
 
	/**
	   * This method is used to get all departments 
	   * @param No parameter
	   */
	@Override
	public Map<Integer, DepartmentBean> getAllDepartment() {
		LOGGER.info("starts getAllDepartment method");
		Map<Integer, DepartmentBean> departmentMap = new HashMap<Integer, DepartmentBean>();
		
		List<DepartmentBean> allDepartment = adminDepartmentDao.getAllDepartment();
		
		for(DepartmentBean departmentBean : allDepartment)
		{
			departmentMap.put(departmentBean.getDepartmentId(), departmentBean);
		}
		LOGGER.info("Ends getAllDepartment method");
		return departmentMap;
	}

	/**
	   * This method is used to save a new department 
	   * @param departmentBean
	   */
	@Override
	public DepartmentBean saveDepartment(DepartmentBean departmentBean) {
		LOGGER.info("starts saveDepartment method");
		LOGGER.info("Ends saveDepartment method");
		return adminDepartmentDao.saveDepartment(departmentBean);
	}

	@Override
	public DepartmentBean updateDepartment(DepartmentBean departmentBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentBean deleteDepartment(DepartmentBean departmentBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
