import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminhomeComponent } from './Admin/adminhome/adminhome.component';
import { AdminloginComponent } from './Admin/adminlogin/adminlogin.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AdminregisterComponent } from './Admin/adminregister/adminregister.component';
import { IntropageComponent } from './intropage/intropage.component';
import { ManageflightComponent } from './Admin/manageflight/manageflight.component';
import { AddflightComponent } from './Admin/addflight/addflight.component';
import { ViewuserComponent } from './Admin/viewuser/viewuser.component';
import { ViewemployeeComponent } from './Admin/viewemployee/viewemployee.component';
import { LoginemployeeComponent } from './Employee/loginemployee/loginemployee.component';
import { RegisteremployeeComponent } from './Employee/registeremployee/registeremployee.component';
import { EmployeehomeComponent } from './Employee/employeehome/employeehome.component';
import { UserprofileComponent } from './User/userprofile/userprofile.component';
import { AdminprofileComponent } from './Admin/adminprofile/adminprofile.component';
import { EmployeeprofileComponent } from './Employee/employeeprofile/employeeprofile.component';
import { UserloginComponent } from './User/userlogin/userlogin.component';
import { UserregisterComponent } from './User/userregister/userregister.component';
import { WelcomeuserComponent } from './User/welcomeuser/welcomeuser.component';
import { AdduserComponent } from './User/adduser/adduser.component';
import { ViewflightComponent } from './User/viewflight/viewflight.component';
import { AddbookingComponent } from './User/addbooking/addbooking.component';
import { ViewuserpaymentComponent } from './User/viewuserpayment/viewuserpayment.component';
import { AddpaymentComponent } from './User/addpayment/addpayment.component';
import { PaymentoptionsComponent } from './User/paymentoptions/paymentoptions.component';
import { ViewuserbookingsComponent } from './User/viewuserbookings/viewuserbookings.component';
import { ViewallpaymentsComponent } from './Admin/viewallpayments/viewallpayments.component';
import { ViewallbookingsComponent } from './Admin/viewallbookings/viewallbookings.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminhomeComponent,
    AdminloginComponent,
    AdminregisterComponent,
    IntropageComponent,
    ManageflightComponent,
    AddflightComponent,
    ViewuserComponent,
    ViewemployeeComponent,
    LoginemployeeComponent,
    RegisteremployeeComponent,
    EmployeehomeComponent,
    UserprofileComponent,
    AdminprofileComponent,
   
    EmployeeprofileComponent,
    UserloginComponent,
    UserregisterComponent,
    WelcomeuserComponent,
    AdduserComponent,
    ViewflightComponent,
    AddbookingComponent,
    ViewuserpaymentComponent,
    AddpaymentComponent,
    PaymentoptionsComponent,
    ViewuserbookingsComponent,
    ViewallpaymentsComponent,
    ViewallbookingsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
