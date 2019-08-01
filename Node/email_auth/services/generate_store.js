mongodb = require('mongodb').MongoClient
mongo_const=require('./mongo_const').mongo_const
email_class =require('../services/email_service').Email

gen_store=(name,email,phone,callback )=>{
    email_obj= new email_class()
    var now = Date.now();
    next = now + 600000;
    otp = otp_genarate();
    email_1={
        name:name,
        email:email,
        phone:phone,
        otp:otp,
        ttl:next
    }
    dd=new Date(next).toString()
    html_body=`please check the otp: <b>${otp}</b> which expires by <b><i>${dd}</i></b>`

   sent= email_obj.send_email(email,html_body,(resp)=>{
       if(resp==1){
        console.log(sent);
        mongodb.connect(mongo_const.url,(err,conn)=>{
            conn.db(mongo_const.db).collection(mongo_const.collections).insertOne({name:name,
                email:email,
                phone:phone,
                otp:otp,
                ttl:next},(err,res)=>{
                if(!err){
                    console.log("Insertec");
                    callback(err,res)
                }
            })
        })
       }else{
        console.log("email not sent")
        callback("email not sent")
       }
   });

}

otp_genarate=()=>{
    list = "QWERTYUIOPASDFGHJKLZXCVBNM0192345678";
    OTP =''
    for (let i = 0; i <8 ; i++) {
    OTP+=list[Math.floor(Math.random()*list.length)]        
    }
    return OTP;
}

module.exports={
    gen_store
}