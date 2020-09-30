package com.cg.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.beans.Employee;
import com.cg.beans.Login;
import com.cg.exception.LoginFailureException;
import com.cg.service.LoginServiceImpl;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginServiceImpl service;
	//http://localhost:5056/login/validate
	@RequestMapping(value = "/validate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee validate(@RequestBody Login login) throws LoginFailureException {
		Employee employee = service.validate(login);
		return employee;		
	}
	
	@PostMapping("/addEmployee")
	public Employee createUsers(@Valid @RequestBody Employee employee)
	{
		return this.service.addEmployee(employee);
	}
	
	@DeleteMapping("/removeEmployee")
	public  boolean deleteUsers(@Valid @RequestBody Employee employee)
	{
		return this.service.removeEmployee(employee);

	}
	
}
