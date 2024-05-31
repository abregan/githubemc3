import { Component, OnInit } from '@angular/core';
import { EmployeeairService } from '../../service/employeeair.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employeeprofile',
  templateUrl: './employeeprofile.component.html',
  styleUrls: ['./employeeprofile.component.css']
})
export class EmployeeprofileComponent implements OnInit{
  empname:any
  employeeair:any
  isEditable:boolean;
  
  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe(() => this.employeeair= JSON.parse(sessionStorage.getItem("employeeair")))
    
  }
  constructor(private employeeairservice:EmployeeairService,public router:Router,private activeRoute:ActivatedRoute){}
  
  getEmloyeeById() {
    const empname = this.employeeair.empname;

    console.log(empname);
    if (empname != null) {
      this.isEditable = true;
      this.employeeairservice.getEmployeeByEmployeename("empname").subscribe(data => {
        this.employeeair = data;
        console.log(this.employeeair)
      });
    }
  }

  

  updateEmployee() {
    // Implement your logic to update the employee details using a service
    this.employeeairservice.updateEmployee(this.employeeair).subscribe(() => {
      // After successfully updating, reset the form and make it non-editable
      this.isEditable = false;
      // You might want to fetch the updated employee details again
      this.getEmloyeeById();
      this.router.navigate(['/updateemployee']); 
    });
  }

  homepage():void{
    this.router.navigateByUrl("/employeehome");
  }

}
