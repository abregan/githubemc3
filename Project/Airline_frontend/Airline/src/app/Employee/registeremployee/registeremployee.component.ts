import { Component } from '@angular/core';
import { Employeeair } from '../../class/employeeair';
import { EmployeeairService } from '../../service/employeeair.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registeremployee',
  templateUrl: './registeremployee.component.html',
  styleUrls:['./registeremployee.component.css']
})
export class RegisteremployeeComponent {
  employeeair: Employeeair = new Employeeair(0,"", "","","","","","")
  isEditable: any;
  constructor(private employeeairService:EmployeeairService,private router:Router) { }

  ngOnInit(): void 
  {
    
  }
  SaveEmployee(){
    if(this.isEditable){
    this.employeeairService.updateEmployee(this.employeeair).subscribe(data=>{
      alert("Successfully updated "+this.employeeair.empname)
      sessionStorage.clear()
      localStorage.clear()
      this.router.navigateByUrl("/employeelogin")});
    }
    else{
      
      this.employeeairService.SaveEmployee(this.employeeair).subscribe(data =>{
        alert("Successfully Register ")
        this.router.navigateByUrl("/employeelogin")
      },
      error => alert("enter the employee data ")
        );
        
    }
  }
  }


