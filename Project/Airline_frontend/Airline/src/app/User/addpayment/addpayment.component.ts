import { Component, OnInit } from '@angular/core';
import { Booking } from '../../class/booking';
import { PaymentService } from '../../service/payment.service';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingService } from '../../service/booking.service';
import { Userair } from '../../class/userair';
import { UserairService } from '../../service/userair.service';

@Component({
  selector: 'app-addpayment',
  templateUrl: './addpayment.component.html',
  styleUrls: ['./addpayment.component.css']
})
export class AddpaymentComponent implements OnInit{
  userair:Userair
  booking: Booking;
  generatedBookingId: number;
  user: number;
  payment: any = {
    nameOnCard: '',
    cardNumber: '',
    expYear: '',
    cvv: '',
    paidAmount: 0
  };
  constructor(private activeRoute: ActivatedRoute,private router: Router,private userairservice: UserairService,private bookingservice:BookingService,private paymentservice:PaymentService) {}

  ngOnInit(): void {
    this.generatedBookingId = Number(localStorage.getItem("generatedBookingId"));
    this.getBookingById();
    this.activeRoute.paramMap.subscribe(()=>this.userair=JSON.parse(sessionStorage.getItem("userair")));
    this.user=this.userair.userid
    this.checkSessionAndNavigate();
  }

  onSubmit() {
    this.paymentservice.addPayment(this.payment, this.generatedBookingId ,this.user).subscribe(
      () => {
      console.log(this.payment);
      console.log('payment added successfully');
      alert("payment added successfully")
      localStorage.clear()
      this.router.navigateByUrl("/user/mypayments")
    },
    (error)=>{
    console.error("Error adding payment",error);
    }
       );
  }
  getBookingById() {
    this.bookingservice.getbookingbyid(this.generatedBookingId).subscribe(
      (data) => { 
        console.log(data);
        this.booking = data;
        this.payment.paidAmount = this.booking.amount; 
      },
      (error) => {
        console.error('Error fetching order', error);
        
      }
    );
  }
  deleteBooking(){
    if(this.generatedBookingId){
      const confirmation=window.confirm("Are you sure you want to delete this order?");
      if(confirmation){
        this.bookingservice.deleteBooking(this.generatedBookingId).subscribe(
          () => {
            alert("Order deleted successfully");
            this.router.navigateByUrl('/deletebooking');
          },
          (error) => {
            console.error("Error deleting order", error);
            alert("Error deleting order");
          }
        );
      }
    }else{
      alert("Booking Not Available");
    }
  }
  checkSessionAndNavigate() {
    if (!this.userair) {
      this.router.navigateByUrl("/userair/login");
    }
  }
  homepage():void{
    this.router.navigateByUrl("/welcomeuser");
  }
  
}
     

     
    

