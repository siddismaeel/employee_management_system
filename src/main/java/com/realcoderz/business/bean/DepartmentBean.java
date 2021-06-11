package com.realcoderz.business.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class DepartmentBean {
	
	private Integer departmentId;
	@NotEmpty(message = "This field is required")
	private String departmentName;
	
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
