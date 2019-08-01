mailer = require('nodemailer')
class Email{
    constructor(){
        this.smtpSetup={
            service:'gmail',
            auth:{
                user : 'ibmtechtraining007@gmail.com',
                pass : 'India@786'
            }
        }
        this.mailer = mailer.createTransport(this.smtpSetup);
    }

    send_email(to,body,callback){
       let flag =0;
        console.log(to)
        this.mailer.sendMail({
            from:this.smtpSetup.auth.user,
            to:to,
            subject:'verify Otp',
            html:body
        },(err,resp)=>{
            if(err){
                console.log(err);
               callback(0);
            }else{
                console.log('Email Sent');
                callback(1);
            }
        })
    //  return flag;
    }
}

module.exports={
    Email
}