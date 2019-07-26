express = require('express')
parser = require('body-parser')
validator=require('./services/validate_service').validator
login_service = require('./api/login_api').l_router

server = express()
server.use(parser.json())


server.get('/status',(rq,resp)=>{
    resp.end(JSON.stringify({
        message:"Hit success"
    }))
})

server.get('/unauthorize',(rq,rs)=>{
    rs.status(401).json({
        message : 'Unauthorized Access'
    });
});


server.use('/logins',(rq,res,next)=>{
   returned_token= validator(rq,res,next);
   console.log(returned_token);
   
//    res.status(200).json({
//        token: "returned_token"
//    })
})

server.use('/logins',login_service)


server.post('/login',(rq,res)=>{
       body= rq.body;
       console.log(body)
       res.end(JSON.stringify({
           message:'success'
       }))
})

server.listen(8899,()=>{
    console.log("server started")
})