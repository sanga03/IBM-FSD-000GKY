const server = require('express').Router();
const cart = require('../services/cart_service').cart

server.get('/status',(rq,resp)=>{
    resp.status(200).json({
        message:'Hit to product success'
    })
})

server.get('/getcart',(rq,resp)=>{
    data = cart._displaycart()
    resp.status(200).json({
        datas:data
    })
})
server.get('/updatecart/:id/:sign',(req,resp)=>{
    id = parseInt(req.params.id);
    sign = req.params.sign;
    console.log(id,sign)
    cart._updatecart(id,sign)
    resp.status(200).json({
        msg:"success"
    })
})

server.get('/sendmail/:to',(req,resp)=>{
        email = req.params.to;
        cart._sendMail(email);
        resp.status(200).json({
            msg:'success'
        })
})

module.exports={
    cartRouter:server
}