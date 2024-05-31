import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Flight } from '../class/flight';

@Injectable({
  providedIn: 'root'
})
export class FlightService {
  private flightlisturl="http://localhost:8080/flight/viewAllFlight";
  private addflighturl="http://localhost:8080/flight/addFlight";
  private deleteflighturl="http://localhost:8080/flight/deleteFlight";
  private updateflighturl="http://localhost:8080/flight/updateFlight";
  private flightbynameurl="http://localhost:8080/flight/searchFlightName";
  private flightbuidurl="http://localhost:8080/flight/findFlightId";
  
  
  constructor(private http:HttpClient) { }
  getAllFlights():Observable<any>
  {
    return this.http.get(this.flightlisturl);
   }
   SaveFlight(flight:Flight):Observable<any>
   {
     const httpOptions = {
       headers : new HttpHeaders({
           'Content-Type' : 'application/json',
           'Authorization' : 'auth-token',
           'Access-Control-Allow-Origin' : '*'
       })
     };
     return  this.http.post<Flight>(this.addflighturl,flight,httpOptions);
   }

   deleteFlight(flightId: number) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'auth-token',
        'Access-Control-Allow-Origin': '*'
      })
    };
  
    return this.http.delete<Flight>(`${this.deleteflighturl}/${flightId}`, httpOptions);
  }
  updateFlight(flight:Flight):Observable<any>
  {
    const headers={'content-type':'application/json'};
    const body=JSON.stringify(flight);
    return this.http.put(this.updateflighturl,body,{'headers':headers});
  }
  
  getFlightByFlightName(flightName:any):Observable<Flight>
  {
    const searchURL =   "http://localhost:8080/flight/searchFlightName/findByflightNameIgnoreCase?flightName=" + flightName;
  
    return  this.http.get<Flight>(searchURL);
  }
  getFlightById(flightId:number):Observable<Flight>
  {
    const flightidurl=this.flightbuidurl+"/"+flightId;
    return this.http.get<Flight>(flightidurl);
  }

}
