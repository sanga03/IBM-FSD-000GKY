import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListComponent } from './list/list.component';
import { AddComponent } from './add/add.component';
import { ModufyComponent } from './modufy/modufy.component';
import { HomeComponent } from './home/home.component';
import { UseraRoutingModule } from './usera-routing.module';
import {FormsModule} from '@angular/forms'


@NgModule({
  declarations: [ListComponent, AddComponent, ModufyComponent, HomeComponent],
  imports: [
    CommonModule,
    UseraRoutingModule,
    FormsModule
  ]
})
export class UseraModule { }
