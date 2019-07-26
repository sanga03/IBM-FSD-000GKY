validator=(rq,resp,next)=>{
    const user = rq.headers.user
    console.log(user)
    // next();
    resp.redirect('/unauthorize');
}

module.exports={validator:validator}