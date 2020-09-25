import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService} from '../user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user: any;
  employee: any;
  constructor(private router: Router, private userService: UserService) { 
    this.employee = {userName:'' , mobileNo:'' , password: ''};
  }

  ngOnInit(): void {

  }

  RegisterUser(): void {
    console.log('RegisterUser is called..')
    console.log(this.user);
    this.router.navigate(['homepage']);
  }
  register(registerForm: any){

    this.userService.registerUser(this.employee).subscribe((result: any) => console.log(result));
    this.router.navigate(['homepage']);
    console.log(registerForm);

  }

}