package com.realcoderz.web.controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.realcoderz.business.bean.ComplianceBean;
import com.realcoderz.business.bean.DepartmentBean;
import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.service.EmailService;
import com.realcoderz.service.admin.AdminComplianceService;
import com.realcoderz.service.admin.AdminDepartmentService;
import com.realcoderz.service.admin.AdminEmployeeService;
import com.realcoderz.service.department.DepartmentEmployeeService;
import com.realcoderz.util.IDGenerator;


/**
* <h1>EmployeeDepartment</h1>
* 
* <p>This Controller class is use to handle request of add, update, delete and retrieve the employee and department</p>
* 
* @author  Ismaeel Siddiqui
* @version 1.0
* @since   2021-05-28
*/
@Controller
public class EmployeeDepartment {

	private static final Logger LOGGER = Logger.getLogger(EmployeeDepartment.class);

	@Autowired
	private AdminEmployeeService adminEmployeeService;
	@Autowired
	private AdminComplianceService adminComplianceService;

	@Autowired
	private EmailService EmailService;

	@Autowired
	private AdminDepartmentService departmentService;

	@Autowired
	private AdminDepartmentService adminDepartmentService;

	@Autowired
	private DepartmentEmployeeService departmentEmployeeService;
	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat
	 * sdf = new SimpleDateFormat("dd-MMM-yyyy");
	 * 
	 * binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(sdf,
	 * true)); }
	 */

	 /**
	   * This method shows the admin dashboard
	   * @param No parameter
	   */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminDashBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOGGER.info("starts adminDashboard method");
		HttpSession session = request.getSession(false);
		System.out.println("Redirected to admin.html---------------->");

		if (session == null) {
			System.out.println("Session is " + session);
			response.sendRedirect(request.getContextPath() + "/");
			return null;
		} 
  
		
		Map<Integer, DepartmentBean> allDepartment = adminDepartmentService.getAllDepartment();
		session.setAttribute("allDepartments", allDepartment);

		System.out.println("After session check ");
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("adminDashboard2"); 

		List<EmployeeBean> allEmployees = adminEmployeeService.getAllEmployees();
		/* List<DepartmentBean> departments = departmentService.getAllDepartment(); */
		List<ComplianceBean> allCompliance = adminComplianceService.getAllCompliance();

		session.setAttribute("allDepartments", allDepartment);

		modelAndView.addObject("compliance", new ComplianceBean());
		modelAndView.addObject("allCompliance", allCompliance);
		/* modelAndView.addObject("departments", departments); */
		modelAndView.addObject("employee", new EmployeeBean());
		modelAndView.addObject("allEmployees", allEmployees);
		modelAndView.addObject("department", new DepartmentBean());

		LOGGER.info("Ends adminDashboard method");
		return modelAndView;
	}


	/**
	   * This method shows the added employee by admin
	   * @param No parameter
	   */
	@RequestMapping(value = "/showAddEmloyee", method = RequestMethod.GET)
	public ModelAndView loadUpdateEmployee(HttpServletRequest request) throws Exception {
		LOGGER.info("starts loadUpdateEmployee method");
		HttpSession session = request.getSession();
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("addEmployee");

		EmployeeBean employeeBean = new EmployeeBean();
		modelAndView.addObject("employee", employeeBean);
		modelAndView.addObject("department", new DepartmentBean());
		LOGGER.info("Ends loadUpdateEmployee method");
		return modelAndView;
	}

	/**
	   * This method is used to add the employee by admin
	   * @param employeeBean
	   */
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute("employee") @Valid EmployeeBean employeeBean, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		LOGGER.info("starts addEmployee method");
		System.out.println("in add employee method");
		
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession(false);

		if (session == null) {
			
			modelAndView.setViewName("redirect:/");
			//response.sendRedirect(request.getContextPath() + "/");
			
			return modelAndView;
		}
		
		modelAndView.setViewName("adminDashboard2");

		List<EmployeeBean> allEmployees = adminEmployeeService.getAllEmployees();
		/* List<DepartmentBean> departments = departmentService.getAllDepartment(); */
		List<ComplianceBean> allCompliance = adminComplianceService.getAllCompliance();

		Map<Integer, DepartmentBean> allDepartment = adminDepartmentService.getAllDepartment();
		session.setAttribute("allDepartments", allDepartment);

		modelAndView.addObject("compliance", new ComplianceBean());
		modelAndView.addObject("allCompliance", allCompliance);
		/* modelAndView.addObject("departments", departments); */
		modelAndView.addObject("employee", new EmployeeBean());
		modelAndView.addObject("allEmployees", allEmployees);
		modelAndView.addObject("department", new DepartmentBean());
		
		session.removeAttribute("message");
		
		if (result.hasErrors()) {
			session.setAttribute("message", "Add Employee form had an error as you entered wrong input");
			return modelAndView;
		}

		System.out.println("after hasError check in addEmployee method");
		EmailService email = EmailService;
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDepartmentName(employeeBean.getDepartmentName());

		// employeeBean.setUserId(IDGenerator.generateUserId());
		employeeBean.setPassword(IDGenerator.generatePassword());

		session.setAttribute("allDepartments", allDepartment);
		Integer saveEmployee = 0;
		try {

			saveEmployee = adminEmployeeService.saveEmployee(employeeBean, departmentBean);
			

			if (saveEmployee > 0) {

				new Thread(new Runnable() {

					@Override
					public void run() {

						email.sendEmail("REALCODERZ",
								"Hi \n" + employeeBean.getFirstName() + "\n Your details has been submitted"
										+ "\n User ID: " + "\n Password: " + employeeBean.getPassword(),
								employeeBean.getEmail());

					}
				}).start();

				session.setAttribute("message", "Employee has been added");
			} else {
				session.setAttribute("message", "Employee has not been added");
			}

		}

		catch (Exception e) {
			
			session.setAttribute("message", "Employee  age must be greater than 25");
			
			System.out.println("In exception block ->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		// response.sendRedirect(request.getContextPath() + "/admin.html");
		LOGGER.info("Ends addEmployee method");
		return modelAndView;
	}

	/**
	   * This method is used to update the employee by admin
	   * @param employeeBean
	   */
	@RequestMapping(value = "/editForm", method = RequestMethod.GET)
	public ModelAndView showUpdateEmployee(@RequestParam("empId") int empId) {
		LOGGER.info("starts showUpdateEmployee method");
		EmployeeBean employee = adminEmployeeService.getEmployee(empId);
		ModelAndView model = new ModelAndView();

		model.addObject("employee", employee);
		model.addObject("department", new DepartmentBean());
		model.addObject("compliance", new ComplianceBean());
		model.setViewName("editEmployee");
		
		LOGGER.info("Ends showUpdateEmployee method");
		return model;

	}

	/**
	   * This method is used to delete the employee by admin
	   * @param empId
	   */
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute("employee") @Valid EmployeeBean employeeBean, BindingResult result,  HttpServletResponse response,
			HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(false);
		
		if(session == null)
		{
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors())
		{
			EmployeeBean employee = adminEmployeeService.getEmployee(employeeBean.getEmpId());
			
			modelAndView.addObject("employee", employee);
			modelAndView.addObject("department", new DepartmentBean());
			modelAndView.setViewName("editEmployee");
			
			return modelAndView;
		}
		LOGGER.info("starts updateEmployee method");
		EmailService email = EmailService;
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDepartmentName(employeeBean.getDepartmentName());

		employeeBean.setPassword(IDGenerator.generatePassword());

		Integer updated = adminEmployeeService.updateEmployee(employeeBean, departmentBean);
		
		/*
		 * List<EmployeeBean> allEmployees = adminEmployeeService.getAllEmployees();
		 * List<DepartmentBean> departments = departmentService.getAllDepartment();
		 */
		/*
		 * ComplianceBean complianceBean = new ComplianceBean();
		 * 
		 * modelAndView.addObject("compliance", complianceBean);
		 * modelAndView.addObject("departments", departments);
		 * modelAndView.addObject("employee", new EmployeeBean());
		 * modelAndView.addObject("allEmployees", allEmployees);
		 * 
		 * modelAndView.setViewName("adminDashboard");
		 */

		if (updated > 0) {
			new Thread(new Runnable() {

				@Override
				public void run() {

					email.sendEmail(
							"REALCODERZ", "Hi \n" + employeeBean.getFirstName() + "\n Your details has been Update"
									+ "\n User ID: " + updated + "\n Password: " + employeeBean.getPassword(),
							employeeBean.getEmail());

				}
			}).start();
			
			session.removeAttribute("message");
			session.setAttribute("message", "Employee updated");
		} else {
			session.setAttribute("message", "Employee Not updated");
		}

		 //response.sendRedirect(request.getContextPath() +"/admin.html");
		modelAndView.setViewName("forward:/showDashboard.html");
		LOGGER.info("Ends updateEmployee method");
		return modelAndView;

	}

	/**
	   * This method is used to create department by admin
	   * @param No parameter
	   */
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam("empId") int empId) throws Exception {

		LOGGER.info("starts deleteEmployee method");
		EmployeeBean employeeBean = new EmployeeBean();
		EmailService email = EmailService;
		employeeBean.setEmpId(empId);

		Integer deleted = adminEmployeeService.deleteEmloyee(employeeBean, new DepartmentBean());

		/* ModelAndView modelAndView = new ModelAndView(); */
		/*
		 * List<EmployeeBean> allEmployees = adminEmployeeService.getAllEmployees();
		 * List<DepartmentBean> departments = departmentService.getAllDepartment();
		 * 
		 * ComplianceBean complianceBean = new ComplianceBean();
		 * 
		 * modelAndView.addObject("compliance", complianceBean);
		 * modelAndView.addObject("departments", departments);
		 * modelAndView.addObject("employee", new EmployeeBean());
		 * modelAndView.addObject("allEmployees",allEmployees);
		 * 
		 * modelAndView.setViewName("adminDashboard");
		 */
		if (deleted > 0) {

			new Thread(new Runnable() {

				@Override
				public void run() {

					email.sendEmail(
							"REALCODERZ", "Hi \n" + employeeBean.getFirstName() + "\n Your details has been Update"
									+ "\n User ID: " + deleted + "\n Password: " + employeeBean.getPassword(),
							employeeBean.getEmail());

				}
			}).start();
			/* modelAndView.addObject("message", "Employee deleted"); */
		} else {
			/* modelAndView.addObject("message", "Employee Not deleted"); */
		}

		LOGGER.info("Ends deleteEmployee method");
		return "redirect:/admin.html";
	}

	/**
	   * This method is used to save the department by admin
	   * @param departmentBean
	   */
	
	@RequestMapping(value = "/createDepartment", method = RequestMethod.POST)
	public ModelAndView createDepartment(@ModelAttribute("department") @Valid DepartmentBean departmentBean, BindingResult result,
			HttpServletResponse response, HttpServletRequest request) throws Exception {
		LOGGER.info("starts createDepartment method");
		/* ModelAndView modelAndView = new ModelAndView(); */
		HttpSession session = request.getSession(false);
		ModelAndView modelAndView = new ModelAndView();
		if (session == null) {
			// redirecting to login page
			
			modelAndView.setViewName("redirect:/index.html");
			return modelAndView;
		}

		
		@SuppressWarnings("unchecked")
		Map<Integer, DepartmentBean> departments = (Map<Integer, DepartmentBean>) session
				.getAttribute("allDepartments");

		DepartmentBean savedDepartmentBean = adminDepartmentService.saveDepartment(departmentBean);
		modelAndView.setViewName("redirect:/admin.html");
		
		if(result.hasErrors())
		{
			return modelAndView;
		}
		if (savedDepartmentBean != null) {
			/*
			 * modelAndView.addObject("message", "Department " +
			 * savedDepartmentBean.getDepartmentName() + "added");
			 */

			// if department added to database add to department list in the session

			departments.put(savedDepartmentBean.getDepartmentId(), savedDepartmentBean);

		} else {
			/* modelAndView.addObject("message", "Department not added"); */

		}

		// response.sendRedirect(request.getContextPath() + "/admin.html");
		
		LOGGER.info("Ends createDepartment method");
		return modelAndView;
	}

	
	
	@ResponseBody
	@RequestMapping(value = "/saveDepartment", method = RequestMethod.POST)
	public String saveDepartment(DepartmentBean departmentBean) {
		LOGGER.info("in save department ");
		DepartmentBean savedDepartment = adminDepartmentService.saveDepartment(departmentBean);

		if (savedDepartment != null) {
			return "seccess";
		} else {
			return "failed";
		}
	}

	@RequestMapping(value = "/showDashboard", method = RequestMethod.POST)
	public ModelAndView loadDashboard(HttpServletRequest request, HttpServletResponse response, Model model)
			throws IOException {
		LOGGER.info("starts loadDashboard method");
		HttpSession session = request.getSession(false);
		System.out.println("Redirected to loadDashboard---------------->");

		if (session == null) {
			System.out.println("Session is " + session);
			response.sendRedirect(request.getContextPath() + "/");
			return null;
		}

		Map<Integer, DepartmentBean> allDepartment = adminDepartmentService.getAllDepartment();
		session.setAttribute("allDepartments", allDepartment);

		System.out.println("After session check ");
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("adminDashboard2");

		List<EmployeeBean> allEmployees = adminEmployeeService.getAllEmployees();
		/* List<DepartmentBean> departments = departmentService.getAllDepartment(); */
		List<ComplianceBean> allCompliance = adminComplianceService.getAllCompliance();

		session.setAttribute("allDepartments", allDepartment);

		modelAndView.addObject("compliance", new ComplianceBean());
		modelAndView.addObject("allCompliance", allCompliance);
		/* modelAndView.addObject("departments", departments); */
		modelAndView.addObject("employee", new EmployeeBean());
		modelAndView.addObject("allEmployees", allEmployees);
		modelAndView.addObject("department", new DepartmentBean());

		LOGGER.info("Ends loadDashboard method");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/empByDepartment", method=RequestMethod.GET)
	@ResponseBody
	public String getEmpoyeesBydepartment(@RequestParam("departmentId") int departmentId)
	{
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>emp method called>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		List<EmployeeBean> allEmployees = departmentEmployeeService.getAllEmployees(departmentId);
		ComplianceBean compliance = adminComplianceService.getCompliance(2);
		//return new Gson().toJson(allEmployees);
		
		System.out.println(compliance);
		
		return new Gson().toJson(allEmployees);
	}
	
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView getErrorPage()
	{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("errorPage");
		
		return modelAndView;
	}
}
