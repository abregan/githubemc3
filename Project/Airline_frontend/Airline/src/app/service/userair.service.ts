import { Injectable } from '@angular/core';
import { Userair } from '../class/userair';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserairService {
  private loginurl = "http://localhost:8080/userair/loginUser";
  private newuserurl = "http://localhost:8080/userair/registerUser";
  private updateUrl="http://localhost:8080/userair/updateUser";
  private viewallurl="http://localhost:8080/userair/viewAllUsers";
  private userbyidurl="http://localhost:8080/userair/findUser";
  private userbynameurl="http://localhost:8080/userair/search";
  
  constructor(private http:HttpClient) { }

  getAllUsers():Observable<any>
  {
    return this.http.get(this.viewallurl);
  }
  
  saveUser(userair: Userair): Observable<Userair> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'auth-token',
        'Access-Control-Allow-Origin': '*'
      })
    };
    return this.http.post<Userair>(this.newuserurl, userair, httpOptions);
  }
  updateUser(userair: Userair): Observable<Userair> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'auth-token',
        'Access-Control-Allow-Origin': '*'
      })
    };
    return this.http.put<Userair>(this.updateUrl + '/${userair}', userair, httpOptions);
  }

  getlogin(userair: Userair): Observable<Userair>{
    console.log(userair);
    return this.http.post<Userair>(`${this.loginurl}`,userair);
  }
getUserById(userid:number):Observable<Userair>
  {
    const useridurl=this.userbyidurl+"/"+userid;
    return this.http.get<Userair>(useridurl);
  }

  getUserByUsername(username:any):Observable<Userair>
  {
    const searchURL=this.userbynameurl+"/"+username;
    return  this.http.get<Userair>(searchURL);
  }
}
