const express = require('express');
const server =express();
const parser = require('body-parser');
server.use(parser.json());

server.get('/status',(rq,resp)=>{
    resp.status(200).json({
        message:'service is running'
    });
});
PORT = 8899;
server.listen(PORT,()=>{
    console.log(`Server Started at ${PORT}`);
});
