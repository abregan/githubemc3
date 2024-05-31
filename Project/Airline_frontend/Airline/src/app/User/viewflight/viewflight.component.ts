import { Component } from '@angular/core';
import { FlightService } from '../../service/flight.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Userair } from '../../class/userair';

@Component({
  selector: 'app-viewflight',
  templateUrl: './viewflight.component.html',
  styleUrl: './viewflight.component.css'
})
export class ViewflightComponent {
  flight:any;
  userair:Userair;
  hasSearchName:boolean;
  searchName:string;
  constructor(private flightservice:FlightService,private router:Router, private activeRoute:ActivatedRoute){}
  
  ngOnInit():void
  {
    this.activeRoute.paramMap.subscribe(()=>this.getAllFlights());
    this.activeRoute.paramMap.subscribe(()=>this.userair=JSON.parse(sessionStorage.getItem("userair")));
  }
  getAllFlights()
  {
    this.hasSearchName=this.activeRoute.snapshot.paramMap.has("flightName");
    if(this.hasSearchName){
      this.searchName=this.activeRoute.snapshot.paramMap.get("flightName");
      console.log(this.searchName)
      this.flightservice.getFlightByFlightName(this.searchName).subscribe(data=>{
        console.log(data);
        this.flight=data;
      })
    }
    else{
      this.flightservice.getAllFlights().subscribe(data=>{
        console.log(data);
        this.flight=data;
      })
    }
  }
  AddBooking(id:number)
  {
    this.router.navigateByUrl("userair/addbooking/"+id);
  }

homepage():void{
  this.router.navigateByUrl("/welcomeuser");
}


}


