server =  require('express').Router()

server.get('/add/:one/:two',(rq,resp)=>{
    n1=parseInt(rq.params.one);
    n2=parseInt(rq.params.two);
    result = n1+n2;
    resp.end(JSON.stringify({
        result:result
    }))
})
server.get('/sub/:one/:two',(rq,resp)=>{
    n1=parseInt(rq.params.one);
    n2=parseInt(rq.params.two);
    result = n1-n2;
    resp.end(JSON.stringify({
        result:result
    }))
})
server.get('/mul/:one/:two',(rq,resp)=>{
    n1=parseInt(rq.params.one);
    n2=parseInt(rq.params.two);
    result = n1*n2;
    resp.end(JSON.stringify({
        result:result
    }))
})
server.get('/div/:one/:two',(rq,resp)=>{
    n1=parseInt(rq.params.one);
    n2=parseInt(rq.params.two);
    result = n1/n2;
    resp.end(JSON.stringify({
        result:result
    }))
})
server.get('/mod/:one/:two',(rq,resp)=>{
    n1=parseInt(rq.params.one);
    n2=parseInt(rq.params.two);
    result = n1%n2;
    resp.end(JSON.stringify({
        result:result
    }))
})
server.get('/status',(rq,resp)=>{
    resp.end(JSON.stringify({
        message:"Caluclator Hit Success"
    }))
})

module.exports={
    server_calc:server
};