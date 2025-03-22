import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './account/login/login.component';
import { RegisterComponent } from './account/register/register.component';
import { MainlayoutComponent } from './layouts/mainlayout/mainlayout.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  {path: 'dashboard',
  component: MainlayoutComponent, // Layout with sidebar & topbar
  children: [
    { path: 'register', component: RegisterComponent },
    // add more child routes as needed
  ]},

  // import login component
  
  // import register component
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
