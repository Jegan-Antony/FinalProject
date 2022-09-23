import { HomeComponent } from './home/home.component';
import { UpdateComponent } from './update/update.component';
import { FetchalldonorComponent } from './fetchalldonor/fetchalldonor.component';
import { FetchbyidComponent } from './fetchbyid/fetchbyid.component';
import { RegisterComponent } from './register/register.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'fetchbyid', component: FetchbyidComponent},
  {path: 'fetchalldonor',component: FetchalldonorComponent},
  {path: 'update/:donorId', component: UpdateComponent},
  {path: 'home', component: HomeComponent},
  {path: 'aboutus', loadChildren:()=> import('./aboutus/aboutus.module').then(about=> about.AboutusModule)}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
