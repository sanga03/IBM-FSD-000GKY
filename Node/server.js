const http = require('http')
const url = require('url')

ser =http.createServer((req,resp)=>{
    const paramerters = url.parse(req.url,true);
    console.log(paramerters);
    if(req.url===paramerters.pathname){
        console.log("in server");
    }
})

ser.listen(1234)