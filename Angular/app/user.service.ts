import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private isUserLogged: any;
  user: any;
  result: any;
  constructor(private httpClient: HttpClient) {
    this.isUserLogged = false;
  }
  setUserLoggedIn(): void{
    this.isUserLogged = true;
  }

  setUserLoggedOut(): void{
    this.isUserLogged = false;
  }


  getUserLogged(): any{
    return this.isUserLogged;
  }
  
  getUserById(userName :any ){
   // this.result = userName + ' ' + password;
   // console.log(this.result);
   // console.log("akshayaaaaa");
    return this.httpClient.get('RESTAPI/webapi/myresource/getUserById/' + userName );
  }
  setUserName(userName :any){
    console.log(userName);
    return this.httpClient.get('RESTAPI/webapi/myresource/setUserName/' + userName );

  }
  getEmpById(empId: any): any{
    return this.httpClient.get('RESTAPI/webapi/myresource/getEmployeeById/' + empId);
  }
  getAllDepartments(): any{
    return this.httpClient.get('RESTAPI/webapi/myresource/getAllDepartments');
  }

  registerUser(employee: any){
    console.log("akshayyyy")
    return this.httpClient.post('RESTAPI/webapi/myresource/registerUser' , employee);
  }

  deleteEmp(employee: any){
    return this.httpClient.delete('RESTAPI/webapi/myresource/deleteEmp/' + employee.empId);
  }

  updateEmp(employee: any){
    return this.httpClient.put('RESTAPI/webapi/myresource/updateEmp' , employee);
  }
}
