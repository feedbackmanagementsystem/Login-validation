package com.cg.service;

import com.cg.beans.Employee;
import com.cg.beans.Login;
import com.cg.exception.LoginFailureException;

public interface LoginService {
	
	public Employee validate(Login login) throws LoginFailureException;
	public Employee addEmployee(Employee employee);
	public boolean removeEmployee(Employee employee);
}
