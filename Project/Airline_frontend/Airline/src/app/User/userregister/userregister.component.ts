import { Component } from '@angular/core';
import { Userair } from '../../class/userair';
import { UserairService } from '../../service/userair.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-userregister',
  templateUrl: './userregister.component.html',
  styleUrl: './userregister.component.css'
})
export class UserregisterComponent {
  userair: Userair = new Userair(0, "", "", "", "", "", "","")
  userairs: Userair = JSON.parse(sessionStorage.getItem("userair"))
  isEditable: any;
  constructor(private userairservice:UserairService,private router:Router) { }

  ngOnInit(): void {
  }
  SaveUsers(){
    if(this.isEditable){
      this.userairservice.updateUser(this.userair).subscribe(data=>{
        alert("Successfully updated "+this.userair.username)
        sessionStorage.clear()
        localStorage.clear()
        this.router.navigateByUrl("/userlogin")});
    }
    else{
      
    this.userairservice.saveUser(this.userair).subscribe(data =>{
      alert("Successfully Register ")
      this.router.navigateByUrl("/userlogin")
    },
    error => alert("enter the user data ")
      );
      
  }


  }
}

