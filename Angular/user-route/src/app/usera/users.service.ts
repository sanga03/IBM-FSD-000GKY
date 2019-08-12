import { Injectable } from '@angular/core';
import { user_structure } from './structure';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  items:user_structure[];
  constructor() {
    // let items:user_structure[];
   }

  addUser(items,data){
      this.items=items;
      this.items.push(data);
      return this.items;
  } 
  getUsers(){
    return this.items;
  }
}
