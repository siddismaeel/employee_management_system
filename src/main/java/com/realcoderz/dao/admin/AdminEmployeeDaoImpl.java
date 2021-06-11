package com.realcoderz.dao.admin;

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
import com.realcoderz.model.Department;
import com.realcoderz.model.Employee;
import com.realcoderz.model.LoginMaster;
import com.realcoderz.util.EntityConversion;


/**
* <h1>AdminEmployeeDaoImpl</h1>
* 
* <p>This repository class is implementation of {@link com.realcoderz.dao.admin.AdminEmployeeDao} Interface is used to persist or retrieve data of Employees from database</p>
* 
* @author  Ismaeel Siddiqui
* @version 1.0
* @since   2021-05-28
*/
@Repository
@SuppressWarnings("unchecked")
@Transactional("txManager")
public class AdminEmployeeDaoImpl implements AdminEmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	EntityConversion entityConversion;
	private static final Logger LOGGER = Logger.getLogger(AdminEmployeeDaoImpl.class);

	/**
	   * This method is used to get a single employee object from database
	   * @param employeeId
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
	   * This method is used to get all employees objects from database
	   * @param No parameter
	   * @return java.util.List<EmployeeBean>
	   * @throws java.lang.Exception
	   */
	@Override
	public List<EmployeeBean> getAllEmployees() {

		
		LOGGER.info("starts getAllEmployees method");
		List<EmployeeBean> listEmployeeBean = null;

		try {
			listEmployeeBean=new ArrayList<EmployeeBean>();

			List<Employee> listEmployeeEntity= (List<Employee>) entityManager.createQuery("from Employee").getResultList();

			for (Employee entity:listEmployeeEntity){
				EmployeeBean emp= entityConversion.entityToBean(entity);

				listEmployeeBean.add(emp);
			}


		} catch (Exception exception) {

			LOGGER.debug("throws getAllEmployee method " + exception);
			throw exception;
		}
		
		LOGGER.info("Ends getAllEmployee method");
		return listEmployeeBean;
	}

	/**
	   * This method is used to save a new employee object into database
	   * @param employeeBean
	   * @return employee ID as Integer 
	   * @throws java.lang.Exception
	   */
	@Override
	public Integer saveEmployee(EmployeeBean employeeBean) {


		LOGGER.info("starts saveEmployee method");
		Integer employeeID = 0;

		Employee employee = entityConversion.beanToEntity(employeeBean);
 
		System.out.println("from emp dao ------>");
		System.out.println(employee.getEmpId());
		System.out.println("userId " + employee.getLoginMaster().getUserId());
		employee.setDepartment(null);

		try {

			Department department = entityManager.find(Department.class, employeeBean.getDepartmentId());

			entityManager.persist(employee);

			employee.setDepartment(department);

			employeeID = employee.getEmpId();
		} catch (Exception exception) {
			LOGGER.debug("throws saveEmployee method " + exception);
			throw exception;
		}

		LOGGER.info("Ends saveEmployee method");
		return employeeID;

	}

	/**
	   * This method is used to update an existing employee object into database
	   * @param employeeBean
	   * @return employee ID as Integer
	   * @throws java.lang.Exception
	   */
	@Override
	public Integer updateEmployee(EmployeeBean employeeBean) {

		LOGGER.info("starts updateEmployee method");
		int empId = 0;

		try {

			Employee employee = (Employee) entityManager.find(Employee.class, employeeBean.getEmpId());

			if (employee != null)

			{
				employee.setFirstName(employeeBean.getFirstName());
				employee.setLastName(employeeBean.getLastName());
				employee.setDob(employeeBean.getDob());

				empId = employee.getEmpId();

			}

		} catch (Exception exception) {

			LOGGER.debug("throws updateEmployee method " + exception);
			throw exception;
		}

		LOGGER.info("Ends updateEmployee method");
		return empId;

	}

	/**
	   * This method is used to delete an existing employee object from database
	   * @param employeeBean
	   * @return employee ID as Integer
	   * @throws java.lang.Exception
	   */
	@Override
	public Integer deleteEmloyee(EmployeeBean employeeBean) {

		LOGGER.info("starts deleteEmployee method");
		Integer empId = 0;
		try {
 

			Employee employee = (Employee) entityManager.find(Employee.class, employeeBean.getEmpId());
			employee.setDepartment(null);

			if(employee != null)
			{
				entityManager.remove(employee);

				empId = employee.getEmpId();
			}			

		} catch (Exception exception) {

			LOGGER.debug("throws deleteEmployee method " + exception);
			throw exception;
		}


		LOGGER.info("Ends deleteEmployee method");
		return empId;
	}

	/**
	   * This method is used to get all existing employee objects from database
	   * @param No param
	   * @return List<EmployeeBean>
	   * @throws java.lang.Exception
	   */
	@Override
	public List<EmployeeBean> getEmployeesByDepartment(int departmentId) {

		List<EmployeeBean> employeeBeans = new ArrayList<>();
		
		try
		{
			List<Employee> listEmployeeEntity = entityManager.createQuery("from Employee e where e.department.departmentId = " + departmentId).getResultList();
			for (Employee entity:listEmployeeEntity){ 
				EmployeeBean emp= entityConversion.entityToBean(entity);

				employeeBeans.add(emp);
			}
		
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return employeeBeans;
	}

	
}
