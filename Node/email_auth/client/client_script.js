onloadz=()=>{
    $('#btnSubmit').click(()=>{
        name = $('#name').val()
        phone = $('#phone').val()
        email = $('#email').val()
        console.log(email)
        // console.log(name)
        url="http://localhost:8800/email_auth/send"
        fetch(url,{
            method:'post',
            headers:{
                'Accept': 'application/json',
                'Content-Type': 'application/json'
              
            },
            body:JSON.stringify({
                name:name,
                phone:phone,
                email:email
            })
        }).then(res=>res.json()).then(res=>{
            
            console.log(res.message)
            alert(res.message)
            if(res.message=="inserted Success"){
                $('#message').html('<b>please check your mail</b>')
                $('#otp').html(' <input type="text" class="form-control"id="otp_id" placeholder="otp" value=""/>')
                $('#otp_btn').html(' <input type="button" class="form-control btn"id="otp_click"  value="proceed"/>')
            
                $('#otp_click').click(()=>{
                otp=$('#otp_id').val()
                console.log(otp)
                url="http://localhost:8800/email_auth/check_otp"
                fetch(url,{
                    method:'post',
                    headers:{
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                      
                    },
                    body:JSON.stringify({
                        name:name,
                        email:email,
                        otp:otp
                    })
                }).then(res=>res.json()).then(res=>{
                    if(res.status==1){
                        alert('login Success')
                        $('#pass').html(' <input type="text" class="form-control"id="pass_id" placeholder="password" value=""/>')
                        $('#repass').html(' <input type="text" class="form-control"id="repass_id" placeholder="re password" value=""/>')
                        $('#pass_btn').html(' <input type="button" class="form-control btn" id="pass_click"  value="move on"/>')
                        $('#pass_click').click(()=>{
                            // alert(2)
                            pass= $('#pass_id').val()
                            repass= $('#repass_id').val()
                            console.log(pass,repass);
                            if(pass=repass){
                                alert('asd')
                                url="http://localhost:8800/email_auth/pass"
                                fetch(url,{
                                    method:'post',
                                    headers:{
                                        'Accept': 'application/json',
                                        'Content-Type': 'application/json'
                                      
                                    },
                                    body:JSON.stringify({
                                        name:name,
                                        pass:pass,
                                        otp:otp
                                    })
                                }).then(res=>res.json()).then(res=>{
                                    if(res.status==1){
                                        console.log('pass updated successfull')
                                    }else{
                                        console.log('pass not updated successfull')
                                    }
                                })
                            }
                        })

                    }else  alert('login not Success')
                })
            })
                
            }else if(res.message=="email not sent"){
                $('#message').html('<b>enter correct mail</b>')
            }else{
                $('#message').html('<b>database error </b>')
            }
        })
    })


}