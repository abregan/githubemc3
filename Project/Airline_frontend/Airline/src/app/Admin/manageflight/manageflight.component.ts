import { Component } from '@angular/core';
import { Admin } from '../../class/admin';
import { FlightService } from '../../service/flight.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-manageflight',
  templateUrl: './manageflight.component.html',
  styleUrl: './manageflight.component.css'
})
export class ManageflightComponent {
  flight:any;
  hasSearchName: boolean;
    searchName: string;
    admin:Admin;

    
    constructor(private flightService:FlightService,private router:Router,private activateRoute:ActivatedRoute){}
   
    ngOnInit():void{
      this.getAllFlights();
      this.activateRoute.paramMap.subscribe(()=>this.flight=JSON.parse(sessionStorage.getItem("flight")));
    }
    getAllFlights():void
    { 
      this.hasSearchName=this.activateRoute.snapshot.paramMap.has("flightName");
    if(this.hasSearchName)
    {
      this.searchName=this.activateRoute.snapshot.paramMap.get("flightName");
      console.log(this.searchName)
      this.flightService.getFlightByFlightName(this.searchName).subscribe(data=>{
        console.log(data);
        this.flight=data;
      })
    }
  else{
    this.flightService.getAllFlights().subscribe(data=>{
      console.log(data);
      this.flight=data;
    });

    }
  }
  SaveFlight():void{
    this.router.navigateByUrl("/addflight");
  }

  homepage():void{
    this.router.navigateByUrl("/adminhome");
  }

  deleteFlight(flightId:number)
{
  console.log(flightId);
  if(confirm("Do you want to delete ?"))
  {
    this.flightService.deleteFlight(flightId).subscribe(data=>{
      console.log(data);
      this.getAllFlights();
    })
  };
}
updateFlight(flightId:number)
{
  this.router.navigateByUrl("/updateFlight/"+flightId);

} 
}


