server = require('express')
parser = require('body-parser')
cors = require('cors')
t_router = require('./api/tic_tac.api').router

Server = server()
Server.use(parser.json())
Server.use(cors())

Server.get('/status',(req,resp)=>{
    resp.status(200).json({
        message:"Hit Success"
    
    })
})

Server.use('/api/tictac',t_router)

Server.listen(8899,()=>{
    console.log("server started ")
})