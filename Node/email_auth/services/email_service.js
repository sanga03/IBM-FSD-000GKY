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
        this.mailer = nodemailer.createTransport(this.smtpSetup);
    }

    send_email(to,body){
        this.mailer.send_email({
            from:this.smtpSetup.auth.user,
            to:to,
            subject:'verify Otp',
            html:body
        },(err,resp)=>{
            if(err){
                console.log(err);
                return "Unable to send email";
            }else{
                console.log('Email Sent');
                return "Email Sent Successfully";
            }
        })
    }
}

module.exports={
    Email
}