package com.realcoderz.model;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class StatusReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer statusReportId;
	
	@OneToOne 
	@JoinColumn(name="complianceId")
	private Compliance compliance;
	
	@OneToOne  
	@JoinColumn(name="empId")
	private Employee employee;
	private String comments;
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@OneToOne
	@JoinColumn(name="departmentId")
	private Department department;
	public Integer getStatusReportId() {
		return statusReportId;
	}
	public void setStatusReportId(Integer statusReportId) {
		this.statusReportId = statusReportId;
	}
	public Compliance getCompliance() {
		return compliance;
	}
	public void setCompliance(Compliance compliance) {
		this.compliance = compliance;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	

}
