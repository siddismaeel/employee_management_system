package com.realcoderz.web.controller.departmenthead;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.realcoderz.business.bean.ComplianceBean;
import com.realcoderz.business.bean.DepartmentBean;
import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.business.bean.StatusReportBean;
import com.realcoderz.service.EmailService;
import com.realcoderz.service.department.DepartmentComplianceService;
import com.realcoderz.service.department.DepartmentEmployeeService;
import com.realcoderz.service.department.DepartmentStatusReportService;

/**
* <h1>DepartmentHead</h1>
* 
* <p>This Controller class is use to handle the request of retrieve the employee by particular department and send regulation mail to all employee of a particular department</p>
* 
* @author  Aman Srivastava
* @version 1.0
* @since   2021-05-28
*/

@Controller
public class DepartmentHead {
	
	private static final Logger LOGGER = Logger.getLogger(DepartmentHead.class);
	
	@Autowired
	private DepartmentComplianceService departmentComplianceService;
	
	@Autowired
	private DepartmentEmployeeService departmentEmployeeService;
	
	@Autowired
	private DepartmentStatusReportService departmentReportService;
	
	@Autowired
	private EmailService emailService;
	/**
	   * This method is used to retrieve all the employees, status reports, compliance of a particular department
	   * @param departmentId
	   */
	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public ModelAndView adminDashBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOGGER.info("starts adminDashboard method");
		LOGGER.info("Endss adminDashboard method");
		
		HttpSession session = request.getSession();
		System.out.println("Redirected to admin.html---------------->");
		
		
		  EmployeeBean employeeBean1 = (EmployeeBean)session.getAttribute("employee");

		  if(employeeBean1 != null)
		 {
			 System.out.println("logged in as " + employeeBean1.getFirstName() + " " + employeeBean1.getLastName());
		 }
		 else
		 {
			 response.sendRedirect(request.getContextPath()+"/");
		 }
		 
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("department2");
		
		List<EmployeeBean> allEmployees = departmentEmployeeService.getAllEmployees(employeeBean1.getDepartmentId());
		List<ComplianceBean> allCompliance = departmentComplianceService.getAllCompliance(employeeBean1.getDepartmentId());
		List<StatusReportBean> allstatusreport = departmentReportService.getAllStatusReport(employeeBean1.getDepartmentId());
		System.out.println(allEmployees);
		System.out.println(allCompliance);
		System.out.println(employeeBean1.getDepartmentId());
		EmployeeBean employeeBean = new EmployeeBean();
		ComplianceBean complianceBean = new ComplianceBean();
		
		modelAndView.addObject("compliance", complianceBean);
		modelAndView.addObject("allCompliance", allCompliance);
		modelAndView.addObject("employee",employeeBean);
		modelAndView.addObject("allEmployees",allEmployees);
		modelAndView.addObject("department", new DepartmentBean());
		modelAndView.addObject("allstatusreport", allstatusreport);
		
		
	
		LOGGER.info("Ends adminDashboard method");
		return modelAndView;
		
	}
	
	/**
	   * This method is used send the regulations through email to all employees of a particular department 
	   * @param employeeId
	   */
	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public ModelAndView sendRegulations(@RequestParam("complianceId") int complianceId, HttpServletRequest request) throws Exception {
		LOGGER.info("starts sendRegulations method");
		
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession(false);
		
		if(session == null)
		{
			modelAndView.setViewName("redirect:/");
			
			return modelAndView;
		}
		
		modelAndView.setViewName("forward:/department.html");
		
		EmployeeBean loggedInEmployee = (EmployeeBean)session.getAttribute("employee");
		
		ComplianceBean complianceBean = departmentComplianceService.getCompliance(complianceId);
		List<EmployeeBean> allEmployees = departmentEmployeeService.getAllEmployees(loggedInEmployee.getDepartmentId());
		
		
		String[] emailArray = new String[allEmployees.size()];
		for(int i = 0; i< allEmployees.size(); i++)
		{
			emailArray[i] = allEmployees.get(i).getEmail();
		}
		
		EmailService emailService = this.emailService;
		System.out.println("before starting  email thread call");
		new Thread(new Runnable() {

			@Override
			public void run() {
				
				
				emailService.sendEmail("Compliance", "Hi"
						+ "\n New compliance has been added in your department, please responce to that"
						+ "\nThe followings are compliance details"
						+ "\n" + complianceBean.getFileTitle(), emailArray);
				
				System.out.println("after email call");
			}
			
		}).start();
		
		//session.setAttribute("employee", 4);
		LOGGER.info("Ends sendRegulations method");
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/Comments", method = RequestMethod.GET)
	public ModelAndView editComment(@RequestParam("statusReportId") int statusReportId ) {
		System.out.println("status report id in comments "+statusReportId);
		StatusReportBean statusReportBean = new StatusReportBean();
		 statusReportBean.setStatusReportId(statusReportId);
		 ModelAndView model = new ModelAndView();	
		 model.addObject("statusReport",statusReportBean);
		 model.setViewName("editCommentByDepartment");
		return model;
	}
	 
	@RequestMapping(value = "/commentsEdit", method = RequestMethod.POST)
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
		boolean status = departmentReportService.updateStatusReport(statusReportBean);
		if(status) {
			session.setAttribute("message","Comments saved");
			
		}
		else {
			session.setAttribute("message","Comments not saved");
			
		}
		
		return "redirect:/department.html";
	}
	
	@RequestMapping(value = "/editComments", method = RequestMethod.GET)
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
		
		model.setViewName("addCommentByDepartment");
		return model;
	}
	
	@RequestMapping(value = "/addComments", method = RequestMethod.POST)
	public String addComments(@ModelAttribute("statusReport") StatusReportBean statusReportBean,HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		System.out.println("Hello");
		System.out.println("add comment"+statusReportBean.getComments());
		System.out.println(statusReportBean.getComplianceId());
		System.out.println(statusReportBean.getEmpId());
		System.out.println(statusReportBean.getDepartmentId());
		HttpSession session = request.getSession(false);
		if(session == null)
		{
			return "redirect:/index.html";
		}	
		statusReportBean.setCommentDate(new Date());
		boolean status = departmentReportService.saveStatusReport(statusReportBean);
		if(status) {
			session.setAttribute("message","Comments saved");
			
		}
		else {
			session.setAttribute("message","Comments not saved");
			
		}
		return "redirect:/department.html";
	}
}
