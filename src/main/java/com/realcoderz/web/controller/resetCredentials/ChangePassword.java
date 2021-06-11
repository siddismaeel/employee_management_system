/* package com.realcoderz.web.controller.resetCredentials;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.business.bean.LoginMasterBean;
import com.realcoderz.dao.EmployeeDao;
import com.realcoderz.dao.EmployeeDaoImpl;
import com.realcoderz.model.LoginMaster;

@Controller
public class ChangePassword {

	@Autowired
	private EmployeeDaoImpl empdaoimpl;
	@PostMapping("change-password.html")
	public String changepassword(@RequestParam("email") String newpassword, HttpSession session)
	{
		String email=(String) session.getAttribute("email");
	    
	    EmployeeBean emp= this.empdaoimpl.updatePassword(email, newpassword);
	
		System.out.println("in change password controller");
		
		return "";
	}
}
*/