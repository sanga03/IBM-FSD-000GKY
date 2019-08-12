import { Component, OnInit ,Input} from '@angular/core';
import { user_structure } from '../structure';
import { UsersService } from '../users.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  constructor(private uService:UsersService,private router:Router) { }
  // @Input() items:user_structure[]
  items:user_structure[] = new Array();
  ngOnInit() {
    console.log(this.router)
    // let itm:user_structure= this.router.currentUrlTree.queryParams.item_obj;
    // console.log(itm.name);
  }
  login(vals){

    let item:user_structure;
    alert(vals)
    console.log(vals)
    item={
      name:vals.name,
      phone:vals.phone,
      email:vals.email
    }
   this.items= this.uService.addUser(this.items,item);
   
  }

}
