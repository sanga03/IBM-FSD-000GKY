import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContactComponent } from './contact/contact.component';
import { ReadComponent } from './read/read.component';
import { ServicesComponent } from './services/services.component';
import { AbsComponent } from './abs/abs.component';
import { AboutRoutingModule } from './about-routing.module';



@NgModule({
  declarations: [ContactComponent, ReadComponent, ServicesComponent, AbsComponent],
  imports: [
    CommonModule,
    AboutRoutingModule    
  ]
})
export class AboutModule { }
