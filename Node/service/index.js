const http = require('http')
const url = require('url')
const findUser = require('./data')
const findUs = new findUser.Userfind()

ser =http.createServer((req,resp)=>{
    const paramerters = url.parse(req.url,true);
    uname = paramerters.query.user;
    pass = paramerters.query.pass;
    console.log(paramerters);
    if(paramerters.pathname==='/login'){
        resp.setHeader('Access-Control-Allow-Origin','*');
        console.log("in server");
        response = findUs.returnUser(uname,pass)
        if(response != undefined && response != null){
            resp.end(JSON.stringify(response));
        }else{
            resp.end(SON.stringify([{
                id:0,
                name:null,
                pass:null,
                status:0
            }]))
        }
      
    }
})

ser.listen(8800)