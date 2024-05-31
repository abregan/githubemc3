import { Component } from '@angular/core';
import { Userair } from '../../class/userair';
import { UserairService } from '../../service/userair.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent {
  userair: Userair = new Userair(0, "", "", "", "", "", "","")
  userairs: Userair = JSON.parse(sessionStorage.getItem("userair"))
  constructor(private userairservice:UserairService,private router:Router) { }

  ngOnInit(): void {
  }
  Getlogin(): void {
    this.userairservice.getlogin(this.userair).subscribe(data=>{
      alert("Login Successfully"),
        console.log("login response" + data)
        sessionStorage.setItem("userair",JSON.stringify(data))
      this.router.navigateByUrl("/welcomeuser")
  },
  error=>alert("Sorry please Enter correct Username And Password"));
  }
  newregistration(){
    this.router.navigateByUrl("/userregister")
  }
  onSubmit() {
    this.router.navigateByUrl("/userlist");

  }


}

