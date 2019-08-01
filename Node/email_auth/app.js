Server = require('express')
server = Server()
parser = require('body-parser')
cors = require('cors')
emailRoute = require('./api/email').router

server.use(parser.json())
server.use(cors())

server.get('/status',(rq,rs)=>{
    rs.status(200).json({
        message:"Hit Success"
    })
})
server.use('/email_auth',emailRoute)

server.listen(8800,()=>{
    console.log("server Started at 8800")
})