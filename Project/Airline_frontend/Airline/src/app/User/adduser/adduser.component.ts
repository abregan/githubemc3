import { Component } from '@angular/core';
import { Userair } from '../../class/userair';
import { UserairService } from '../../service/userair.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrl: './adduser.component.css'
})
export class AdduserComponent {
  userair: Userair = new Userair(0, "", "", "", "", "", "","")
  userairs: Userair = JSON.parse(sessionStorage.getItem("userair"))
  isEditable: any;
  constructor(private userairservice:UserairService,private router:Router,private activeroute:ActivatedRoute) { }

  ngOnInit(): void {
    this.activeroute.paramMap.subscribe(()=>this.userair);
    this.getUserById();
  }
  onSubmit() {
    console.log(this.userair);
    if (this.isEditable) {
      this.userairservice.updateUser(this.userair).subscribe(data => {
        alert("Updated Successfully"); // Corrected alert message location
        this.router.navigateByUrl("/userlist");
      });
    } else {
      this.userairservice.saveUser(this.userair).subscribe(data => {
        alert("Added Successfully"); // Corrected alert message location
        this.router.navigateByUrl("/userlist");
      });
    }
  }
 

  getUserById(){
    const userid = parseFloat(this.activeroute.snapshot.paramMap.get("userid"));

  console.log(userid);
  if(userid> 0)
  {
    this.isEditable = true;
    this.userairservice.getUserById(userid).subscribe(data=>{
      this.userair = data;
      console.log(this.userair)
    });
  }
  }
  


}
