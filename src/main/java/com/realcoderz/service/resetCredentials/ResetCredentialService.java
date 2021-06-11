/**
* <h1>ResetCredntialService!</h1>

* 
* <p>This Interface is used to call the dao method</p>
* 
* @author  Aman Gauri
* @version 1.0
* @since   2021-05-28
*/

package com.realcoderz.service.resetCredentials;

import com.realcoderz.business.bean.EmployeeBean;

public interface ResetCredentialService {
	
	/**
	   * This method is used to fetch employees by their email ID in service class
	   * @param email
	   * @return email as a string 
	   * @throws java.lang.Exception
	   */
public EmployeeBean getEmployeeByEmail(String email) throws Exception;
	
/**
 * This method is used to update the password with the corressponding userID in the service class
 * @param employeeBean 
 * @throws java.lang.Exception
 */
	public EmployeeBean updatePassword(EmployeeBean employeeBean);
}
