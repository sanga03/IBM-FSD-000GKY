router = require('express').Router()

router.get('/status',(rq,resp)=>{
    resp.status(200).json({
        message:"login success"
    }) 
})

router.get("/getToken",(rq,resp)=>{
    user = rq.headers.user;
    
})


module.exports={
    l_router : router
}