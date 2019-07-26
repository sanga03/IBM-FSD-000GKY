varify_user=require('./user_validator').varify_user
const tokens_serv = require('./token_services')
generateToken=tokens_serv.generateToken
validateToken = tokens_serv.validateToken
var fs = require('fs')
validator=(rq,resp,next)=>{
    token_return = "notNeeded"
    const user = rq.headers.user;
    const pass = rq.headers.pass;
    const token=rq.headers.token;

    console.log("got token is",token);
    if(varify_user(user,pass)){
        console.log('found user')
        // generateToken(user);
        if(token=="not"){

            console.log('same')
            tokeN = generateToken(user)
            console.log("token generated",tokeN);
            token_return=tokeN;
            
        }
        else{
            console.log('not same')
            if(validateToken(token)){
                console.log("good to go")
            }
        }
        
        next();
    }else{
        resp.redirect('/unauthorize');
    }
    console.log(user)
    // next();
    rq.headers['atoken']="updated Toke"
    fs.writeFile("token.json",JSON.stringify({
        user:user,
        token:token_return
    }),err=>{
        if(err){
            console.log(err);
            return;
        }
    })
   return token_return;
}
module.exports={
    validator:validato
    r}