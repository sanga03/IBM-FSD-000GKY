import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TtComponent } from './tt/tt.component';


const routes: Routes = [{
  path:'tt',
  component:TtComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
