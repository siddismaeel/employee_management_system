package com.realcoderz.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.realcoderz.test.integration.AdminTest;
import com.realcoderz.test.integration.DepartmentTest;
import com.realcoderz.test.integration.EmployeeTest;
import com.realcoderz.test.integration.LoginTest;
import com.realcoderz.test.integration.ResetCredentials;
import com.realcoderz.test.integration.UtilTest;
import com.realcoderz.test.unit.AdminUnit;
import com.realcoderz.test.unit.DepartmentUnit;
import com.realcoderz.test.unit.EmployeeUnit;

 
@RunWith(Suite.class)
@SuiteClasses({AdminTest.class, DepartmentTest.class,DepartmentUnit.class,EmployeeUnit.class,EmployeeTest.class, LoginTest.class, UtilTest.class, AdminUnit.class, ResetCredentials.class})
public class AllTests {
  
}
