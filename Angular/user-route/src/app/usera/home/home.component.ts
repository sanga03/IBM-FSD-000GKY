import { Component, OnInit } from '@angular/core';
import { UsersService } from '../users.service';
import { user_structure } from '../structure';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  _item_objs:user_structure[] = new Array()
  _item_obj
  constructor(private uService:UsersService) {
    let _item_objs:user_structure[];
   }
  ngOnInit() {
    let l_item_obj:user_structure
    l_item_obj ={
      name:"sangu",
      phone:'2324',
      email:'asddsa'
    }
    // this._item_objs.push(l_item_obj);
    console.log(this._item_objs)
    this._item_obj=this._item_objs
    console.log(JSON.stringify(this._item_objs))
  }
    

}
