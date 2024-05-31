import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Booking } from '../class/booking';
import { Userair } from '../class/userair';
import { Flight } from '../class/flight';

@Injectable({
  providedIn: 'root'
})
export class BookingService { 
  private newuserurl = "http://localhost:8080/userair/registerUser";
private flightsaveURl = "http://localhost:8080/flight/addFlight";
private addbookingurl="http://localhost:8080/booking/bookflight";
private getbookingidurl="http://localhost:8080/booking";
private deletebookurl="http://localhost:8080/booking/deleteBooking";
private getbookingbyuseridurl="http://localhost:8080/booking/user";
private getallbookurl="http://localhost:8080/booking/viewallbookings";

constructor(private http:HttpClient) { }
saveUser(userair: Userair): Observable<Userair> {
    const httpOptions = { 
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'auth-token',
        'Access-Control-Allow-Origin': '*'
      })
    };
    return this.http.post<Userair>(this.newuserurl, userair, httpOptions);
}

Booking(flightId:number,userid:number,seat:any):Observable<any>
{
  const headers={'content-type':'application/json'};
  const body=JSON.stringify(seat);
  return this.http.post(this.addbookingurl+"/"+flightId+"/"+userid,body,{'headers':headers});
}
getbookingbyid(booking_id: number):Observable<Booking>  {
  const uidUrl = this.getbookingidurl + "/" + booking_id;
  return this.http.get<Booking>(uidUrl);
}
deleteBooking(id: number): Observable<any> {
  const headers = new HttpHeaders({ 'Authorization': 'auth-token' }); 
  const url = `${this.deletebookurl}/${id}`;
  return this.http.delete<Booking>(url, { headers });
}
getBookingByUserId(uid:number):Observable<Booking>{
  const uidUrl=this.getbookingbyuseridurl+"/"+uid;
  return this.http.get<Booking>(uidUrl);
}
getAllBookings():Observable<any>
{
  return this.http.get(this.getallbookurl);
}
}