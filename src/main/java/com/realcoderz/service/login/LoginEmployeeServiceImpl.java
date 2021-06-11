package com.realcoderz.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realcoderz.business.bean.EmployeeBean;
import com.realcoderz.business.bean.LoginMasterBean;

import com.realcoderz.dao.login.LoginEmployeeDao;

@Service
public class LoginEmployeeServiceImpl implements LoginEmployeeService {

	@Autowired
	private LoginEmployeeDao employeeDao;

	@Override
	public LoginMasterBean getLoginMasterByUserId(int userId) {
		LoginMasterBean loginBean = employeeDao.getLoginMasterByUserId(userId);
		return loginBean;
	}

	@Override
	public EmployeeBean getEmployeeByUserId(int userId) {
		EmployeeBean employeeBean = employeeDao.getEmployeeByUserId(userId);
		return employeeBean;
	}

}
