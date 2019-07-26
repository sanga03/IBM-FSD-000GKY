router = require('express').Router()

router.get('/status',(rq,resp)=>{
    resp.status(200).json({
        message:"login success"
    })
})


module.exports={
    l_router :router
}