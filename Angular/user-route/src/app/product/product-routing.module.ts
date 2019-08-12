import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListComponent } from './list/list.component';
import { HomrComponent } from './homr/homr.component';


const routes: Routes = [{
  path:'product',
  children:[{
    path:'list',
    component:ListComponent
  },
  {
    path:'',
    component:HomrComponent
  }
]
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule { }
