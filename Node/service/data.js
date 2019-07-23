const datas=[
    {
        id:1,
        name:'sangu',
        email:'sangu4403@gmail.com',
        pass:'1234',
        uname:'sanga'

    },
    {
        id: 2,
        name : 'BOB',
        email : 'bob@gg.com',
        uname : 'bob',
        pass : '123'
    },
    {
        id: 3,
        name : 'ADAM',
        email : 'adam@gg.com',
        uname : 'adam',
        pass : 'adam'
    },
    {
        id: 4,
        name : 'ADMIN',
        email : 'admin@gg.com',
        uname : 'admin',
        pass : 'admin'
    }
]

class Userfind{
    returnUser(unam,pass){
      return  datas.find((u)=>{
            return u.name == unam && u.pass == pass;
        })
    }
}

module.exports={
    Userfind
}