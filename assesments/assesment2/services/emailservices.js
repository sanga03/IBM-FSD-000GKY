const nodemailer = require('nodemailer');
class Email {
    constructor(){
        this.smtpSetup = {
            service :'gmail',
            auth :{
                user : 'ibmtechtraining007@gmail.com',
                pass : 'India@786'
            }
        }
        // configure the smtp settings
        this.mailer = nodemailer.createTransport(this.smtpSetup);
    }
    email_send(to,body){
       
        this.mailer.sendMail({
            from : 'smartcart@gmail.com',
            to : to,
            subject :"check out cart and checkout",
            html :body
            // ,
            // attachments: [
            //     {
            //         filename : 'checkout.txt',
            //         path : __dirname +'/' +'checkout.txt'
            
            //     }
            // ] 
        },(err,response)=>{
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
  
module.exports.Email = Email;