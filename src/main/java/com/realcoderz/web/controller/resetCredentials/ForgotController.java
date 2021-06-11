/**
* The Forgot controller of Employee Management project helps user to reset their password.
* Simply displays a jsp page in which user will enter his /her email.
* If the email is correct it will generate a one time password and will send on the users email address which he/she has emtered. 
* If it is incorrect it will redirect to error page. 
*
* @author  Aman Gauri
* @version 1.0.0
* @since   2021-06-02 
*/

package com.realcoderz.web.controller.resetCredentials;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.service.EmailService;
import com.realcoderz.service.resetCredentials.ResetCredentialService;
import com.realcoderz.web.controller.departmenthead.DepartmentHead;

@Controller
public class ForgotController {
	
	private static final Logger LOGGER = Logger.getLogger(ForgotController.class);
	@Autowired
	private ResetCredentialService resetCredentialService;
	@Autowired
	private EmailService emailservice;
	
	@PostMapping("sendOTP.html")
	public String sendOTP(@RequestParam("email") String email, HttpSession session) throws Exception
	 /**
	   * This method is used to send one time password. 
	   * First It will check the email if it exist in the database
	   * It will generate one time password if the user exists
	   * @param email This is the first parameter for email
	   * @return String returns the page in which the user wants
	   */
	{
		LOGGER.info("In sendOTP method of Forgot Controller class");
		System.out.println("Email: " +email);
		
		EmployeeBean emp= this.resetCredentialService.getEmployeeByEmail(email);
		
		if(emp!=null)
		{
            LOGGER.info("If employee exist it will generate otp and send email");		 
			//generating otp for user
			Random rand=new Random(10000);		
			int otp=rand.nextInt(12345);
			
			
			
			System.out.println(otp);
		
		
			
			// writing email code here
			
	         String subject="Otp From RealCoderz";
			
			 String message="<h1>otp= "+otp+"</h1> ";
	         String to=email;
			
			boolean flag=this.emailservice.sendEmail(subject, message, to);
			
					
				session.setAttribute("myotp", otp);
				session.setAttribute("email", email);
				return "VerifyOTP";	
			
			
			
		}
		else
		{

		LOGGER.error("Employee does not exist in the database");
		System.out.println("does not exist");
		session.setAttribute("message", "check email");
//		return "Error";
		
		}
		//return "ForgotEmailForm";
		return "redirect:/Error.jsp";
	}
	
	
	@RequestMapping(value="/forgotpassword", method= RequestMethod.GET)
	public ModelAndView ShowForgot()
	{
		LOGGER.info("Starts Forgot Password controller");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("ForgotEmailForm");
		return mv;
	}
	
}
