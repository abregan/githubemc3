import { Component, OnInit } from '@angular/core';
import { Employeeair } from '../../class/employeeair';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeairService } from '../../service/employeeair.service';

@Component({
  selector: 'app-employeehome',
  templateUrl: './employeehome.component.html',
  styleUrl: './employeehome.component.css'
})
export class EmployeehomeComponent implements OnInit {
  employeeair:Employeeair=new Employeeair(0,"","","","","","","")
  isEditable: any;
  
  constructor( private employeeairService:EmployeeairService,private activateroute:ActivatedRoute,private router:Router){}
  ngOnInit(): void {
    this.activateroute.paramMap.subscribe(()=>this.employeeair=JSON.parse(sessionStorage.getItem("employeeair")))
  }
  logout() {
    if (sessionStorage.getItem("employeeair")) {
      sessionStorage.clear()
      localStorage.clear()
      alert("Logout Successfully")
      this.router.navigateByUrl("/employeelogin")
    }
    else {
      alert("No user loged in")
    }
  }
 

}
