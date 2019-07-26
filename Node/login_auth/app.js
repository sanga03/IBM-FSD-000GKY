express = require('express')
parser = require('body-parser')
validator=require('./services/token_service').validator
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
    validator(rq,res,next);
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