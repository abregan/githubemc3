import { Component } from '@angular/core';
import { Userair } from '../../class/userair';
import { ActivatedRoute, Router } from '@angular/router';
import { UserairService } from '../../service/userair.service';

@Component({
  selector: 'app-viewuser',
  templateUrl: './viewuser.component.html',
  styleUrls: ['./viewuser.component.css']
})
export class ViewuserComponent {
  userair:any;
  hasSearchName: boolean;
  searchName: string;

   constructor(private userairservice:UserairService,private router:Router,private activateRoute:ActivatedRoute){}
  ngOnInit(): void {
    this.activateRoute.paramMap.subscribe(()=>this.getAllUsers());
  
  }
  getAllUsers():void{
    this.hasSearchName=this.activateRoute.snapshot.paramMap.has("username");
    if(this.hasSearchName)
    {
      this.searchName=this.activateRoute.snapshot.paramMap.get("username");
      console.log(this.searchName)
      this.userairservice.getUserByUsername(this.searchName).subscribe(data=>{
        console.log(data);
        this.userair=data;
      })
    }
    else{
      this.userairservice.getAllUsers().subscribe(data=>{
        console.log(data);
        this.userair=data;
      })
    }
  }
  homepage():void{
    this.router.navigateByUrl("/adminhome");
  }
  }
    
    
    
    
