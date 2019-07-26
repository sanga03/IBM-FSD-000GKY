jwt = require('jsonwebtoken')

generateToken=(user,pass)=>{
   const token=jwt.sign(user,"key@123");
   console.log(token);
   return token;
}

validateToken=(token)=>{
    isvalid = false;
    try{
        isvalid =jwt.verify(token,"key@123");
    }catch(error){
        console.error(error);    
    }
    return isvalid;
}

module.exports={
    generateToken:generateToken,
    validateToken:validateToken
}