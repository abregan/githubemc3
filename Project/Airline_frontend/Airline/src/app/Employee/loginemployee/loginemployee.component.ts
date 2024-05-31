import { Component } from '@angular/core';
import { Employeeair } from '../../class/employeeair';
import { EmployeeairService } from '../../service/employeeair.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-loginemployee',
  templateUrl: './loginemployee.component.html',
  styleUrls: ['./loginemployee.component.css']
})
export class LoginemployeeComponent {
  employeeair: Employeeair = new Employeeair(0,"", "","","","","","")
  employeeairs: Employeeair = JSON.parse(sessionStorage.getItem("employeeair"))

  constructor(private employeeairservice:EmployeeairService,private router:Router){}
  ngOnInit(): void {
  }
  Getlogin(): void {
    this.employeeairservice.getlogin(this.employeeair).subscribe(data=> {
      alert("Login Successfully"),
        console.log("login response" + data)

      sessionStorage.setItem("employeeair", JSON.stringify(data))

      this.router.navigateByUrl("/employeehome")

    },
    error => alert("Sorry Please Enter correct Username And Password"));

  }
  newregistration(){
    this.router.navigateByUrl("/employeeregister")
  }
  /*
  onSubmit() {
    this.router.navigateByUrl("/viewAllEmployee");

  }
*/

}
