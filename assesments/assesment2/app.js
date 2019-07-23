eserver = require('express');
const product_class = require('./services/products')

productRouter = require('./apis/product').productRouter;
cartRouter = require('./apis/cart_api').cartRouter;
server = eserver()
const parser = require('body-parser');
server.use(parser.json());
const cors = require('cors');
server.use(cors());
product_class.add_all_products_once()

server.get('/status',(req,reep)=>{
    reep.status(200).json({
        message:"hit success"
    })
})
server.use('/products',productRouter);
server.use('/cart',cartRouter);
server.listen(8800,()=>{
    console.log("server started");
});
