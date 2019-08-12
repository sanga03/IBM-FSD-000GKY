import { Injectable } from '@angular/core';
import { userInterface,active } from './user/db/user_data';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor() { }
  users:userInterface[]=[
    {
    name:'sangu',
    id:234,

    age:23,
    status:false
  },
  {
    name:'maru',
    id:12,
    age:22,
    status:true
  },
  {
    name:'prashant',
    id:89,
    age:22,
    status:true
  },
  {
    name:'hari',
    id:12,
    age:18,
    status:true
  },

]
  getUsers(){
    return this.users;
  }
  deleteUser(id){
    for(let i=0;i<this.users.length;i++){
      if(this.users[i].id==id){
        this.swap(i);
        this.users.pop()
        break;     
      }
    }
  }
  swap(i){
    let temp:userInterface;
    temp = this.users[i];
    this.users[i]=this.users[this.users.length-1]
    this.users[this.users.length-1]=temp;
  } 
  addUser(){
    this.users.push({
      name:'maru',
      id:12,
      age:22,
      status:true
    })

  }
  get_active(){
   let t:active;
   let act_count:number=0;
   this.users.forEach((u)=>{
     if(u.status==true){
       act_count+=1;
     }
   })
   t={
     total:this.users.length,
     active:act_count,
     inactive:this.users.length-act_count
   }
   return t;
  }
}
