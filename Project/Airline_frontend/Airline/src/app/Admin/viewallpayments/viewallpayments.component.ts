import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../../service/payment.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-viewallpayments',
  templateUrl: './viewallpayments.component.html',
  styleUrl: './viewallpayments.component.css'
})
export class ViewallpaymentsComponent implements OnInit{
  payment:any
  hasSearchId: boolean;
  searchId: number;
  constructor(private payementservice:PaymentService,private router:Router,private activateRoute:ActivatedRoute){}
  ngOnInit(): void {
    this.activateRoute.paramMap.subscribe(()=>this.getAllPayments());
  
  }
  getAllPayments():void{
    this.hasSearchId = this.activateRoute.snapshot.paramMap.has("booking_id");
         if(this.hasSearchId)
         {this.searchId  = Number(this.activateRoute.snapshot.paramMap.get("booking_id"));
          console.log(this.searchId)
          this.payementservice.getpaymentbyid(this.searchId).subscribe(data=>{
          console.log(data);
          this.payment= data;
          })
        }
        else{
        this.payementservice.getAllPayments().subscribe(data=>{
          console.log(data);
          this.payment=data;
        });
      }
  }
  homepage():void{
    this.router.navigateByUrl("/adminhome");
  }
}
