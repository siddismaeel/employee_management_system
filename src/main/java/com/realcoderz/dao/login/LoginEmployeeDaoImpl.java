package com.realcoderz.dao.login;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.realcoderz.business.bean.DepartmentBean;
import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.business.bean.LoginMasterBean;
import com.realcoderz.model.Department;
import com.realcoderz.model.Employee;
import com.realcoderz.model.LoginMaster;
import com.realcoderz.util.EntityConversion;

@Repository
public class LoginEmployeeDaoImpl implements LoginEmployeeDao {
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	private EntityConversion entityConversion;
	@Override
	public LoginMasterBean getLoginMasterByUserId(int userId) {
		try {
			Employee employee = getEmployeeEntityByUserId(userId);
			LoginMaster login = employee.getLoginMaster();

			return convertEntityToBean(login);
		} catch (Exception e) {
			System.out.println("Exception=" + e);
			return null;
		}

	}

	@Override
	public EmployeeBean getEmployeeByUserId(int userId) {
		try {
			Query query = entityManager.createQuery("from Employee e where e.loginMaster.userId=" + userId);
			Employee employee = (Employee) query.getSingleResult();
			System.out.println("from login dao "  + employee.getFirstName());
			EmployeeBean employeeBean = entityConversion.entityToBean(employee);
			
			System.out.println("from login dao employeeBean"  + employeeBean.getFirstName());
			
			return employeeBean;
		} catch (Exception e) {
			
			System.out.println("Exception occured in login daoimp getEmployeeEntityByUserId");
			System.out.println("Exception=" + e);
			return null;
		}


	}

	public Employee getEmployeeEntityByUserId(int userId) {

		try {
			Query query = entityManager.createQuery("from Employee e where e.loginMaster.userId=" + userId);
			Employee employee = (Employee) query.getSingleResult();
			System.out.println("from login dao "  + employee.getFirstName());
			return employee;
		} catch (Exception e) {
			
			System.out.println("Exception occured in login daoimp getEmployeeEntityByUserId");
			System.out.println("Exception=" + e);
			return null;
		}

	}

	/*
	 * public static EmployeeBean convertEntityToBean(Employee employee) {
	 * DepartmentBean departmentBean =
	 * convertEntityToBean(employee.getDepartment()); EmployeeBean employeeBean =
	 * new EmployeeBean(); BeanUtils.copyProperties(employee, employeeBean);
	 * employeeBean.setDepartmentId(departmentBean.getDepartmentId());
	 * employeeBean.setDepartmentName(departmentBean.getDepartmentName()); return
	 * employeeBean; }
	 * 
	 * public static Employee convertBeanToEntity(EmployeeBean employeeBean) { //
	 * Department department = //
	 * convertBeanToEntity(employeeBean.getDepartmentBean()); Employee employee =
	 * new Employee(); BeanUtils.copyProperties(employeeBean, employee);
	 * 
	 * // employee.setDepartment(department); return employee; }
	 * 
	 * public static DepartmentBean convertEntityToBean(Department department) {
	 * 
	 * DepartmentBean departmentBean = new DepartmentBean();
	 * BeanUtils.copyProperties(department, departmentBean); return departmentBean;
	 * }
	 * 
	 * public static Department convertBeanToEntity(DepartmentBean departmentBean) {
	 * Department department = new Department(); //
	 * BeanUtils.copyProperties(departmentBean, department);
	 * department.setDeparmentName(departmentBean.getDepartmentName()); return
	 * department; }
	 * 
	 * public static LoginMaster convertBeanToEntity(LoginMasterBean loginBean) {
	 * LoginMaster login = new LoginMaster(); BeanUtils.copyProperties(loginBean,
	 * login); return login; }
	 */
	public static LoginMasterBean convertEntityToBean(LoginMaster loginMaster) {

		LoginMasterBean loginMasterBean = new LoginMasterBean();
		BeanUtils.copyProperties(loginMaster, loginMasterBean);
		return loginMasterBean;
	}

}
