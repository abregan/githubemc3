import { Component, OnInit } from '@angular/core';
import { Admin } from '../../class/admin';
import { AdminService } from '../../service/admin.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-adminprofile',
  templateUrl: './adminprofile.component.html',
  styleUrls: ['./adminprofile.component.css']
})
export class AdminprofileComponent implements OnInit{
  adminName:any
  admin:any;
  isEditable: boolean;
  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe(() => this.admin= JSON.parse(sessionStorage.getItem("admin")))
    this.checkSessionAndNavigate();
  }
  constructor(private adminservice: AdminService, public router: Router, private activeRoute: ActivatedRoute) { }
  getAdminById() {
    const adminName = this.admin.adminName;

    console.log(adminName);
    if (adminName != null) {
      this.isEditable = true;
      this.adminservice.getAdminByAdminName("username").subscribe(data => {
        this.admin = data;
        console.log(this.admin)
      });
    }
  }
  /*
  logout() {
    if (sessionStorage.getItem("admin")) {
      sessionStorage.clear()
      localStorage.clear()
      alert("Back to Homeopage Successfully")
      this.router.navigateByUrl("/adminhome")
    }
    else {
      alert("No admin loged in")
    }
  }
  */
  checkSessionAndNavigate() {
    if (!this.admin) {
      alert("login failed")
      this.router.navigateByUrl("/adminlogin");
    }
}
newregistration(){
  this.router.navigateByUrl("/adminregister")
}

homepage():void{
  this.router.navigateByUrl("/adminhome");
}

updateAdmin(adminid:number){
  this.router.navigateByUrl("/updateAdmin/"+adminid);
}

}
