express = require('express')
parser=require('body-parser')
const calc_ap=require('./apis/calculate').server_calc;
server = express()
server.use(parser.json())
server.get('/status',(rq,resp)=>{
    resp.end(JSON.stringify({
        message:"status hit"
    }))
})
server.use('/calculate',calc_ap);

server.listen(8800,()=>{
    console.log("server started at 8800")
})