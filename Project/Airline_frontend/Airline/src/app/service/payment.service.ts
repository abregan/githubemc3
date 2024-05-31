import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Payment } from '../class/payment';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  private addpaymenturl = "http://localhost:8080/Payment/addPay";
  private viewallpayurl="http://localhost:8080/Payment/viewPay"; 
  private viewpaybypayidurl = "http://localhost:8080/Payment/findPay";
  private viewpaybyuseridurl = "http://localhost:8080/Payment/userAir";
 
  constructor(private http:HttpClient) { }

  addPayment(payment: any, booking_id: number, userid: number): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    //const url = `${this.addpaymenturl}/${booking_id}/${userid}`;
    const url=this.addpaymenturl+"/"+booking_id+"/"+userid;
    return this.http.post(url, payment, { headers });
  }

  getpaymentbyid(payment_id: number):Observable<Payment>  {
    const uidUrl = this.viewpaybypayidurl + "/" + payment_id;
    return this.http.get<Payment>(uidUrl);
  }

  getpaymentuserbyid(uid: number):Observable<Payment>  {
    const uidUrl = this.viewpaybyuseridurl + "/" + uid;
    return this.http.get<Payment>(uidUrl);
  }

  getAllPayments():Observable<any>
  {
    return this.http.get(this.viewallpayurl);
  }
  


  
  



}