package com.cg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class LoginMicroserviceApplicationTests extends SpringBootTestApplication {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	

	}
