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


check_otp=(name,email,otp,callback)=>{
    console.log(name,email,otp)
    mongodb.connect(mongo_const.url,(err,conn)=>{
        conn.db(mongo_const.db).collection(mongo_const.collections).find({name:name,email:email,otp:otp}).toArray((err,res)=>{
          
           ttl =res[0].ttl;
           console.log(ttl)
           console.log('ress======',res[0])
           now_time=  Date.now()
           console.log("now",now_time)
           
            if(ttl > now_time){
                console.log("good to go")
                callback(1);
            }else{
                console.log("sorry otp expired")
                callback(0);
            }
        
        });
    })
}


update_db=(name,otp,pass,callback)=>{
    mongodb.connect(mongo_const.url,(err,conn)=>{
        conn.db(mongo_const.db).collection(mongo_const.collections).updateOne({name:name,otp:otp},{ $set: {pass: pass, active: "yes" }},(err,res)=>{
            if(!err){
                callback(1)
            }else
            callback(0)
        })
})
}

module.exports={
    gen_store,
    check_otp,
    update_db
}