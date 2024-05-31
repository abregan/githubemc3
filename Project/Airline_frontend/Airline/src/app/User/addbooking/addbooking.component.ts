import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingService } from '../../service/booking.service';
import { FlightService } from '../../service/flight.service';
import { Userair } from '../../class/userair';
import { Booking } from '../../class/booking';
import { Flight } from '../../class/flight';


@Component({
  selector: 'app-addbooking',
  templateUrl: './addbooking.component.html',
  styleUrls: ['./addbooking.component.css']
})
export class AddbookingComponent implements OnInit{
  userid:number;
  flightId:number;
  seatstobook:number;
  userair:Userair;
  booking:Booking
  flight:Flight=new Flight(0,"","","","","",0,0);
  seat:any=0;
  isEditable:boolean;
  amount:number;
  
    constructor(private http: HttpClient, public router: Router,private activeRoute: ActivatedRoute,private flightservice:FlightService,private bookingservice:BookingService){}
  ngOnInit(): void {
    this.activeRoute.paramMap.subscribe(()=>this.userair=JSON.parse(sessionStorage.getItem("userair")));
    this.getFlightById();
   
 
    }
  getFlightById(){
    const flightId=parseFloat(this.activeRoute.snapshot.paramMap.get("id"));
    console.log(flightId);
    if(flightId>0){
      this.isEditable=true;
      this.flightservice.getFlightById(flightId).subscribe(data=>{
        this.flight=data;
        console.log(this.flight)
      });
    }
  }
  placeBooking(){
    const flightId=this.flight.flightId;
    const userid=this.userair.userid;
    const seat={seatstobook:this.seatstobook};
    this.bookingservice.Booking(flightId,userid,seat).subscribe(
      (response)=>{
        console.log(userid);
        console.log(flightId);
        console.log('booking placed successfully',response);
        alert('booking successful')
        console.log(seat);
        localStorage.setItem("generatedBookingId",response.booking_id);
        this.router.navigateByUrl("/userair/paymentoptions");
      },
      (error)=>{
        console.error('error to book flight',error);
      }
    )
  }
homepage():void{
  this.router.navigateByUrl("/welcomeuser");
}

}



