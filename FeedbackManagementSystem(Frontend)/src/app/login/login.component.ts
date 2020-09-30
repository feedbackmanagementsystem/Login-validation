import { Component, OnInit } from '@angular/core';
import { Login } from '../models/login.model';
import { Router } from '@angular/router';
import { LoginService } from '../service/login.service';
import { EmployeeModel } from '../models/employee.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  login : Login; 
  employee : EmployeeModel;
  id : String;
  

  constructor(private route: Router, private loginservice: LoginService) { 
    this.login = new Login();
    this.employee = new EmployeeModel();
    
  }

  ngOnInit() {
   
  }

 

  checkRole(emp : EmployeeModel){
    
    if(emp==null){
      alert("Invalid Username and Password");
    }

    //localStorage.setItem('user',this.employee.employeeId);
    sessionStorage.setItem('user',this.employee.employeeId);
    console.log(emp.role);
    
    if(emp.role=="admin"){
      this .route.navigate(['admin']);
    }else if(emp.role=="coordinator"){
      this.route.navigate(['coordinator']);
    }else if(emp.role=="participant"){
      this.route.navigate(['participant']);
    }else{
      alert("You are not registered!");
    }
  }
  
 
  checkLogin(){
    console.log(this.login);
    this.loginservice.getEmployee(this.login).subscribe((data) =>{
        this.employee = data;
        this.checkRole(this.employee);
      });
    } 

   
  }


