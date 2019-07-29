router = require('express').Router()
get_users = require('../services/tic_services').get_users

reset_users=require('../services/tic_services').reset_user
settic=require('../services/tic_services').settic
checkit=require('../services/tic_services').checkit
router.get('/status',(rq,rs)=>{
    rs.status(200).json({
        message:"hit double success"
    })
})

router.post('/update',(rq,res)=>{
    content  = rq.body;
    
})

router.get('/getstatus',(rq,res)=>{
    get_users((err,result)=>{
    res.status(200).json({
        message:'see users',
        "result":result
    })
    })  
})

router.get('/reset',(rq,rs)=>{
    reset_users((e,r)=>{
        rs.status(200).json({
            message:'reset success',
            "result":r
        })
    });
})

router.post('/settic',(rq,rs)=>{
    console.log('body',rq.body)
    id=rq.body.id
    player=rq.body.player
    
    settic(id,player,(e,r)=>{
        rs.status(200).json({
            message:'update success',
            "result":r
        })
    });
})

router.post('/checktic',(rq,res)=>{
    id=rq.body;
    checkit(id,(e,r)=>{
        res.status(200).json({
            played:r
            // "result":r
        })
    })
})



module.exports={
    router
}