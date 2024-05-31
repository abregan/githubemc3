import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../service/admin.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from '../../class/admin';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrl: './adminhome.component.css'
})
export class AdminhomeComponent implements OnInit{
  admin: Admin=new Admin(0,"","","","");
  
  constructor(private activateroute:ActivatedRoute,private route:Router) { }
  ngOnInit(): void 
  {
    this.activateroute.paramMap.subscribe(()=>this.admin=JSON.parse(sessionStorage.getItem("admin")))

  }

  logout() {
    if (sessionStorage.getItem("admin")) {
      sessionStorage.clear()
      localStorage.clear()
      alert("Logout Successfully")
      this.route.navigateByUrl("/adminlogin")
    }
    else {
      alert("No user loged in")
    }
  }
  
}
