package com.realcoderz.web.controller.employee;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.realcoderz.business.bean.ComplianceBean;
import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.business.bean.StatusReportBean;
import com.realcoderz.service.employee.ComplianceService;
import com.realcoderz.service.employee.StatusReportService;

/**
* <h1>DepartmentHead</h1>
* 
* <p>This Controller class is use to show the employee Dashboard and add, edit the comment by Employee</p>
* 
* @author  Vishal Gupta
* @version 1.0
* @since   2021-05-28
*/

@Controller
public class EmloyeeController {
	private static final Logger LOGGER = Logger.getLogger(EmloyeeController.class);
	
	@Autowired
	ComplianceService complianceService;
	
	@Autowired
	StatusReportService statusReoprtService;
	
	/**
	   * This method shows the Employee dashboard, get all the compliance of particular department and status reports of particular employee
	   * @param No parameter
	   */
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView LoadEmployeeDashboad(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession(false);
		
		if(session == null)
		{ 
			response.sendRedirect(request.getContextPath() + "/index.html");
			return null;
		}
		
		 
		EmployeeBean employeeBean = (EmployeeBean)session.getAttribute("employee");
		
		if(employeeBean == null)
		{
			response.sendRedirect(request.getContextPath() + "/index.html");
			return null;
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("employeeDashboard2");
		List<ComplianceBean> complianceList = complianceService.getAllCompliance(employeeBean.getDepartmentId());
		List<StatusReportBean> statusReportList = statusReoprtService.getAllstatusReports(employeeBean.getEmpId()) ;
		modelAndView.addObject("compliance",complianceList);
		modelAndView.addObject("report",statusReportList);
		return modelAndView;
	}
	/**
	   * This method shows the Employee profile
	   * @param No parameter
	   */
	@RequestMapping(value = "/employeeProfile", method = RequestMethod.GET)
	public ModelAndView LoadEmployeeProfile() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("employeeProfile");
		
		return modelAndView;
	}
	/**
	   * This method is used to add the comment
	   * @param No parameter
	   */
	@RequestMapping(value = "/editComment", method = RequestMethod.GET)
	public ModelAndView getEmployee(@RequestParam("empId") int empId ,@RequestParam("complianceId") int complianceId,@RequestParam("departmentId") int departmentId ) {
		System.out.println(empId);
		System.out.println(complianceId);
		System.out.println(departmentId);
		StatusReportBean statusReportBean = new StatusReportBean();
		statusReportBean.setEmpId(empId);
		statusReportBean.setComplianceId(complianceId);
		statusReportBean.setDepartmentId(departmentId);
		//EmployeeBean employee = employeeServices.getEmployee(empId);
		ModelAndView model = new ModelAndView();
		model.addObject("statusReport",statusReportBean);
		
		model.setViewName("addComment2");
		return model;
	}
	
	/**
	   * This method is used to add the comment
	   * @param No parameter
	   */
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public String addComments(@ModelAttribute("statusReport") StatusReportBean statusReportBean,HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		HttpSession session = request.getSession(false);
		if(session == null)
		{
			return "redirect:/index.html";
		}	
		statusReportBean.setCommentDate(new Date());
		boolean status = statusReoprtService.saveStatusReport(statusReportBean);
		if(status) {
			session.setAttribute("message","Comments saved");
			
		}
		else {
			session.setAttribute("message","Comments not saved");
		}
		return "redirect:/employee.html";
	}


	@RequestMapping(value = "/Comment", method = RequestMethod.GET)
	public ModelAndView editComment(@RequestParam("statusReportId") int statusReportId ) {
		StatusReportBean statusReportBean = new StatusReportBean();
		 statusReportBean.setStatusReportId(statusReportId);
		 ModelAndView model = new ModelAndView();	
		 model.addObject("statusReport",statusReportBean);
		 model.setViewName("editComment");
		return model;
	}
	
	/**
	   * This method is used to edit the comment
	   * @param No parameter
	   */
	@RequestMapping(value = "/commentEdit", method = RequestMethod.POST)
	public String commentEdit(@ModelAttribute("statusReport") StatusReportBean statusReportBean,HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		System.out.println(statusReportBean.getStatusReportId());
		System.out.println(statusReportBean.getComments());
		
		HttpSession session = request.getSession(false);
		if(session == null)
		{
			return "redirect:/index.html";
		}	
		statusReportBean.setCommentDate(new Date());
		boolean status = statusReoprtService.updateStatusReport(statusReportBean);
		if(status) {
			session.setAttribute("message","Comments Updated saved");
			
		}
		else {
			session.setAttribute("message","Comments not updated saved");
			
		}
		
		return "redirect:/employee.html";
	}


}
