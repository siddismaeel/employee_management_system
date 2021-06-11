/**
* <h1>ResetCredntialServiceImpl!</h1>
* <p>This service class is used to call the dao method of the ResetCredentialDaoImpl</p>
* 
* @author  Aman Gauri
* @version 1.0
* @since   2021-05-28
*/
package com.realcoderz.service.resetCredentials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.dao.resetCredentials.ResetCredentialDao;
@Service
public class ResetCredentialServiceImpl implements ResetCredentialService {

	@Autowired
	private ResetCredentialDao resetCredentialDao;
	@Override
	
	/**
	* <h1>This is the getEmployeeByEmail method</h1>
	* <p>It will fetch the employee from database and get their email and calls the dao layer</p> 
	*
	* @author  Aman Gauri
	* @version 1.0.0
	* @since   2021-06-02 
	*/
	public EmployeeBean getEmployeeByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		EmployeeBean getemployees=resetCredentialDao.getEmployeeByEmail(email);
		return getemployees;
	}

	@Override
	/**
	* <h1>This is the updatePassword method</h1>
	* <p>First it will find the employee in database, it will update the password in the database by calling the dao method</p> 
	*
	* @author  Aman Gauri
	* @version 1.0.0
	* @since   2021-06-02 
	*/
	public EmployeeBean updatePassword(EmployeeBean employeeBean) {
		// TODO Auto-generated method stub
		EmployeeBean updatepassword=resetCredentialDao.updatePassword(employeeBean);
		return updatepassword;
	}

}
