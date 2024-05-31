import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminhomeComponent } from './Admin/adminhome/adminhome.component';
import { AdminloginComponent } from './Admin/adminlogin/adminlogin.component';
import { AdminregisterComponent } from './Admin/adminregister/adminregister.component';
import { IntropageComponent } from './intropage/intropage.component';
import { ManageflightComponent } from './Admin/manageflight/manageflight.component';
import { AddflightComponent } from './Admin/addflight/addflight.component';
import { ViewuserComponent } from './Admin/viewuser/viewuser.component';
import { ViewemployeeComponent } from './Admin/viewemployee/viewemployee.component';
import { RegisteremployeeComponent } from './Employee/registeremployee/registeremployee.component';
import { LoginemployeeComponent } from './Employee/loginemployee/loginemployee.component';
import { EmployeehomeComponent } from './Employee/employeehome/employeehome.component';
import { AdminprofileComponent } from './Admin/adminprofile/adminprofile.component';

import { EmployeeprofileComponent } from './Employee/employeeprofile/employeeprofile.component';
import { UserloginComponent } from './User/userlogin/userlogin.component';
import { UserregisterComponent } from './User/userregister/userregister.component';
import { WelcomeuserComponent } from './User/welcomeuser/welcomeuser.component';
import { AdduserComponent } from './User/adduser/adduser.component';
import { ViewflightComponent } from './User/viewflight/viewflight.component';
import { AddbookingComponent } from './User/addbooking/addbooking.component';
import { UserprofileComponent } from './User/userprofile/userprofile.component';
import { ViewuserpaymentComponent } from './User/viewuserpayment/viewuserpayment.component';
import { AddpaymentComponent } from './User/addpayment/addpayment.component';
import { ViewuserbookingsComponent } from './User/viewuserbookings/viewuserbookings.component';
import { PaymentoptionsComponent } from './User/paymentoptions/paymentoptions.component';
import { combineLatest } from 'rxjs';
import { ViewallpaymentsComponent } from './Admin/viewallpayments/viewallpayments.component';
import { ViewallbookingsComponent } from './Admin/viewallbookings/viewallbookings.component';

const routes: Routes = [{ path: 'adminhome', component: AdminhomeComponent },
{path:'adminlogin',component:AdminloginComponent},
{path:'adminregister',component:AdminregisterComponent},
{path:'',component:IntropageComponent},
{path:'flightlist',component:ManageflightComponent},
{path:'addflight',component:AddflightComponent},
{path:'updateFlight/:flightId',component:AddflightComponent},
{path:'userlist',component:ViewuserComponent},
{path:'emplist',component:ViewemployeeComponent},
{path:'employeeregister',component:RegisteremployeeComponent},
{path:'employeelogin',component:LoginemployeeComponent},
{path:'employeehome',component:EmployeehomeComponent},
{path:'adminprofile',component:AdminprofileComponent},
{path:'employeeprofile',component:EmployeeprofileComponent},
{path:'userlogin',component:UserloginComponent},
{path:'userregister',component:UserregisterComponent},
{path:'welcomeuser',component:WelcomeuserComponent},
{path:'adduser',component:AdduserComponent},
{path:'updateuser/:userid',component:AdduserComponent},
{path:'viewflight',component:ViewflightComponent},
{path:'userair/addbooking/:id',component:AddbookingComponent},
{path:'bookflight',component:AddbookingComponent},
{path:'userprofile',component:UserprofileComponent},
{path:'updateemployee/:empid',component:RegisteremployeeComponent},
{path:"viewpayments",component:ViewuserpaymentComponent}
,{path:"userair/addpayment",component:AddpaymentComponent},
{path:'viewuserbookings',component:ViewuserbookingsComponent},
{path:'userair/paymentoptions',component:PaymentoptionsComponent},
{path:'user/mypayments',component:ViewuserpaymentComponent},
{path:'viewallpayments',component:ViewallpaymentsComponent},
{path:'viewallbookings',component:ViewallbookingsComponent},
{path:'updateAdmin/:adminid',component:AdminregisterComponent}]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
