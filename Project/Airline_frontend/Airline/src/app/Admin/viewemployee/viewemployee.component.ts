import { Component } from '@angular/core';
import { EmployeeairService } from '../../service/employeeair.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-viewemployee',
  templateUrl: './viewemployee.component.html',
  styleUrls: ['./viewemployee.component.css']
})
export class ViewemployeeComponent {
  employeeair:any
  hasSearchName: boolean;
  searchName: string;
  constructor(private employeeairservice:EmployeeairService,private router:Router,private activateRoute:ActivatedRoute){}
  ngOnInit(): void {
    this.activateRoute.paramMap.subscribe(()=>this.getAllEmployee());
  
  }
  getAllEmployee():void{
    this.hasSearchName=this.activateRoute.snapshot.paramMap.has("empname");
    if(this.hasSearchName)
    {
      this.searchName=this.activateRoute.snapshot.paramMap.get("empname");
      console.log(this.searchName)
      this.employeeairservice.getEmployeeByEmployeename(this.searchName).subscribe(data=>{
        console.log(data);
        this.employeeair=data;
      })
    }
    else{
      this.employeeairservice.getAllEmployee().subscribe(data=>{
        console.log(data);
        this.employeeair=data;
      })
  }

  }
  homepage():void{
    this.router.navigateByUrl("/adminhome");
  }
  
}
