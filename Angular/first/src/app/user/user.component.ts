import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { userInterface, active } from './db/user_data';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  message:string;
  th;
  data:userInterface[];
  active_s:active;
  // getData:string;
  constructor(private userService:UserService) { }
  @Input() getData:string;
  @Output()fromUser = new EventEmitter()
  ngOnInit() {
    this.active_s=this.userService.get_active();
   this.data=this.userService.getUsers();    /*
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
  */
  }
  onclickz(){
    this.fromUser.emit("ha ha from user ")
  }
  addUser(){
    this.userService.addUser();
    this.data=this.userService.getUsers();
    this.active_s=this.userService.get_active();
  }

  delUser(id:number){
    this.userService.deleteUser(id);
    this.active_s=this.userService.get_active();
  }
}
