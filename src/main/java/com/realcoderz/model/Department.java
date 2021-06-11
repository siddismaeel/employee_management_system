package com.realcoderz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer departmentId;
	private String departmentName;
	
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getDeparmentName() {
		return departmentName;
	}
	public void setDeparmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
	
}
