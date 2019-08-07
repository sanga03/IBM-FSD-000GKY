import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'first';
  strobj:string="Na na";
  fromUserString:any="asd";
  getFromuser($event){
    this.fromUserString=$event;
  }

}
