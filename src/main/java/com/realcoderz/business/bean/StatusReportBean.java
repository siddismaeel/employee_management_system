package com.realcoderz.business.bean;



import java.util.Date;

import com.realcoderz.model.Compliance;
import com.realcoderz.model.Department;
import com.realcoderz.model.Employee;


public class StatusReportBean {

	private Integer statusReportId;
	
	/* Compliance details */
	private Integer complianceId;
	private String rlType;
	private String fileTitle;
	private String filePath;
	private Date createDate;
	private String status;
	
	/* Employee details */
	private Integer empId;
	private String firstName;
	private String lastName;
	private Date dob;
	private String email;
	
	/* Department details */
	private String departmentName;
	private Integer departmentId;
	
	private String comments;
	private Date commentDate;
	
	
	public Integer getStatusReportId() {
		return statusReportId;
	}
	public void setStatusReportId(Integer statusReportId) {
		this.statusReportId = statusReportId;
	}
	public Integer getComplianceId() {
		return complianceId;
	}
	public void setComplianceId(Integer complianceId) {
		this.complianceId = complianceId;
	}
	public String getRlType() {
		return rlType;
	}
	public void setRlType(String rlType) {
		this.rlType = rlType;
	}
	
	public String getFileTitle() {
		return fileTitle;
	}
	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
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
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	
	
	
	
}
