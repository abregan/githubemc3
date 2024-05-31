import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Employeeair } from '../class/employeeair';

@Injectable({
  providedIn: 'root'
})
export class EmployeeairService {
  private viewallurl="http://localhost:8080/employeeair/viewAllEmployee";
  private empbynameurl="http://localhost:8080/employeeair/searchEmployee";
  private SaveEmployeeUrl = "http://localhost:8080/employeeair/addEmployee";
  private updateEmployeeurl="http://localhost:8080/employeeair/updateEmployee";
  private loginEmployeeurl="http://localhost:8080/employeeair/loginEmployee";
  private findbyidurl="http://localhost:8080/employeeair/findEmployee";

  constructor(private http:HttpClient) { }

  
  getAllEmployee():Observable<any>
  {
    return this.http.get(this.viewallurl);
  }
  getEmployeeByEmployeename(empname:any):Observable<Employeeair>
  {
    const searchURL=this.empbynameurl+"/"+empname;
    return  this.http.get<Employeeair>(searchURL);
  }
  SaveEmployee(employeeair: Employeeair): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'auth-token',
        'Access-Control-Allow-Origin': '*'
      })
    };
    return this.http.post<Employeeair>(this.SaveEmployeeUrl, employeeair, httpOptions);
  }
  updateEmployee(employeeair:Employeeair): Observable<any> {
    const headers={'content-type':'application/json'};
    const body=JSON.stringify(employeeair);
    return this.http.put(this.updateEmployeeurl,body,{'headers':headers});
  }

  getlogin(employeeair:Employeeair): Observable<any> {
    console.log(employeeair);
    return this.http.post<Employeeair>(`${this.loginEmployeeurl}`, employeeair);
  }

  getEmployeeById(empid:number):Observable<Employeeair>
  {
    const findidurl=this.findbyidurl+"/"+empid;
    return this.http.get<Employeeair>(findidurl);
  }
  
}
