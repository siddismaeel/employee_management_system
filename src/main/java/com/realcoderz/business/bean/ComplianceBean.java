package com.realcoderz.business.bean;

import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;


public class ComplianceBean {
	private int complianceId;
	private String rlType = "Enter RL Type";
	private String fileTitle = "Enter Details";
	private String filePath;
	private Date createDate;
	private String departmentName = "Department Name";
	private String status;
	private int departmentId;
	private CommonsMultipartFile file;
	 
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
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
		
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setComplianceId(int complianceId) {
		this.complianceId = complianceId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public CommonsMultipartFile getFile() {
		return file;
	}
	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
	@Override
	
	public String toString() {
		return "ComplianceBean [complianceId=" + complianceId + ", rlType=" + rlType + ", fileTitle=" + fileTitle
				+ ", filePath=" + filePath + ", createDate=" + createDate + ", departmentName=" + departmentName
				+ ", status=" + status + ", departmentId=" + departmentId + ", file=" + file + "]";
	}
	
	
}
