const jwt = require('jsonwebtoken');
// const jwtDecode = require('jwt-decode');
const UserConstants = require('../services/util.service').UserConstants;

function verifyToken(_token){
    // console.log(_token)
    let validToken = false;
    let decoded="Nothing";
    try{
        const isValid = jwt.verify(_token,UserConstants.jwt.key); 
        // console.log(isValid)
        if(isValid){
            validToken = isValid;
            // decoded = jwt_decode(token);
            // console.log(decoded);

        }
    }catch(error){

    }
    return validToken ;
}





module.exports={
    verifyToken
}