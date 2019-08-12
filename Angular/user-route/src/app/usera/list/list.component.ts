import { Component, OnInit } from '@angular/core';
import { UsersService } from '../users.service';
import { Router, ActivatedRoute } from '@angular/router';
import {user_structure} from '../structure'

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  items:user_structure[]=new Array()
  constructor(private userService:UsersService,private router:ActivatedRoute) { 
    
    }

  ngOnInit() {
    console.log(this.router)
      this.items=this.userService.getUsers()
  }

}
