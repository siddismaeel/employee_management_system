/**
* The VerifyOtp controller of the Employee Management project will verify the one time password, which is stored in a session
* displays a jsp page in which you will enter otp and it will verify
* if it is incorrect it will not go to the next page.
* if it is correct, it will go to change password form
* there you will type the password and password will be updated in the database
*
* @author  Aman Gauri
* @version 1.0
* @since   2021-06-02 
*/

package com.realcoderz.web.controller.resetCredentials;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.business.bean.LoginMasterBean;
import com.realcoderz.dao.resetCredentials.ResetCredentialDao;
import com.realcoderz.model.Employee;
import com.realcoderz.service.resetCredentials.ResetCredentialService;


@Controller
public class VerifyOtp {

	private static final Logger LOGGER = Logger.getLogger(VerifyOtp.class);
	@Autowired
	private ResetCredentialService resetCredentialService;
	@RequestMapping("verify.html")
	public String verifyotp(@RequestParam("otp") int otp, HttpSession session) throws Exception
	 /**
	   * This method is used to verify one time password
	   * First It will check the one time password stored in the session 
	   * If it equals then it will return to change password form
	   * @param otp This is the first parameter in verifyotp method
	   * @return String returns the page in which the user wants
	   */
	{
		LOGGER.info("In verify otp controller where one time password is checked when user enters otp");
		int myOTP=(int) session.getAttribute("myotp");
		System.out.println(myOTP);
		String email=(String) session.getAttribute("email");
		System.out.println(email);
		if(myOTP==otp)
		{
			LOGGER.info("It will check that if user has entered correct otp");
			System.out.println("in if statement of verify controller");
			//password change form
			
	  /*  EmployeeBean emp= this.resetCredentialService.getEmployeeByEmail(email);
		
		if(emp==null)
		{
			System.out.println("does not exist");
			return "VerifyOTP";
		}
		else
		{
			System.out.println("exist");
			
		}
			
			return "passwordChangeForm";
		*/	
			return "passwordChangeForm";
			
		}else
		{
			session.setAttribute("myOtp", "enter correct otp");
			System.out.println("in else statement of verify controller");
			
		}
		return"VerifyOTP";
		
		
	}
	
	// This is the change password controller where the password will change corresponding to userId in employee table
	@PostMapping("change-password.html")
	public String changepassword(@RequestParam("confirmnewpassword") String newpassword, HttpSession session) throws Exception
	/**
	   * This method is used to change the password 
	   * This is used to change t[he password 
	   * @param newpassword this is the first parameter of the changepassword method
	   * @return String returns the page in which the user wants
	   */
	{
		LOGGER.info("In Change password controller");
		String email=(String) session.getAttribute("email");
	//	int userId=(int) session.getAttribute("myotp");
	    //LoginMasterBean loginMasterBean = null;
	//	EmployeeBean EmployeeBean = null;
		EmployeeBean emp= this.resetCredentialService.getEmployeeByEmail(email);
		emp.setPassword(newpassword);
		EmployeeBean updatedBean = this.resetCredentialService.updatePassword(emp);
		if(updatedBean!=null)
		{
			session.setAttribute("employee", updatedBean);
			return "redirect:/index.jsp";
		}
		else
		{
			LOGGER.error("password is not updated in the database");
			System.out.println("not updated");
		}
	
		System.out.println("in change password controller");
		
		return "";
	}
	
	
}
