router = require('express').Router()
email_class = require('../services/email_service').Email
gen_store = require('../services/generate_store').gen_store
check_otp=require('../services/generate_store').check_otp
update_db=require('../services/generate_store').update_db
router.get('/status',(rq,rs)=>{
    rs.status(200).json({
        message:'Hit success'
    })
})
router.post('/send',(rq,rs)=>{
    console.log(rq.body)
    email = rq.body.email;
    name = rq.body.name;
    phone = rq.body.phone;
    console.log(email)
    gen_store(name,email,phone,(err,resp)=>{
        if(!err){
            rs.status(200).json({
                message:'inserted Success'
            })
        }else{
                if(err=="email not sent"){
                    rs.status(401).json({
                        message:'email not sent'
                })
            }else{
                rs.status(401).json({
                message:'database error'
            })
        }
        }
    })
    
})

router.post('/check_otp',(rq,rs)=>{
    console.log(rq.body)
    email = rq.body.email;
    name = rq.body.name;
    otp = rq.body.otp;
    console.log('email',email)
    check_otp(name,email,otp,(res)=>{
        if(res==1){
            console.log(res)
            rs.status(200).json({
                status:1
            })
        }else{
            rs.status(200).json({
                status:0
            })
        }
    })

   
    
})

router.post('/pass',(rq,rs)=>{
    pass=rq.body.pass;
    name=rq.body.name;
    otp=rq.body.otp;
    update_db(name,otp,pass,(res)=>{
        if(res==1){
            rs.status(200).json({
                status:1
            })
        }else{
            rs.status(200).json({
                status:0
            })
        }
    })
})



module.exports={
    router
}