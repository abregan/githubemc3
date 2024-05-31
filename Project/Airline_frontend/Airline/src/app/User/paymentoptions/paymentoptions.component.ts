import { Component, OnInit } from '@angular/core';
import { Flight } from '../../class/flight';
import { Userair } from '../../class/userair';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { BookingService } from '../../service/booking.service';
@Component({
  selector: 'app-paymentoptions',
  templateUrl: './paymentoptions.component.html',
  styleUrl: './paymentoptions.component.css'
})
export class PaymentoptionsComponent implements OnInit{
  booking_id:number;
  flightId:number;
  price:number;
  amount:number;
  booking:any;
  seatstobook:number;
  flight:Flight;
  userair:Userair;
  constructor(private bookingservice:BookingService,private activeRoute:ActivatedRoute,private router:Router){}
  ngOnInit():void{
    this.activeRoute.paramMap.subscribe(()=>this.getBookingDetails());
    this.activeRoute.paramMap.subscribe(()=>this.userair=JSON.parse(sessionStorage.getItem("userair")));
    this.checkSessionAndNavigate();
  }
  getBookingDetails(){
    this.booking_id=parseInt(localStorage.getItem("generatedBookingId"));
    if(this.booking_id){
      this.bookingservice.getbookingbyid(this.booking_id).subscribe(
        (data)=>{
          this.booking=data;
          this.seatstobook=this.booking.seatstobook
          this.flightId=this.booking.flight.flightId
          this.amount=this.booking.seatstobook*this.booking.flight.price
        },
        (error)=>{
          console.error('Error fetching booking deails',error);
        }
      );
     
    }
  }
  
  redirectToPayment(paymentMethod: string) {
    if (paymentMethod === 'cod') {
      this.router.navigateByUrl('/userair/mybookings');
    } else if (paymentMethod === 'online') {
      this.router.navigateByUrl('/userair/addpayment');
    }
  }
  checkSessionAndNavigate() {
    if (!this.userair) {
      this.router.navigateByUrl("/userlogin");
    }
  }
}
