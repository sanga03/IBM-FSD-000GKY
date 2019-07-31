router = require('express').Router()
verifyToken =require('../services/user.admin.services').verifyToken
product_serv = require('../services/product.service').ProductService
product_service = new product_serv()

router.post('/add',(rq,res)=>{
    product = rq.body.product;
    token=rq.body.token;
    valid= verifyToken(token);
    type = valid.type;
    // console.log(type)
    if(valid){
        type = valid.type;
        if(valid.type=="admin"){
       product_service.add_product(product,(err,result)=>{
        if(!err){
            res.status(200).json({
                message:'product added succesfully'
            })
        }else{
        res.status(200).json({
            message:'product not added please try again'
        })
    } 
    });
}else{
        console.log(type)
        res.status(200).json({
            message:'only admin are allowed to add products'
        })
        }
    }else{
        res.status(200).json({
            message:'please sign in again'
        })
    }

})

router.get('/get_product',(rq,res)=>{
    token=rq.headers.token;
    // console.log(token)
    isvalid = verifyToken(token)
    if(isvalid){
    product_service.fetchProducts((err,resp)=>{
      res.status(200).json({
          product_list:resp
      })
  })}
  else{
    res.status(401).json({
        message:"token expired or invalid"
    })
  }
})


router.get('/status',(rq,res)=>{
    res.status(200).json({
        message:"Hit Success"
    })
})


module.exports={
    router
}



