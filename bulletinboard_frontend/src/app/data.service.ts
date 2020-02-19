import { Injectable } from '@angular/core';
import { HttpClient ,HttpHeaders, HttpResponse, HttpParams} from '@angular/common/http'; 
import { catchError , tap, take, exhaust, exhaustMap } from 'rxjs/operators';
import { Observable, Subject } from 'rxjs';
import { AuthService } from 'src/auth.service';


@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(
    private http: HttpClient,
    private authService: AuthService
    ) { }

  getTestServer(){
    return this.http.get('//localhost:8080/testserverconnection')
  }


  // getAllposts():Observable<any>{
  //   return this.http.get('//localhost:8080/allposts')
  // }

  // getAllposts(){
  //   return this.http.get('//localhost:8080/api/post');
  // }

  getAllposts(){
    return  this.authService.user.pipe(take(1),exhaustMap( user =>{

      if(!user){
        console.log("user.token null option");
        return this.http.get('//localhost:8080/api/post');
      }
      else{
        console.log("user.token is");
        console.log(user.token);


      // return this.http.get('//localhost:8080/api/post/'+user.token);

      return this.http.get('//localhost:8080/api/post/',
          {
            params: new HttpParams().set('auth',user.token)
          }
        );

      }
    }

    ))
    
  }




  // getAllposts(){
  //   return this.http.get('//localhost:8080/login')
  // }


  getAvatarlist(){
    return this.http.get('//localhost:8080/api/avatar')
  }


  submitMessage(data: any){
    const options = { headers: new HttpHeaders({'Content-Type': 'application/json'}) };  
    return this.http.post('//localhost:8080/api/post',data, options)
  }



  deleteonepost(i:any){
    console.log("in service "+ i);
    return this.http.delete('//localhost:8080/api/post/'+i)
  }


  dummyPOST1(){
    const options = { headers: new HttpHeaders({'Content-Type': 'application/json'}) };  
    
    let  dummypost1 = {"user_ID":2,"username":"TestMan","title":"TestTitle",
                      "content":"This is test message"}


    return this.http.post('//localhost:8080/api/post',dummypost1, options)
  }

  
  getAllusers(){
    // return this.http.get('//localhost:8080/api/user');


    return  this.authService.user.pipe(take(1),exhaustMap( user =>{

      if(!user){
        console.log("user.token null option");
        return this.http.get('//localhost:8080/api/user/0');
        // really need to do this?
      }
      else{
      // return this.http.get('//localhost:8080/api/user');
      return this.http.get('//localhost:8080/api/user/'+user.token);


      // return this.http.get('//localhost:8080/api/user/',
      //     {
      //       params: new HttpParams().set('auth',user.token)
      //     }
      //   );

      }
    }

    ))
    
  }


  deleteoneuser(i:any){
    // console.log("in delete user service "+ i);
    return this.http.delete('//localhost:8080/api/user/'+i)
  }



  // getAll(): Observable<any> {
  //   return this.http.get('//localhost:8080/allposts');
  // }


}
