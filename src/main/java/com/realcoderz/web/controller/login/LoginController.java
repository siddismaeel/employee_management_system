/*Created By GauravSingh
 * login module
 * 
 * */

package com.realcoderz.web.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.business.bean.LoginMasterBean;
import com.realcoderz.service.login.LoginEmployeeService;

@Controller
@SessionAttributes({ "userId", "employee" })
public class LoginController {

	@Autowired
	LoginEmployeeService service;

	@RequestMapping(value = "/failure2.html", method = RequestMethod.GET)
	public ModelAndView failure2() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("failure2");
		modelAndView.addObject("userId");
		modelAndView.addObject("eBean");
		return modelAndView;

	}
 
	// ***************method to validate login************
	@RequestMapping(value = "/validateLogin.html", method = RequestMethod.POST)
	public String validateLogin(@RequestParam("userId") String userId, @RequestParam("password") String password,
			Model model, HttpServletRequest request) {

		HttpSession session = null;
		try {
			// If User Enter Wrong Id/Pass then Catch Block will Run.

			EmployeeBean employee = service.getEmployeeByUserId(Integer.parseInt(userId));
			LoginMasterBean loginBean = service.getLoginMasterByUserId(Integer.parseInt(userId));

			if (loginBean.getPassword().equals(password))
			{
				
				session = request.getSession();
				employee.setPassword(null);
				System.out.println("Employee from login controller " + employee);
				session.setAttribute("employee", employee);
				
				 
				if(loginBean.getRole().equalsIgnoreCase("admin"))
				{
					return "redirect:/admin.html";
				}
				
				else if(loginBean.getRole().equalsIgnoreCase("HOD"))
				{
					return "redirect:/department.html";
				}
				
				else
				{
					return "redirect:/employee.html";
				}
				
				
			}
			
			else
			{
				return "failure2";
			}
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("inside CATCH BLOCK null values");
			model.addAttribute("userId", userId);
			model.addAttribute("message", "Please Enter correct credentials");

			return "failure";
		}

	}

}
