import { Component } from '@angular/core';
import { Userair } from '../../class/userair';
import { UserairService } from '../../service/userair.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-welcomeuser',
  templateUrl: './welcomeuser.component.html',
  styleUrl: './welcomeuser.component.css'
})
export class WelcomeuserComponent {
  userair: Userair = new Userair(0, "", "", "", "", "", "","")
  userairs: Userair = JSON.parse(sessionStorage.getItem("userair"))
  isEditable: any;
  constructor(private userairservice:UserairService,private router:Router,private activeroute:ActivatedRoute) { }

  ngOnInit(): void {
    this.activeroute.paramMap.subscribe(()=>this.userair=JSON.parse(sessionStorage.getItem("userair")))
  }
  logout() {
    if (sessionStorage.getItem("userair")) {
      sessionStorage.clear()
      localStorage.clear()
      alert("Logout Successfully")
      this.router.navigateByUrl("/userlogin")
    }
    else {
      alert("No user loged in")
    }
  }


}
