import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthResponseData } from 'src/auth.service';
import { Observable } from 'rxjs';


@Injectable({
    providedIn: 'root'
  })
  export class DataloginService {
  
    constructor(
      private http: HttpClient,
      ) { }

  login(data: any):Observable<AuthResponseData>{
    const options = { headers: new HttpHeaders({'Content-Type': 'application/json'}) };  
    return this.http.post<AuthResponseData>('//localhost:8080/api/login',data, options)
    
  }

  adduser(data: any){
      const options = { headers: new HttpHeaders({'Content-Type': 'application/json'}) };  
      return this.http.post('//localhost:8080/api/user',data, options)
  }



    }


