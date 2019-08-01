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

    send_email(to,body){
        this.mailer.sendMail({
            from:this.smtpSetup.auth.user,
            to:to,
            subject:'verify Otp',
            html:body
        },(err,resp)=>{
            if(err){
                console.log(err);
                return 0;
            }else{
                console.log('Email Sent');
                return 1;
            }
        })
    }
}

module.exports={
    Email
}