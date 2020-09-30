package com.cg.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.beans.Employee;
import com.cg.beans.Login;
import com.cg.dao.EmployeeDao;
import com.cg.exception.LoginFailureException;
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private EmployeeDao eDao;
	
	int loginSuccess=-1;
	
	@Override
	public Employee validate(Login login) throws LoginFailureException{
		List<Employee> allEmployees = eDao.findAll();
		
		for (int i = 0; i < allEmployees.size(); i++) {
			if(allEmployees.get(i).getEmployeeName().equalsIgnoreCase(login.getName()) && 
					allEmployees.get(i).getPassword().equalsIgnoreCase(login.getPassword())) {
			
				return allEmployees.get(i);	
			}
			
		}
		if(login.getName().equals("") || login.getPassword().equals(""))
		{
			throw new LoginFailureException("Username or Password cannot be empty");		
		}
		else
		{
			throw new LoginFailureException("Login Failed: Invalid username or password");
		}
	}

	public Employee addEmployee(@Valid Employee employee) {
		return this.eDao.save(employee);
	}

	public boolean removeEmployee(@Valid Employee employee) {
		// TODO Auto-generated method stub
		 this.eDao.deleteById(employee.getEmployeeId());
		 return true;
	}

}
