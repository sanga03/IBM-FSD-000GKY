import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListComponent } from './list/list.component';
import { HomrComponent } from './homr/homr.component';
import { ProductRoutingModule } from './product-routing.module';



@NgModule({
  declarations: [ListComponent, HomrComponent],
  imports: [
    CommonModule,
    ProductRoutingModule
  ]
})
export class ProductModule { }
