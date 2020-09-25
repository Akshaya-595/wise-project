import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService} from '../user.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
   user: any;
   username: any;
   pass: any;

  constructor(private router: Router, private userService: UserService) { 
   // this.user = {userName:' ', password:''};
    this.username = {userName:' '};
    this.pass = {password:' '};

  }

  ngOnInit(): void {
  }

  LoginUser(): void {
    console.log("LoginUser is called..")
 //   console.log(this.user);
  }
  validateUser(loginForm: any){
      if(loginForm.userName === 'userName' && loginForm.password === 'password'){
        //Navigate to Products Page
        this.userService.setUserLoggedIn();
      //  this.userService.getUserById(this.user);
        this.router.navigate(['homepage']);
      }else{
        alert('Invalid Credentials');
      }
   // console.log(loginForm);
  }
  login(loginForm: any){
    this.userService.setUserName(loginForm.userName).subscribe((result: any) => {
    });
    
    this.userService.getUserById(loginForm.userName).subscribe((result: any) => {
      console.log(result);
     // console.log("akshaya");
      this.user = result;
      if(this.user){
        if(this.user.password===loginForm.password){
          alert("login succcess");//redirection path
          this.router.navigate(['/homepage'])
        }
        else{
          alert("invalid credeindials");
        }
      }
      else{
        alert("not registered");
        
      }
    
    });
   // console.log(loginForm);
  }
}