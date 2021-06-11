package com.realcoderz.dao.login;

import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.business.bean.LoginMasterBean;

public interface LoginEmployeeDao {
	
	public LoginMasterBean getLoginMasterByUserId(int userId);
	
	public EmployeeBean getEmployeeByUserId(int userId);

}
