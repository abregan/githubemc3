import { Component, OnInit } from '@angular/core';
import { Admin } from '../../class/admin';
import { AdminService } from '../../service/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css'] 
})
export class AdminloginComponent implements OnInit {
  admin: Admin = new Admin(0, "", "","","")
  admins: Admin = JSON.parse(sessionStorage.getItem("admin"))

  constructor(private adminservices:AdminService,private router:Router) { }

  ngOnInit(): void {
  }
  Getlogin(): void {

    this.adminservices.getlogin(this.admin).subscribe(data => {
      alert("Login Successfully"),
        console.log("login response" + data)

      sessionStorage.setItem("admin", JSON.stringify(data))

      this.router.navigateByUrl("/adminhome")

    },
      error => alert("Sorry Please Enter correct Username And Password"));

  } 
  newregistration(){
    this.router.navigateByUrl("/adminregister")
  }
 
}
