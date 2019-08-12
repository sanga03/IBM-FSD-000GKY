import { TestBed } from '@angular/core/testing';

import { UsersService } from './users.service';

describe('UsersService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UsersService = TestBed.get(UsersService);
    expect(service).toBeTruthy();
  });
  it('should get user properly',()=>{

    const service: UsersService = TestBed.get(UsersService);
    // const uservice : UsersService=TestBed.
   let  resp =service.addUser([],{ 
     name:"san",
     phone:"asd",
     email:"sdad"
   })
   console.log(resp)
   let respl=resp.length
   console.log(respl)
    expect(respl).toBe(1);
  })
});