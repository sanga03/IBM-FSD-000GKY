const server = require('express').Router();
// const pdb = require('../db/products').static_products
const product_class = require('../services/products')
const cart = require('../services/cart_service').cart
server.get('/status',(rq,resp)=>{
    resp.status(200).json({
        message:'Hit to product success'
    })
})
data_objs=[]
server.get('/all',(rq,resp)=>{
   
    data = product_class.return_products()
    resp.status(200).json({
        datas:data
    })
})

server.get('/search/:id',(req,resp)=>{
    id = req.params.id;
    // console.log(id)
    // console.log(product_class.all_products)
    details =product_class.serach_detail(id)
    // console.log(details)
    resp.status(200).json({
        mes:details
    })
})

server.post('/tocart',(rq,resp)=>{
    resp.status(200).json({
    status: cart._addtocart(rq.body),
    body:cart._displaycart()
    })
})
module.exports={
    productRouter:server
}