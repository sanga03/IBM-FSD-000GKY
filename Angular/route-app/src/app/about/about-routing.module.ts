import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactComponent } from './contact/contact.component';
import { ReadComponent } from './read/read.component';
import { ServicesComponent } from './services/services.component';
import { AbsComponent } from './abs/abs.component';


const routes: Routes = [{
  path:'about',
  children:[{
    path:'contact',
    component:ContactComponent
  },{
    path:'read',
    component:ReadComponent
  },{
    path:'services',
    component:ServicesComponent
  },{
    path:'',
    component:AbsComponent
  }
]
}]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AboutRoutingModule { }
