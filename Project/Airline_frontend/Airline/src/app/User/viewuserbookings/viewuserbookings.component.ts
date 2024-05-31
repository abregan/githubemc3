import { Component, OnInit } from '@angular/core';
import { Userair } from '../../class/userair';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingService } from '../../service/booking.service';
import { Flight } from '../../class/flight';

@Component({
  selector: 'app-viewuserbookings',
  templateUrl: './viewuserbookings.component.html',
  styleUrl: './viewuserbookings.component.css'
})
export class ViewuserbookingsComponent implements OnInit{
  booking:any
  userair:Userair
  isEditable: boolean;
  seatstobook:number;
  amount:number;
  flight:Flight;
 

  constructor(private bookingservice:BookingService,private router: Router, private activateRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activateRoute.paramMap.subscribe(()=>this.userair=JSON.parse(sessionStorage.getItem("userair")));
    this.activateRoute.paramMap.subscribe(()=>this.getBookingByUserId());
   
    this.checkSessionAndNavigate();
  }

  getBookingByUserId(){
    const uid=this.userair.userid;
    console.log(uid);
    if(uid>0){
      this.isEditable=true;
      this.bookingservice.getBookingByUserId(uid).subscribe(data=>{
        this.booking=data;
        console.log(this.booking)
      });
    }
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
  homepage(){
    this.router.navigateByUrl("/welcomeuser");
  }
  checkSessionAndNavigate() {
    if (!this.userair) {
      this.router.navigateByUrl("/userlogin");
    }

  }
  


}
