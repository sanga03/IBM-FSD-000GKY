import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  message:string;
  th;
  data;
  constructor() { }

  ngOnInit() {
    this.message='welcome to user';
    this.th={
      name:'NAME',
      no:'R NO'
    }
    this.data=[
      {
      name:'sangu',
      no:1212
       },{
        name:'sangu',
        no:1212
         },{
          name:'sangu',
          no:1212
           },{
            name:'sangu',
            no:1212
             }
  ]
  }

}
