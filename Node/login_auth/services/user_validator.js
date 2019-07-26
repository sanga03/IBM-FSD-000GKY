userdb= require('../db/users').users;

varify_user=(user,pass)=>{
    console.log(user,pass)
    isvalid = false;
    // console.log(userdb)
userdb.forEach(element => {
    if(element.user==user && element.pass == pass){
        console.log('user found')
        isvalid= true;
    }
});

return isvalid;
}

module.exports={
    varify_user:varify_user
}