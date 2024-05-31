import { Component, OnInit } from '@angular/core';
import { Admin } from '../../class/admin';
import { PaymentService } from '../../service/payment.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Userair } from '../../class/userair';
import { Payment } from '../../class/payment';
import { Flight } from '../../class/flight';

@Component({
  selector: 'app-viewuserpayment',
  templateUrl: './viewuserpayment.component.html',
  styleUrl: './viewuserpayment.component.css'
})
export class ViewuserpaymentComponent implements OnInit{
  payment: any
  userair: Userair
  isEditable: boolean;
  flight:Flight;
  constructor( private paymentservice:PaymentService,private router: Router, private activateRoute: ActivatedRoute) { }
  ngOnInit(): void {
    this.activateRoute.paramMap.subscribe(() => this.userair = JSON.parse(sessionStorage.getItem("userair")))
    this.activateRoute.paramMap.subscribe(() => this.getpaymentuserbyid())
    
  }
  getpaymentuserbyid() {
    const pay_id = this.userair.userid;

    console.log(pay_id);
    if (pay_id > 0) {
      this.isEditable = true;
      this.paymentservice.getpaymentuserbyid(pay_id).subscribe(data => {
        this.payment = data;
        console.log(this.payment)
      });
    }

  }
  logout() {
    if (sessionStorage.getItem("userair")) {
      sessionStorage.clear()
      localStorage.clear()
      alert("Logout Successfully")
      this.router.navigateByUrl("/userlogin")
    }
    else {
      alert("No user loged in")
    }
  }

  
homepage():void{
  this.router.navigateByUrl("/welcomeuser");
}

}
