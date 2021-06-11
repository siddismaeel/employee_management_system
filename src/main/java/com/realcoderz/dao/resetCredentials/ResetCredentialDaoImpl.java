/**
* <h1>The ResetCredentialDaoImpl class interacts with the database</h1>
* <p>It has 2 methods getEmployeeByEmail and updatePassword</p> 
*
* @author  Aman Gauri
* @version 1.0.0
* @since   2021-06-02 
*/
package com.realcoderz.dao.resetCredentials;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.realcoderz.business.bean.DepartmentBean;
import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.model.Department;
import com.realcoderz.model.Employee;
import com.realcoderz.model.LoginMaster;
import com.realcoderz.util.EntityConversion;

@Repository
@Transactional("txManager")
public class ResetCredentialDaoImpl implements ResetCredentialDao {

	@PersistenceContext
	EntityManager entityManager;
	@Autowired
	EntityConversion entityConversion;
	/**
	 * This method is used to convert entity to bean
	 * 
	 * @param employee
	 * @return employeeBean
	 */

	/*
	 * public static EmployeeBean convertEntityToBean(Employee employee){
	 * DepartmentBean departmentBean =
	 * convertEntityToBean(employee.getDepartment()); EmployeeBean employeeBean =
	 * new EmployeeBean(); BeanUtils.copyProperties(employee, employeeBean);
	 * //employeeBean.setDepartmentBean(departmentBean); return employeeBean; }
	 *//**
		 * This method is used to convert Bean to Entity
		 * 
		 * @param employeeBean
		 * @return employee
		 */

	/*
	 * 
	 * public static Employee convertBeanToEntity(EmployeeBean employeeBean){
	 * //Department department =
	 * convertBeanToEntity(employeeBean.getDepartmentBean()); Employee employee =
	 * new Employee(); BeanUtils.copyProperties(employeeBean, employee);
	 * 
	 * //employee.setDepartment(department); return employee; }
	 *//**
		 * This method is used to convert entity to bean
		 * 
		 * @param department
		 * @return departmentBean
		 *//*
			 * 
			 * public static DepartmentBean convertEntityToBean(Department department){
			 * 
			 * DepartmentBean departmentBean = new DepartmentBean();
			 * BeanUtils.copyProperties(department, departmentBean); return departmentBean;
			 * } public static Department convertBeanToEntity(DepartmentBean
			 * departmentBean){ Department department= new Department();
			 * BeanUtils.copyProperties(departmentBean, department); return department; }
			 */

	@Override
	public EmployeeBean getEmployeeByEmail(String email) throws Exception {
		/**
		 * <h1>This is the getEmployeeByEmail method</h1>
		 * <p>
		 * It will fetch the employee from database and get their email
		 * </p>
		 *
		 * @author Aman Gauri
		 * @version 1.0.0
		 * @since 2021-06-02
		 */

		Employee employee = null;
		// try {

		String myquery = "from Employee where email = :email";

		Query query = entityManager.createQuery(myquery);
		query.setParameter("email", email);

		employee = (Employee) query.getSingleResult();
		LoginMaster login = employee.getLoginMaster();
		System.out.println("in getemploeebyemail");
		System.out.println(employee);
		System.out.println(email);
		System.out.println(login.getUserId());
		// System.out.println(userId);
		// }
		// catch(Exception ex) { System.out.println(ex); }
		return entityConversion.entityToBean(employee);
	}

	@Override
	public EmployeeBean updatePassword(EmployeeBean employeeBean) {
		/**
		 * <h1>This is the updatePassword method</h1>
		 * <p>
		 * First it will find the employee in database, it will update the password in
		 * the database
		 * </p>
		 *
		 * @author Aman Gauri
		 * @version 1.0.0
		 * @since 2021-06-02
		 */
		System.out.println("in update password of resetcredentialdaoimpl");
		// Employee updateEmployee = entityConversion.beanToEntity(employeeBean);

		try {
			System.out.println("employee bean" + employeeBean.getEmpId());
			Employee employee = entityManager.find(Employee.class, employeeBean.getEmpId());
			System.out.println(employee);
			// employee.setLoginMaster(updateEmployee.getLoginMaster());
			employee.getLoginMaster().setPassword(employeeBean.getPassword());
			employeeBean = entityConversion.entityToBean(employee);

		} catch (Exception e) {
			employeeBean = null;
			throw e;
		}

		return employeeBean;

	}

}
