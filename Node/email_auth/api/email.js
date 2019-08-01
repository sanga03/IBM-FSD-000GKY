router = require('express').Router()
email_class = require('../services/email_service').Email
gen_store = require('../services/generate_store').gen_store


router.get('/status',(rq,rs)=>{
    rs.status(200).json({
        message:'Hit success'
    })
})

router.post('/send',(rq,rs)=>{
    email = rq.body.email;
    name = rq.body.name;
    phone = rq.body.phone;

    gen_store(name,email,phone,(err,resp)=>{
        if(!err){
            rs.status(200).json({
                message:'inserted Success',
                res:resp
            })
        }else{
                if(err=="email not sent"){
                    rs.status(401).json({
                        message:'please check your email id'
                })
            }else{
                rs.status(401).json({
                message:'Not inserted'
            })
        }
        }
    })
    
})

module.exports={
    router
}