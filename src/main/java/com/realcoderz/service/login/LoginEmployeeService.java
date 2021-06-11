package com.realcoderz.service.login;

import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.business.bean.LoginMasterBean;

public interface LoginEmployeeService {

	public LoginMasterBean getLoginMasterByUserId(int userId);

	public EmployeeBean getEmployeeByUserId(int userId);
}
