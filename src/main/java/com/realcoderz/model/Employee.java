package com.realcoderz.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer empId;
	private String firstName;
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	private String email;
	
	
	@OneToOne(targetEntity=Department.class, cascade=CascadeType.ALL)  
	@JoinColumn(name="departmentId")
	private Department department;
	
	@OneToOne(targetEntity=LoginMaster.class, cascade=CascadeType.ALL)  
	@JoinColumn(name="userId")
	private LoginMaster loginMaster;
	
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public LoginMaster getLoginMaster() {
		return loginMaster;
	}
	public void setLoginMaster(LoginMaster loginMaster) {
		this.loginMaster = loginMaster;
	}
	
	

}
