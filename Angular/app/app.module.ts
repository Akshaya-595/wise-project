import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
//import { HomepageModule } from './homepage/homepage.module';
import { HomepageComponent } from './homepage/homepage.component';
//import { HarrypotterComponent } from './harrypotter/harrypotter.component';
//import { HungergamesComponent } from './hungergames/hungergames.component';
//import { PercyjacksonComponent } from './percyjackson/percyjackson.component';
//import { ShadowhuntersComponent } from './shadowhunters/shadowhunters.component';
import { AuthGuard } from './auth.guard';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';

const appRoot: Routes = [{path: '', component: LoginComponent},
                          {path: 'login', component: LoginComponent},
                          {path: 'signup', canActivate:[AuthGuard] , component: SignupComponent},
                          {path: 'show-emp', canActivate:[AuthGuard] , component: HomepageComponent},
                          //{path: 'products', canActivate:[AuthGuard] , component: HarrypotterComponent},
                          //{path: 'empbyid', canActivate:[AuthGuard] , component: HungergamesComponent},
                          //{path: 'empbyid', canActivate:[AuthGuard] , component: PercyjacksonComponent},
                          //{path: 'empbyid', canActivate:[AuthGuard] , component: ShadowhuntersComponent}
                        ];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    /*HarrypotterComponent,
    HungergamesComponent,
    PercyjacksonComponent,
    ShadowhuntersComponent,*/
    HeaderComponent,
    HomepageComponent
  ],
  imports: [
    CommonModule,
    BrowserModule, 
    //HomepageModule,
    RouterModule.forRoot(appRoot),
    HttpClientModule,
    FormsModule,
    AppRoutingModule, 
    NgbModule, 
    BrowserAnimationsModule
  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }