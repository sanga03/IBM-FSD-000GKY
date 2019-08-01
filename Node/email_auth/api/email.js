router = require('express').Router()
email_class = require('../services/email_service').Email
router.post('/send',(rq,rs)=>{
    email = rq.body.email;
    name = rq.body.name;
    phone = rq.body.phone;

})