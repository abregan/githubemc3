import { Injectable } from '@angular/core';
import { Admin } from '../class/admin';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
 
  private newadminurl="http://localhost:8080/admin/registerAdmin";
  private loginurl="http://localhost:8080/admin/loginAdmin";
  private updateUrl="http://localhost:8080/admin/updateAdmin";
  private adminbyidurl="http://localhost:8080/admin/findAdmin";
  private adminbynameurl="http://localhost:8080/userair/search";

  constructor(private http:HttpClient) { }

  saveAdmin(admin: Admin): Observable<Admin> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'auth-token',
        'Access-Control-Allow-Origin': '*'
      })
    };
    return this.http.post<Admin>(this.newadminurl, admin, httpOptions);
  }
  updateAdmin(admin: Admin): Observable<Admin> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'auth-token',
        'Access-Control-Allow-Origin': '*'
      })
    };
    return this.http.put<Admin>(this.updateUrl + `/${admin}`, admin, httpOptions);
 
  }

  getlogin(admin: Admin): Observable<Admin>{
    console.log(admin);
    return this.http.post<Admin>(`${this.loginurl}`,admin);
  }

  getAdminById(adminid:number):Observable<Admin>
  {
    const adminidurl=this.adminbyidurl+"/"+adminid;
    return this.http.get<Admin>(adminidurl);
  }

  getAdminByAdminName(adminName:any):Observable<Admin>
  {
    const searchURL=this.adminbynameurl+"/"+adminName;
    return  this.http.get<Admin>(searchURL);
  }
}
