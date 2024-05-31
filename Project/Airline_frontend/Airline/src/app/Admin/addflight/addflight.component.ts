import { Component } from '@angular/core';
import { Flight } from '../../class/flight';
import { Time } from "@angular/common";
import { FlightService } from '../../service/flight.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-addflight',
  templateUrl: './addflight.component.html',
  styleUrl: './addflight.component.css'
})
export class AddflightComponent {
  flight:Flight=new Flight(0,"","","","","",0,0);
  isEditable:any;

  constructor(private flightService:FlightService,private router:Router,private activateRoute:ActivatedRoute){}
  ngOnInit(): void {
    this.flight
    this.activateRoute.paramMap.subscribe(()=>this.flight);
    this.getFlightById();
    }

    onSubmit()
    {
      console.log(this.flight);
      if(this.isEditable){
        alert("Updated Successfully"); 
        this.flightService.updateFlight(this.flight).subscribe(data=>
          this.router.navigateByUrl("/flightlist"));
      }
      else{
        this.flightService.SaveFlight(this.flight).subscribe(data=>
          console.log(data));
          this.router.navigateByUrl("/flightlist");
      }
    }
  getFlightById(){
      const flightId=parseFloat(this.activateRoute.snapshot.paramMap.get("flightId"));
      console.log(flightId);
      if(flightId>0){
        this.isEditable=true;
        this.flightService.getFlightById(flightId).subscribe(data=>{
          this.flight=data;
          console.log(this.flight)
        })
      }

    }
}
