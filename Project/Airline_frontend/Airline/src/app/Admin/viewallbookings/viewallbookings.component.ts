import { Component } from '@angular/core';
import { Userair } from '../../class/userair';
import { BookingService } from '../../service/booking.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Flight } from '../../class/flight';

@Component({
  selector: 'app-viewallbookings',
  templateUrl: './viewallbookings.component.html',
  styleUrl: './viewallbookings.component.css'
})
export class ViewallbookingsComponent {
  booking:any;
  hasSearchId: boolean;
  searchId: number;
  userair:Userair;
  flight:Flight;
  amount:any;
  constructor(private bookingservice:BookingService,public router:Router, private activeRoute:ActivatedRoute) { }
  ngOnInit(): void 
      {
        this.activeRoute.paramMap.subscribe(()=>this.getAllBookings());
        this.activeRoute.paramMap.subscribe(()=>this.userair=JSON.parse(sessionStorage.getItem("userair")))
        
      }
      getAllBookings()
      {
        this.hasSearchId = this.activeRoute.snapshot.paramMap.has("booking_id");
           if(this.hasSearchId)
           {this.searchId  = Number(this.activeRoute.snapshot.paramMap.get("booking_id"));
            console.log(this.searchId)
            this.bookingservice.getbookingbyid(this.searchId).subscribe(data=>{
            console.log(data);
            this.booking= data;
            })
          }
          else{
          this.bookingservice.getAllBookings().subscribe(data=>{
            console.log(data);
            this.booking=data;
          });
        }
      }
      homepage():void{
        this.router.navigateByUrl("/adminhome");
      }
}
