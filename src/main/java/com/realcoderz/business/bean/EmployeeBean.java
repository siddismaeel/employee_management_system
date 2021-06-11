package com.realcoderz.business.bean;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.realcoderz.validator.EmployeeNameValidatorVal;



public class EmployeeBean {
	private Integer empId;
	
	//@EmployeeNameValidatorVal
	@NotEmpty(message = "This field is required")
	private String firstName ;
	//@EmployeeNameValidatorVal
	@NotEmpty(message = "This field is required")
	private String lastName;
	
	@NotNull
	@Past(message="Date should be past date")
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date dob;
	
	//@NotEmpty
	private String email;
	
	private String departmentName;
	private int departmentId;
	
	//@NotNull
	private Integer userId;
	//@NotNull
	private String password ="";
	@NotNull
	private String role;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
