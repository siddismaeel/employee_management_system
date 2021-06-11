
/**
* <h1>ResetCredntialDao!</h1>
* 
* <p>This Interface is used to persist or retrieve data of Employees from database</p>
* 
* @author  Aman Gauri
* @version 1.0
* @since   2021-05-28
*/

package com.realcoderz.dao.resetCredentials;

import com.realcoderz.business.bean.EmployeeBean;

public interface ResetCredentialDao {

	/**
	   * This method is used to fetch employees by their email ID
	   * @param email
	   * @return email as a string 
	   * @throws java.lang.Exception
	   */
   public EmployeeBean getEmployeeByEmail(String email) throws Exception;
	/**
	   * This method is used to update the password with the corressponding userID
	   * @param employeeBean 
	   * @throws java.lang.Exception
	   */
	
	public EmployeeBean updatePassword(EmployeeBean employeeBean);
}
