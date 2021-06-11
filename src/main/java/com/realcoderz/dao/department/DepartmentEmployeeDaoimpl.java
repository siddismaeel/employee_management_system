package com.realcoderz.dao.department;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.realcoderz.business.bean.DepartmentBean;
import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.dao.admin.AdminComplianceDaoImpl;
import com.realcoderz.model.Department;
import com.realcoderz.model.Employee;
import com.realcoderz.model.LoginMaster;
import com.realcoderz.util.EntityConversion;

/**
* <h1>DepartmentEmployeeDaoimpl</h1>
* 
* <p>This repository class is the implementation of {@link com.realcoderz.dao.department.DepartmentEmployeeDao.class} Interface is used to persist or retrieve data of compliance of a particular department from database</p>
* 
* @author  Aman Srivastava
* @version 1.0
* @since   2021-05-28
*/
@Repository
@SuppressWarnings("unchecked")
@Transactional("txManager")
public class DepartmentEmployeeDaoimpl implements DepartmentEmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	EntityConversion entityConversion;
	private static final Logger LOGGER = Logger.getLogger(DepartmentEmployeeDaoimpl.class);
	
	/**
	   * This method is used to get a single employee object from database
	   * @param employeeId
	   * @return comp.realcoderz.business.bean.EmployeeBean
	   * @throws java.lang.Exception
	   */
	@Override
	public EmployeeBean getEmployee(int employeeId) {
		LOGGER.info("starts getEmployee method");
		EmployeeBean employeeBean = null;
		
		try {

			Employee employee = entityManager.find(Employee.class, employeeId);

			employeeBean = entityConversion.entityToBean(employee);

		} catch (Exception exception) {
			LOGGER.debug("throws getEmployee method " + exception);
			throw exception;
		}
		LOGGER.info("Ends getEmployee method");
		return employeeBean;

	}
	
	/**
	   * This method is used to get all employees objects of a particular department from database
	   * @param departmentId
	   * @return java.util.List<EmployeeBean>
	   * @throws java.lang.Exception
	   */
	@Override
	public List<EmployeeBean> getAllEmployees(int departmentId) {

		LOGGER.info("starts getAllEmployees method");
		List<EmployeeBean> listEmployeeBean = null;

		try {
			listEmployeeBean = new ArrayList<EmployeeBean>();

			List<Employee> listEmployeeEntity = (List<Employee>) entityManager.createQuery("from Employee e where e.department.departmentId = " + departmentId)
					.getResultList();

			for (Employee entity : listEmployeeEntity) {
				EmployeeBean emp = entityConversion.entityToBean(entity);
				System.out.println("employee name " + emp.getFirstName());
				System.out.println("Department " + entity.getDepartment().getDeparmentName());
				listEmployeeBean.add(emp);
			}

		} catch (Exception exception) {
 
			LOGGER.debug("throws getAllEmployees method " + exception);
			throw exception;
		}
		LOGGER.info("Ends getAllEmployees method");
		return listEmployeeBean;
	}

	
}
