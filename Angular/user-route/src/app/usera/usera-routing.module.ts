import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddComponent } from './add/add.component';
import { ModufyComponent } from './modufy/modufy.component';
import { ListComponent } from './list/list.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [{
  path:'user',
  children:[{
    path:'add',
    component:AddComponent
  },
{
  path:'modify',
  component:ModufyComponent
},{
  path:'list',
  component:ListComponent
},{
  path:'',
  component:HomeComponent
}
]
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class UseraRoutingModule { }
