import { Component } from '@angular/core';
import { Admin } from '../../class/admin';
import { AdminService } from '../../service/admin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminregister',
  templateUrl: './adminregister.component.html',
  styleUrl: './adminregister.component.css'
})
export class AdminregisterComponent {

  admin: Admin=new Admin(0,"","","","");
  isEditable: any;
  constructor(private adminservice:AdminService,private router:Router) { }

  ngOnInit(): void 
  {
    
  }
  SaveAdmin(){
    if(this.isEditable){
      this.adminservice.updateAdmin(this.admin).subscribe(data=>{
        alert("Successfully updated "+this.admin.adminName)
        sessionStorage.clear()
        localStorage.clear()
        this.router.navigateByUrl("/adminlogin")});
    }
    else{
      
    this.adminservice.saveAdmin(this.admin).subscribe(data =>{
      alert("Successfully Register ")
      this.router.navigateByUrl("/adminlogin")
    },
    error => alert("enter the admin data ")
      );
      
  }
}

}
