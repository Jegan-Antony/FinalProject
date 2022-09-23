import { BloodbankService } from './bloodbank.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { FetchbyidComponent } from './fetchbyid/fetchbyid.component';
import { FetchalldonorComponent } from './fetchalldonor/fetchalldonor.component';
import { UpdateComponent } from './update/update.component';
import { HomeComponent } from './home/home.component';



@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    FetchbyidComponent,
    FetchalldonorComponent,
    UpdateComponent,
    HomeComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,


  ],
  providers: [BloodbankService],
  bootstrap: [AppComponent]
})
export class AppModule { }
