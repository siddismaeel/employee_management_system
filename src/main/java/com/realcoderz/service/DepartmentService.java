package com.realcoderz.service;

import java.util.List;

import com.realcoderz.business.bean.DepartmentBean;

public interface DepartmentService {

	public DepartmentBean getdepartment(int departmentId);

	public List<DepartmentBean> getAllDepartment();

	public boolean saveDepartment(DepartmentBean departmentBean);

	public boolean updateDepartment(DepartmentBean departmentBean);

	public boolean deleteDepartment(DepartmentBean departmentBean);
}
