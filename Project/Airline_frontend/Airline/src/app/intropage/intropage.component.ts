import { Component, OnInit } from '@angular/core';
import { Admin } from '../class/admin';
import { ActivatedRoute, Router } from '@angular/router';
import { Employeeair } from '../class/employeeair';
import { Userair } from '../class/userair';

@Component({
  selector: 'app-intropage',
  templateUrl: './intropage.component.html',
  styleUrl: './intropage.component.css'
})
export class IntropageComponent implements OnInit{

  admin:Admin
  employeeair:Employeeair
  userair:Userair
  

  constructor(private activateroute:ActivatedRoute,private route:Router) { }
  ngOnInit(): void 
  {
    this.activateroute.paramMap.subscribe(()=>this.admin=JSON.parse(sessionStorage.getItem("admin")))
    this.activateroute.paramMap.subscribe(()=>this.admin=JSON.parse(sessionStorage.getItem("employeeair")))
    this.activateroute.paramMap.subscribe(()=>this.admin=JSON.parse(sessionStorage.getItem("userair")))
    
  }

  clickadmin() {
      this.route.navigateByUrl("/adminlogin")
    }
    clickuser() {
      this.route.navigateByUrl("/userlogin")
    }
    clickemployee() {
      this.route.navigateByUrl("/employeelogin")
    }
}
