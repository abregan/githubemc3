import { Component } from '@angular/core';
import { UserairService } from '../../service/userair.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Userair } from '../../class/userair';

@Component({
  selector: 'app-userprofile',
  templateUrl: './userprofile.component.html',
  styleUrl: './userprofile.component.css'
})
export class UserprofileComponent {
  username:any
  userair:Userair;
  isEditable:boolean;
  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe(() => this.userair= JSON.parse(sessionStorage.getItem("userair")))
    this.checkSessionAndNavigate();
  }
  constructor(private userairservice: UserairService, public router: Router, private activeRoute: ActivatedRoute) { }
  getUserById(){
    const username=this.userair.username;
    console.log(username);
    if(username!=null){
      this.isEditable=true;
      this.userairservice.getUserByUsername("username").subscribe(data=>{
        this.userair=data;
        console.log(this.userair)
      });
    }
  }
  checkSessionAndNavigate() {
    if (!this.userair) {
      alert("login failed")
      this.router.navigateByUrl("/userlogin");
    }
}
newregistration(){
  this.router.navigateByUrl("/userregister")
}

homepage():void{
  this.router.navigateByUrl("/welcomeuser");
}
}
